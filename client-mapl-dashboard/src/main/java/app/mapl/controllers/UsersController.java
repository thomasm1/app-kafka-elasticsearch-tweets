package app.mapl.controllers;

import app.mapl.models.auth.APIResponseDto;
import app.mapl.models.auth.LoginDto;
import app.mapl.models.auth.User;
import app.mapl.models.auth.UserRequest;
import app.mapl.models.auth.UserResponse;
import app.mapl.exception.ResourceNotFoundException;
import app.mapl.models.dto.UserDto;
import app.mapl.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.web.exchanges.HttpExchange.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static app.mapl.models.auth.AuthenticationFilter.getResponse;
import static java.util.Collections.emptyMap;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@SessionAttributes("name")
public class UsersController {
    public static final String HTTP_LOCALHOST_8080_API_USER_ENTITY = "http://localhost:8888/api/users";
    static final Logger log = LoggerFactory.getLogger(UsersController.class);

    private PasswordEncoder bcrypt;

    private UsersService usersService;
    AuthenticationManager authenticationManager;
    public static final String USER_PATH = "/api";
    public static final String USER_PATH_ID = USER_PATH + "/users/{userId}";

    @Autowired
    public UsersController( UsersService usersService ) { 
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
    public ResponseEntity<LoginDto> loginUser(@RequestParam String usernameOrEmail, @RequestParam String password
    ) {
        LoginDto ldto = new LoginDto();
        ldto.setUsernameOrEmail(usernameOrEmail);
        log.info("Login user usernameOrEmail =========={}", usernameOrEmail);
        log.info("Login user password =========={}", password);

        ldto.setPassword(bcrypt.encode(password));
        log.info(" ldto.setPassword(bcrypt.encode(password)) =========={}", ldto.getPassword());

        return new ResponseEntity<>(ldto,HttpStatus.CREATED);
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
    public ResponseEntity<Response> registerUser(@RequestBody @Valid UserRequest user, HttpServletRequest request) {
        usersService.createUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        return ResponseEntity.created(getUri()).body( getResponse(request, emptyMap(), "AccountCreated", CREATED));
    }

    @Operation(
            summary = "Verify Account REST API",
            description = "Verify Account REST API is used to verify a user account"
    )
    @GetMapping("/auth/verify/account")
    public ResponseEntity<Response> verifyAccount(@RequestParam("key") String key, HttpServletRequest request){
        usersService.verifyAccountKey(key);
        return ResponseEntity.ok().body(  getResponse(request, emptyMap(), "Account Verified.", OK));
    }

    @PostMapping("/auth/test")
    public ResponseEntity<?> test(@RequestBody UserRequest userRequest ) {
        Authentication authenticate = authenticationManager.authenticate(UsernamePasswordAuthenticationToken.unauthenticated(userRequest.getEmail(), userRequest.getPassword()));
        return ResponseEntity.ok().body(Map.of("user", authenticate));
    }

    @Operation(
            summary = "Save User REST API",
            description = "Save User REST API is used to save a user in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping(value = "/users/userEntity", consumes = "application/json")
    public ResponseEntity<Response> saveUser(@RequestBody @Valid  UserRequest user, HttpServletRequest request){
        User savedUser = usersService.createUserRole(
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword());
        return ResponseEntity.created(getUri()).body(  getResponse(request, emptyMap(), "AccountCreated", OK));
    }
    private URI getUri() {
        return URI.create(HTTP_LOCALHOST_8080_API_USER_ENTITY);
    }

    @Operation(
            summary = "Get All Users REST API",
            description = "Get All Users REST API is used to get a all the users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping(USER_PATH+"/users")
    public ResponseEntity<List<UserResponse>> getUsers() {
        List<UserResponse> users = new ArrayList<>();

        try {
            users = usersService.getUsersResponse();

        }   catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(users,
                OK);
    }

    @Operation(
            summary = "Get User By ID REST API",
            description = "Get User By ID REST API is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // http://localhost:8080/api/users/1
    @GetMapping(value = USER_PATH_ID)
    public ResponseEntity<UserDto> getUser(@PathVariable("userId") int userId) {
        if(usersService.getUser(userId).isEmpty()) {
            throw new ResourceNotFoundException("User " + userId + "not found");
        }
        return new ResponseEntity<>(usersService.getUser(userId).get(), OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getUserById(@PathVariable("id") Long userEntityId){
        APIResponseDto apiResponseDto = usersService.getUserById(userEntityId);
        return   ResponseEntity.ok().body(apiResponseDto);
    }
    @Operation(
            summary = "Get User By EMAIL REST API",
            description = "Get User By EMAIL REST API is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping(value = USER_PATH+ "/users/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable("email") String email) {
        if(usersService.getUser(email).isEmpty()) {
            throw new ResourceNotFoundException("User " + email + "not found");
        }
        return new ResponseEntity<>(usersService.getUser(email).get(), OK);
    }

    /// Non-Register Creation Request
    @PostMapping(USER_PATH+"/users")
    public ResponseEntity createUser(@RequestBody UserRequest user) {
        ResponseEntity<UserResponse> savedUser = usersService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", USER_PATH + "/" + savedUser.getBody().getUserId());

        return new ResponseEntity(savedUser, headers, CREATED);
    }


    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a particular user in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping(value = USER_PATH + "/users/{userId}", consumes = "application/json")  // userId in body
    public ResponseEntity<UserDto> updateUser(@PathVariable("userId") int userId, @RequestBody UserDto userDto) {
        Optional<UserDto> updated = usersService.updateUser(userDto);
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
                return new ResponseEntity<>(boolSuccess, OK);
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

}
