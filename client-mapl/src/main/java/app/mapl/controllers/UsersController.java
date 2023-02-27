package app.mapl.controllers;

import app.mapl.dto.UserDto;
import app.mapl.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import app.mapl.models.User;
import app.mapl.service.UsersService;

import java.util.List;


@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
//@Api(tags={"Users"})
public class UsersController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private UsersService usersService;

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(
                usersService.createUser(
                        userMapper.userDtoToUser(userDto)),
                 HttpStatus.CREATED);
    }
    @GetMapping(value="/users/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") int userId) {
        return new ResponseEntity<>(
                userMapper.userToUserDto(
                        usersService.getUser(userId)),
                HttpStatus.OK);
    }
    @GetMapping(value="/users/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(
                userMapper.userToUserDto(
                        usersService.getUser(email)),
                HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(
                userMapper.usersToUserDtos(
                        usersService.getUsers()),
                HttpStatus.OK);
    }

    @PutMapping(value="/users", consumes="application/json")  // userId in body
    public ResponseEntity<User> updateUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(
                usersService.createUser(
                        userMapper.userDtoToUser(userDto)),
                HttpStatus.CREATED);
    }

    @DeleteMapping(value="/users/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") int userId) {
        try {
            usersService.deleteUser(usersService.getUser(userId));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


//    public List<String> getUsersByCoins();

//    public User getUserByPassword(String username, String password) {
//        return null;
//    }ResponseEntity

}
