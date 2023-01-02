package net.cryptomaven.mappings.controller;

import net.cryptomaven.mappings.dto.UserLocationDTO;
import net.cryptomaven.mappings.model.User;
import net.cryptomaven.mappings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
@Autowired
    private UserService userService;

//@PostMapping("/user");

//    public ResponseEntity<User> saveUser(@RequestBody  UserDTO userDTO) {
//        return ResponseEntity.ok(userService.saveuser(userDTO));
//    }

    @GetMapping("users-location")
    public List<UserLocationDTO> getAllUsersLocation() {
    return userService.getAllUsersLocation();
}

}
