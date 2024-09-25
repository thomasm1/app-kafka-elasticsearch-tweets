package com.friendsofgroot.app.controllerTests;
import com.friendsofgroot.app.controllers.UsersController;
import com.friendsofgroot.app.exception.ResourceNotFoundException;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.repositories.UsersRepository;
import com.friendsofgroot.app.mapper.UserMapper;
import com.friendsofgroot.app.models.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UsersControllerIT {

    @Autowired
    UsersRepository userRepository;

    @Autowired
    UsersController usersController;

    @Autowired
    UserMapper userMapper;

    @Rollback
    @Transactional
    @Test
    void deleteByIdFound() {
        User user = userRepository.findAll().get(0);

        ResponseEntity<Boolean> responseEntity = usersController.deleteUser(user.getUserId());
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        assertThat(userRepository.findById(user.getUserId()).isEmpty());
    }

    @Test
    void testDeleteNotFound() {
        assertThrows(ResourceNotFoundException.class, () -> {
            usersController.deleteUser((int)Math.floor(Math.random()));
        });
    }

    @Test
    void testUpdateNotFound() {
        assertThrows(ResourceNotFoundException.class, () -> {
            usersController.updateUser((int) Math.floor(Math.random()), UserDto.builder().build());
        });
    }

    @Rollback
    @Transactional
    @Test
    void updateExistingChain() {
        User user = userRepository.findAll().get(0);
        UserDto userDto = userMapper.toDto(user);
        userDto.setUserId(1000);
        final String userName = "UPDATED";
        userDto.setUsername(userName);

        ResponseEntity responseEntity = usersController.updateUser(user.getUserId(), userDto);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        User updatedUser = userRepository.findById(user.getUserId()).get();
        assertThat(updatedUser.getUsername()).isEqualTo(userName);
    }

    @Rollback
    @Transactional
    @Test
    void saveNewChainTest() {
       UserDto userDto = UserDto.builder()
               .username("TEST")
               .build();

        ResponseEntity responseEntity = usersController.registerUser(userDto);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(responseEntity.getHeaders().getLocation()).isNotNull();

        String[] locationID = responseEntity.getHeaders().getLocation().getPath().split("/");
        Integer savedID = Integer.parseInt(locationID[4]);

        User user = userRepository.findById(savedID).get();
        assertThat(user).isNotNull();
    }

    @Rollback
    @Transactional
    @Test
    void testListAllEmptyList() {
        userRepository.deleteAll();
        List<UserDto> dtos = usersController.getUsers().getBody();

        assertThat(dtos.size()).isEqualTo(0);
    }

    @Test
    void testListAll() {
        List<UserDto> dtos = usersController.getUsers().getBody();

        assertThat(dtos.size()).isEqualTo(3);
    }

    @Test
    void testGetByIdNotFound() {
        assertThrows(ResourceNotFoundException.class, () -> {
            usersController.getUser((int) Math.floor(Math.random()));
        });
    }

    @Test
    void testGetById() {
        User user = userRepository.findAll().get(0);
        UserDto userDto = usersController.getUser(user.getUserId()).getBody();
        assertThat(userDto).isNotNull();
    }

}
