package net.cryptomaven.mappings.controller;

import net.cryptomaven.mappings.dto.UserLocationDTO;
import net.cryptomaven.mappings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
@Autowired
    private UserService userService;

@GetMapping("users-location")
    public List<UserLocationDTO> getAllUsersLocation() {
    return userService.getAllUsersLocation();
}

}
