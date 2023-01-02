package xyz.cryptomaven.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.cryptomaven.app.models.User;
import xyz.cryptomaven.app.service.UsersService;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return usersService.getUsers();
    }

}
