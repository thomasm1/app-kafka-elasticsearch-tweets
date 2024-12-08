package com.friendsofgroot.app.controllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendsofgroot.app.controllers.UsersController;
import com.friendsofgroot.app.models.dto.UserDto;
import com.friendsofgroot.app.service.UsersService;
import com.friendsofgroot.app.service.UsersServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsersController.class)
 class UsersControllerTestMVC {

    @MockBean
    UsersService userService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    UsersServiceImpl userServiceImpl;

    @BeforeEach
    void setUp() {
        userServiceImpl = new UsersServiceImpl();
    }

    @Captor
    ArgumentCaptor<Integer> uuidArgumentCaptor;

    @Captor
    ArgumentCaptor<UserDto> userArgumentCaptor;

    @Test
    void testPatchUser() throws Exception {
        UserDto user = userServiceImpl.getUsers().get(0);

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("name", "New Name");

        mockMvc.perform(patch( UsersController.USER_PATH_ID, user.getUserId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userMap)))
                .andExpect(status().isNoContent());


        assertThat(uuidArgumentCaptor.getValue()).isEqualTo(user.getUserId());
        assertThat(userArgumentCaptor.getValue().getUsername())
                .isEqualTo(userMap.get("userName"));
    }

    @Test
    void testDeleteUser() throws Exception {
        UserDto user = userServiceImpl.getUsers().get(0);

        given(userService.deleteUser((String) any()));

        mockMvc.perform(delete(UsersController.USER_PATH_ID, user.getUserId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(userService).deleteUser(String.valueOf(uuidArgumentCaptor.capture()));

        assertThat(user.getUserId()).isEqualTo(uuidArgumentCaptor.getValue());
    }

    @Test
    void testUpdateUser() throws Exception {
        UserDto user = userServiceImpl.getUsers().get(0);

        given(userService.updateUserById(any(), any())).willReturn(Optional.of(UserDto.builder()
                .build()));

        mockMvc.perform(put(UsersController.USER_PATH_ID, user.getUserId())
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

//        verify(userService).updateUserById(uuidArgumentCaptor.capture(), any(UserDto.class));

        assertThat(user.getUserId()).isEqualTo(uuidArgumentCaptor.getValue());
    }

    @Test
    void testRegisterUser() throws Exception {
        UserDto user = userServiceImpl.getUsers().get(0);
        user.setUserId(444);


        given(userService.registerUser(any(UserDto.class)))
                .willReturn(userServiceImpl.getUsers().get(1));

        mockMvc.perform(post(UsersController.USER_PATH).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }

    @Test
    void listAllUsers() throws Exception {
        given(userService.getUsers()).willReturn(userServiceImpl.getUsers());

        mockMvc.perform(get(UsersController.USER_PATH)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(3)));
    }

    @Test
    void getUserByIdNotFound() throws Exception {

        given(userService.getUser(any(Integer.class))).willReturn(null);

        mockMvc.perform(get(UsersController.USER_PATH_ID, (int) Math.floor(Math.random()*31)))
                .andExpect(status().isNotFound());
    }

    @Test
    void getUserById() throws Exception {
        UserDto user = userServiceImpl.getUsers().get(0);

        given(userService.getUser(user.getUserId())).willReturn(user);

        mockMvc.perform(get(UsersController.USER_PATH_ID, user.getUserId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(user.getUsername())));
    }
}
