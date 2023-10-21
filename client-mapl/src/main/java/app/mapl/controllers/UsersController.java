package app.mapl.controllers;

import app.mapl.config.security.AuthService;
import app.mapl.dto.JWTAuthResponse;
import app.mapl.dto.LoginDto;
import app.mapl.dto.RegisterDto;
import app.mapl.dto.UserDto;
import app.mapl.exception.ResourceNotFoundException;
import app.mapl.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@SessionAttributes("name")
//@Api(tags={"Users"})
public class UsersController {
    static final Logger log = LoggerFactory.getLogger(UsersController.class);

    private PasswordEncoder bcrypt;

    private UsersService usersService;
    private AuthService authService;
    public static final String USER_PATH = "/api/users";
    public static final String USER_PATH_ID = USER_PATH + "/{userId}";

    @Autowired
    public UsersController(AuthService authService, UsersService usersService, PasswordEncoder bcrypt) {
        this.bcrypt = bcrypt;
        this.authService = authService;
        this.usersService = usersService;
    }


    @Operation(
            summary = "login User By ID REST API and JWT Authentication",
            description = "login User By ID REST API is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PostMapping(value = {"/auth/login", "/auth/signin"}, consumes = "application/x-www-form-urlencoded; charset=utf-8")
    public ResponseEntity<JWTAuthResponse> loginUser(@RequestParam String usernameOrEmail, @RequestParam String password
    ) {
        LoginDto ldto = new LoginDto();
        ldto.setUsernameOrEmail(usernameOrEmail);
        log.info("Login user usernameOrEmail =========={}", usernameOrEmail);
        log.info("Login user password =========={}", password);

        ldto.setPassword(bcrypt.encode(password));
        log.info(" ldto.setPassword(bcrypt.encode(password)) =========={}", ldto.getPassword());

        String token = authService.login(ldto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
//        return new ResponseEntity<>(
//                usersService.loginUser(lDto.getUsernameOrEmail(), lDto.getPassword()),
//                HttpStatus.OK);
    }

    @Operation(
            summary = "Create User REST API  registerUser",
            description = "Create User REST API is used to save user in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
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

    @Operation(
            summary = "Get All Users REST API",
            description = "Get All Users REST API is used to get a all the users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping(USER_PATH)
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> users = new ArrayList<>();
        try {
            users = usersService.getUsers();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(users,
                HttpStatus.OK);
    }

    @Operation(
            summary = "Get User By ID REST API",
            description = "Get User By ID REST API is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping(value = USER_PATH_ID)
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") int userId) {
        if(usersService.getUser(userId).isEmpty()) {
            throw new ResourceNotFoundException("User " + userId + "not found");
        }
        return new ResponseEntity<>(usersService.getUser(userId).get(), HttpStatus.OK);
    }

    @Operation(
            summary = "Get User By EMAIL REST API",
            description = "Get User By EMAIL REST API is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping(value = USER_PATH+ "/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable("email") String email) {
        if(usersService.getUser(email).isEmpty()) {
            throw new ResourceNotFoundException("User " + email + "not found");
        }
        return new ResponseEntity<>(usersService.getUser(email).get(), HttpStatus.OK);
    }

    /// Non-Register Creation Request
    @PostMapping(USER_PATH)
    public ResponseEntity createUser(@RequestBody UserDto user) {
        UserDto savedUser = usersService.createUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", USER_PATH + "/" + savedUser.getUserId());

        return new ResponseEntity(savedUser, headers, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a particular user in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping(value = USER_PATH + "/{userId}", consumes = "application/json")  // userId in body
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") int userId, @RequestBody UserDto userDto) {
        Optional<UserDto> updated = usersService.updateUser( userDto);
        return updated.map(dto -> new ResponseEntity<>(
                dto,
                HttpStatus.CREATED)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }




    @Operation(
            summary = "Patch User REST API",
            description = "Patch User REST API is used to patch - partially update -  a particular user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PatchMapping(USER_PATH_ID)
    public ResponseEntity<UserDto> patchUserById(@PathVariable("userId") Integer userId,
                                                 @RequestBody UserDto user) {

        usersService.patchUserById(userId, user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API is used to delete a particular user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping(value = USER_PATH_ID)
    public ResponseEntity<Boolean> deleteUser(@PathVariable("userId") int userId) {
        Boolean boolSuccess = null;

        Optional<UserDto> tempUser = usersService.getUser(userId);
        if (tempUser == null) throw new ResourceNotFoundException("User " + userId + "not found to delete");
        try {
            boolSuccess = usersService.deleteUser(String.valueOf(tempUser));
            if (boolSuccess) {
                return new ResponseEntity<>(boolSuccess, HttpStatus.OK);
            }
            ;
            return new ResponseEntity<>(boolSuccess, HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return new ResponseEntity<>(boolSuccess, HttpStatus.NO_CONTENT);
        } catch (ConstraintViolationException exception) { // || DataIntegrityViolationException e){

            return new ResponseEntity<>(boolSuccess, HttpStatus.NO_CONTENT);
        }
    }


//    public List<String> getUsersByCoins();

//    public User getUserByPassword(String username, String password) {
//        return null;
//    }ResponseEntity

}
