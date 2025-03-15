package net.ourdailytech.rest.service;

import net.ourdailytech.rest.exception.EmailAlreadyExistsException; 
import net.ourdailytech.rest.exception.PostApiException; 
import net.ourdailytech.rest.exception.ResourceNotFoundException;
import net.ourdailytech.rest.mapper.UserMapper;
import net.ourdailytech.rest.models.Role;
import net.ourdailytech.rest.models.User; 
import net.ourdailytech.rest.models.dto.LoginDto;
import net.ourdailytech.rest.models.dto.RegisterDto; 
import net.ourdailytech.rest.models.dto.UserDto;
import net.ourdailytech.rest.repositories.RoleRepository;
import net.ourdailytech.rest.repositories.UsersRepository;
import net.ourdailytech.rest.security.JwtTokenProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder; 
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UsersService {

    private static final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);
    private final JwtTokenProvider jwtTokenProvider;
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;

    public UsersRepository usersRepository;
    private RoleRepository roleRepository;
    private UserMapper userMapper;
    @Autowired
    public UsersServiceImpl(
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            RoleRepository roleRepository,
            UsersRepository usersRepository,
            UserMapper userMapper,
            JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository; 
      this.userMapper = userMapper;
      this.usersRepository = usersRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }
 
    public UsersServiceImpl(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    /**
     * @param username;
     * @param password;
     * @return UserDto
     */ 
    @Override 
    public UserDto loginUser(String username, String password){
        Optional<User> optionalUser = usersRepository.findByUsernameOrEmail(username, username);
        if(optionalUser.isPresent()) {
            User u = optionalUser.get();
            if (passwordEncoder.matches(password, u.getPassword())) {
                return userMapper.toDto(u);
            }
        } else {
            throw new ResourceNotFoundException("User", "username", username);
        }
        return userMapper.toDto(optionalUser.get());
    }
    /** 
     * @param loginDto;
     * @return String
     */
    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsernameOrEmail(),
                        loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwtTokenProvider.generateToken(authentication);
    }

    /** 
     * @param userDto;
     * @return UserDto
     */
    @Override 
    public UserDto createUser(UserDto userDto) { 
        Optional<User> optionalUser = usersRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()) {
            throw new EmailAlreadyExistsException("User already exists");
        }
        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new ResourceNotFoundException("Role", "name", "ROLE_USER"));

        user.setRoles(Collections.singleton(role));
        User u = usersRepository.save(user);
        return userMapper.toDto(u);
    }

    /**
     * @param registerDto;
     * @return String
     */
    @Override
    public Optional<UserDto> register(RegisterDto registerDto) {
        if(usersRepository.existsByEmail(registerDto.getEmail())){
            throw new PostApiException(HttpStatus.BAD_REQUEST, "Email  already exists!.");
        }
        User user = new User();
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Set<Role> roles = new HashSet<>();
        Optional<Role> userRole = Optional.ofNullable(roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new ResourceNotFoundException("Role", "name", "ROLE_USER")));
        roles.add(userRole.get());
        user.setRoles(roles);
        User u =  usersRepository.save(user);
        return Optional.ofNullable(userMapper.toDto(u));
    }


    /** 
     * @param id
     * @return UserDto
     */
    @Override
    public Optional<UserDto> getUser(int id) {
        try {
            return Optional.ofNullable(userMapper
                    .toDto(usersRepository.findById(id).orElse(null)));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param email;
     * @return UserDto
     */
    @Override
    public Optional<UserDto> getUser(String email) {
        try {
            User u = usersRepository.findByEmail(email).orElseThrow(
                    () -> new ResourceNotFoundException("not found", "not found", email)
            );
            return Optional.ofNullable(userMapper.toDto(u));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @return List<UserDto>
     */
    @Override
    public List<UserDto> getUsers() {
        List<UserDto> userDtos =null;
       try {
           List<User> users = usersRepository.findAll();
           if (users == null) {
               throw new ResourceNotFoundException("not found", "not found", "not found");
           }   else {
               return users.stream().map(userMapper::toDto).collect(Collectors.toList());
           }
       } catch (NullPointerException e) {
           e.printStackTrace();
           return new ArrayList<>();
       }

    }
    /**
     * @param email;
     * @param pw;
     * @return UserDto
     */
    @Override
    public UserDto getUserByEmailAndPassword(String email, String pw) {
        User u;
        try {
            u = usersRepository.findByEmailAndPassword(email,pw).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", email));
//                return usersRepository.findByEmailAndPassword(email, pw).get();
        } catch (Exception e) {
            return null;
        }
        return userMapper.toDto(u);
    }
    /**
     * @param email;
     * @return UserDto
     */
    public Optional<UserDto> getUserByEmail(String email) {
        User u;
        try { 
            u = usersRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", email));
        } catch (Exception e) {
            return null;
        }
        return Optional.ofNullable(userMapper.toDto(u));
    }

//    public List<User> getUsersWithCoins() {
//        if (usersRepository.findAll().size() == 0) return null;
//        return usersRepository.findAll()
//                .stream()
//                .filter(u ->
//                        u.getAddresses().size() > 0 && u.getIsActive() != 0
//                )
//                .collect(Collectors.toList());
//    }


    /**
     * @param change;
     * @return UserDto
     */
    @Override
    public Optional<UserDto> updateUser(UserDto change) {
        User existingUser = usersRepository.findByEmail(change.getEmail()).orElseThrow(
                () -> new ResourceNotFoundException("User", "email", change.getEmail())
        );
            User uEntity = userMapper.toEntity(change);
            User uDone = usersRepository.save(uEntity);

            return Optional.ofNullable(userMapper.toDto(uDone));
    }
    /**
     * @param userId;
     * @param user;
     */
    @Override
    public Optional<UserDto> updateUserById(Integer userId, UserDto user) {
        AtomicReference<Optional<UserDto>> atomicReference = new AtomicReference<>();

        usersRepository.findById(userId).ifPresentOrElse(foundUser -> {
            foundUser.setUsername(user.getUsername());
            atomicReference.set(Optional.of(userMapper
                    .toDto(usersRepository.save(foundUser))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }
    /**
     * @param userId;
     * @param user;
     * @return UserDto
     */
    @Override
    public Optional<UserDto> patchUserById(Integer userId, UserDto user) {
        AtomicReference<Optional<UserDto>> atomicReference = new AtomicReference<>();

        usersRepository.findById(userId).ifPresentOrElse(foundUser -> {
            if (StringUtils.hasText(user.getUsername())){
                foundUser.setUsername(user.getUsername());
            }
            if (StringUtils.hasText(user.getEmail())){
                foundUser.setEmail(user.getEmail());
            }
            atomicReference.set(Optional.of(userMapper
                    .toDto(usersRepository.save(foundUser))));
        }, () -> {
            atomicReference.set(Optional.empty());
        });

        return atomicReference.get();
    }
    /**
     * @param email;
     * @return boolean
     */
    @Override
    public boolean deleteUser(String email) {
        try {
            User u = usersRepository.findByEmail(email).get();
            usersRepository.delete(u);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * @param user;
     * @return boolean
     */
    @Override
    public boolean deleteUser(UserDto user) {

        try {
            User u = usersRepository.findByEmail(user.getEmail()).get();
            usersRepository.delete(u);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
