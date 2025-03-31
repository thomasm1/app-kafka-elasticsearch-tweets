package app.mapl.maplgraph.controller;

import java.util.List;

import app.mapl.maplgraph.request.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.mapl.maplgraph.entity.User;
import app.mapl.maplgraph.request.CreateUserRequest;
import app.mapl.maplgraph.request.GetUsersByUserTypeRequest;
import app.mapl.maplgraph.service.UserService;

@RestController
@RequestMapping("/api/users/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/create")
	public User createUser(@RequestBody CreateUserRequest createUserRequest) {
		return userService.createUser(createUserRequest);
	}
	
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/getUserByName/{name}")
	public List<User> getUsersByName(@PathVariable String name) {
		return userService.getUsersByName(name);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody UpdateUserRequest updateUserRequest) {
		return userService.updateUser(updateUserRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable long id) {
		return userService.deleteUser(id);
	}
	
	@GetMapping("/getUserByNameAndUserType/{name}/{userType}")
	public List<User> getUserByNameAndUserType(@PathVariable String name, 
			@PathVariable Integer userType) {
		return userService.getUserByNameAndUserType(name, userType);
	}
	
	@GetMapping("/getUserByNameOrUserType/{name}/{userType}")
	public List<User> getUserByNameOrUserType(@PathVariable String name, 
			@PathVariable Integer userType) {
		return userService.getUserByNameOrUserType(name, userType);
	}
	
	@GetMapping("/getUsersByUserType")
	public List<User> getUserByNameOrUserType(
			@RequestBody GetUsersByUserTypeRequest req) {
		return userService.getUserByNameOrUserType(req);
	}
	
	@GetMapping("/getUsersWithPagination")
	public List<User> getUsersWithPagination(@RequestParam int pageNo, 
			@RequestParam int pageSize) {
		return userService.getUsersWithPagination(pageNo, pageSize);
	}
	
	@GetMapping("/getUsersWithSorting")
	public List<User> getUsersWithSorting() {
		return userService.getUsersWithSorting();
	}
	
	@GetMapping("/getUsersByNameLike/{name}")
	public List<User> getUsersByNameLike(@PathVariable String name) {
		return userService.getUsersByNameLike(name);
	}
	
	@GetMapping("/getUsersByNameStartsWith/{name}")
	public List<User> getUsersByNameStartsWith(@PathVariable String name) {
		return userService.getUsersByNameStartsWith(name);
	}
	
}
