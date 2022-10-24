package main.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.entities.User;
import main.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/getById/{id}")
    public User getUserbyId(@PathVariable String id) {
        return userService.getUserbyId(id);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/usersByName/{name}")
    public List<User> usersByName(@PathVariable String name) {
        return userService.getUsersByName(name);
    }

    @GetMapping("/usersByNameAndMail")
    public User usersByNameAndMail(@RequestParam String name,
                                   @RequestParam String email) {
        return userService.usersByNameAndMail(name, email);
    }

    @GetMapping("/usersByNameOrMail")
    public User usersByNameOrMail(@RequestParam String name,
                                  @RequestParam String email) {
        return userService.usersByNameOrMail(name, email);
    }

    @GetMapping("/allWithPagination")
    public List<User> getAllWithPagination(@RequestParam int pageNo,
                                           @RequestParam int pageSize) {
        return userService.getAllWithPagination(pageNo, pageSize);
    }

    @GetMapping("/allWithSorting")
    public List<User> allWithSorting() {
        return userService.allWithSorting();
    }

    @GetMapping("/byDepartmentName")
    public List<User> byDepartmentName(@RequestParam String deptName) {
        return userService.byDepartmentName(deptName);
    }

    @GetMapping("/bySubjectName")
    public List<User> bySubjectName(@RequestParam String subName) {
        return userService.bySubjectName(subName);
    }

    @GetMapping("/emailLike")
    public List<User> emailLike(@RequestParam String email) {
        return userService.emailLike(email);
    }

    @GetMapping("/nameStartsWith")
    public List<User> nameStartsWith(@RequestParam String name) {
        return userService.nameStartsWith(name);
    }
}
