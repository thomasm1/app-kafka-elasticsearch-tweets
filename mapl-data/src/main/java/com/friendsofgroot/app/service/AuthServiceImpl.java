package com.friendsofgroot.app.service;

import com.friendsofgroot.app.config.security.JwtTokenProvider;
import com.friendsofgroot.app.exception.ResourceNotFoundException;
import com.friendsofgroot.app.models.dto.LoginDto;
import com.friendsofgroot.app.models.dto.RegisterDto;
import com.friendsofgroot.app.exception.PostApiException;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.models.Role;
import com.friendsofgroot.app.models.dto.UserDto;
import com.friendsofgroot.app.repositories.RoleRepository;
import com.friendsofgroot.app.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import static com.friendsofgroot.app.config.security.SecurityConfig.passwordMaplEncoder;

@Service
public class AuthServiceImpl  implements AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthServiceImpl.class);
    private AuthenticationManager authenticationManager;
    private UsersRepository usersRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(AuthenticationManager authenticationManager, UsersRepository usersRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    /**
     * @param loginDto
     * @return
     */
    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }
//
//    /**
//     * @param usernameOrEmail
//     * @param password
//     * @return
//     */
//    @Override
//    public UserDto loginUser(String usernameOrEmail, String password) {
//        User  u = usersRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", usernameOrEmail));
//
//        if ( u.getPassword().equals(password)) {
//            return userMapper.toDto(u) ;
//        } else {
//            return null;
//        }
//    }
    /**
     * @param registerDto
     * @return String
     */
    @Override
    public String register(RegisterDto registerDto) {

        // add check for username exists in database
        if(usersRepository.existsByUsername(registerDto.getUsername())){
            throw new PostApiException(HttpStatus.BAD_REQUEST, "Username is already exists!.");
        }

        // add check for email exists in database
        if(usersRepository.existsByEmail(registerDto.getEmail())){
            throw new PostApiException(HttpStatus.BAD_REQUEST, "Email is already exists!.");
        }

        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setFirstName(registerDto.getFirstName());
        user.setUsername(registerDto.getUsername());

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);

        usersRepository.save(user);

        return "User registered successfully!.";
    }

//    /**
//     * @param registerDto
//     * @return  UserDto
//     */
//    @Override
//    public UserDto registerUser(RegisterDto registerDto) {
//
//        UserDto newUser = UserDto.builder()
//                .lastName(registerDto.getLastName())
//                .username(registerDto.getUsername())
//                .password(registerDto.getPassword())
////                .dateCreated(registerDto.getDateCreated())
////                .lastUpdated(LocalDateTime.now())
//                .build();
//        User u = usersRepository.save(userMapper.toEntity(newUser));
//        return userMapper.toDto(u);
//    }


    /////////////////////////////////////////

    private UserDetails createNewUser(String username, String password) {
        log.info("createNewUser");

        Function<String, String> passwordEncoding
                = input -> passwordMaplEncoder().encode(input);

        return org.springframework.security.core.userdetails.User.builder()
                .passwordEncoder(passwordEncoding)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
    }

    // DISABLE WHEN CONNECTED TO LDAP or DB
    @Bean
    @Profile(value = {"!prod"})
    InMemoryUserDetailsManager createUserDetailsManager() {
        log.info("createUserDetailsManager");

        UserDetails userDetails1 = createNewUser("admin1", "password1");

        UserDetails userDetails2 = org.springframework.security.core.userdetails.User.builder()
                .username("guest")
                .password(passwordMaplEncoder().encode("guest"))
                .authorities(new SimpleGrantedAuthority("USER"))
                .build();
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

//////////////////// CUSTOM

    static final String ADMIN = "admin";
    static final String ADMIN_PASSWORD = "pass";

    static String getAuthenticatedUsername() {
        System.out.println("getAuthenticatedUsername");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = null;
        currentUsername = authentication.getName();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUsername = "SETUP FOR: *" + currentUsername + "* now complete.\n  " +
                    "  ... now preparing your Dashboard";
            return currentUsername;
        }
        currentUsername = "SETUP FOR AnonymousAuthenticationToken:" + currentUsername + "* now complete.\n  " +
                "  ... now preparing your Anonymous Dashboard";
        return currentUsername;
    }


    static boolean hardCodedAdminNameAndPassword(String un, String pw) {
        log.info("hardCodedAdminNameAndPassword" + " un: " + un + " pw: " + pw + " ADMIN: " + ADMIN + " ADMIN_PASSWORD: " + ADMIN_PASSWORD);

        if (un.contentEquals(ADMIN) && pw.contentEquals(ADMIN_PASSWORD)) {
            System.out.println("Welcome Internal Administrator, *" + un + "*\n  " +
                    "  ... now preparing your Dashboard");
            return true;
        } else {
            return false;
        }
    }
}
