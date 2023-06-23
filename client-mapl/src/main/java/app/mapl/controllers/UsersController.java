package app.mapl.controllers;

import app.mapl.dto.JWTAuthResponse;
import app.mapl.dto.LoginDto;
import app.mapl.dto.RegisterDto;
import app.mapl.dto.UserDto;
import app.mapl.config.security.AuthService;
import app.mapl.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
@SessionAttributes("name")
//@Api(tags={"Users"})
public class UsersController {

    PasswordEncoder bcrypt;
    UsersService usersService;
    AuthService authService;

    @Autowired
    public UsersController(   UsersService usersService) {
        this.usersService = usersService;
    }
    public UsersController(PasswordEncoder bcrypt, AuthService authService, UsersService usersService) {
        this.bcrypt = bcrypt;
        this.authService = authService;
        this.usersService = usersService;
    }

    @PostMapping(value = {"/auth/login", "/auth/signin"}, consumes = "application/x-www-form-urlencoded; charset=utf-8")
    public ResponseEntity<JWTAuthResponse> loginUser(@RequestParam String usernameOrEmail, @RequestParam String password
    ) {
        LoginDto ldto = new LoginDto();
        ldto.setUsernameOrEmail(usernameOrEmail);
        ldto.setPassword(bcrypt.encode(password));
        String token = authService.login(ldto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
//
//        return new ResponseEntity<>(
//                usersService.loginUser(lDto.getUsernameOrEmail(), lDto.getPassword()),
//                HttpStatus.OK);
    }
    //// API for user registration and login   ////

    @PostMapping(value = {"/auth/register", "/auth/signup"}, consumes = "application/x-www-form-urlencoded; charset=utf-8")
    public ResponseEntity<String> registerUser(@RequestParam String email, @RequestParam String password,
                                               @RequestParam String firstName, @RequestParam String lastName) {
        RegisterDto rdto = new RegisterDto();
        rdto.setEmail(email);
        rdto.setPassword(bcrypt.encode(password));
        rdto.setFirstName(firstName);
        rdto.setLastName(lastName);
        String response = authService.register(rdto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
//        return new ResponseEntity<>(
//                usersService.registerUser(rDto),
//                HttpStatus.CREATED);
    }

    //////////////////////////////////////////////////////////////
    //// GENERAL API for user management ////
    /////////////////////////////////////////////////////////
    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(
                usersService.createUser(userDto),
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/users/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") int userId) {
        return new ResponseEntity<>(
                usersService.getUser(userId).orElseThrow(),
                HttpStatus.OK);
    }

    @GetMapping(value = "/users/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(
                usersService.getUser(email).orElseThrow(),
                HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(
                usersService.getUsers(),
                HttpStatus.OK);
    }

    @PutMapping(value = "/users", consumes = "application/json")  // userId in body
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(
                usersService.createUser(userDto),
                HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/users/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") int userId) {
        try {
            usersService.deleteUser(usersService.getUser(userId).orElseThrow());
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
