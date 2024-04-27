package app.mapl.service;

import app.mapl.models.auth.*;
import app.mapl.exception.ApiException;
import app.mapl.exception.ResourceNotFoundException;
import app.mapl.mapper.UserMapper;
import app.mapl.models.dto.UserDto;
import app.mapl.repositories.ConfirmationRepository;
import app.mapl.repositories.CredentialRepository;
import app.mapl.repositories.RoleEntityRepository;
import app.mapl.repositories.UsersRepository;
import app.mapl.util.config.CacheStore;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static app.mapl.models.auth.User.buildUser;
import static java.time.LocalDateTime.now;


@AllArgsConstructor
@RequiredArgsConstructor
@Transactional(rollbackOn= Exception.class)
@Primary
@Service
@Slf4j
public class UsersServiceJPA implements UsersService {
    private UsersRepository usersRepository;
    private CredentialRepository credentialRepository;
    private ConfirmationRepository confirmationRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
    private RoleEntityRepository roleRepository;
    private CacheStore<String, Integer> userCache;

    private UserMapper userMapper;
    private ApplicationEventPublisher publisher;
//    private WebClient webClient;
//    private APIClient apiClient;



    /**
     * @param firstName
     * @param lastName
     * @param email
     * @param role
     * @return User
     */
    @Override
    public User createUser(String firstName, String lastName, String email, RoleEntity role) {
        User userEntity = buildUser(firstName, lastName, email, role);
        Optional<User> savedUser = Optional.of(usersRepository.save(userEntity));
        return savedUser.get();

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

    @Override
    public void createUser(String firstName, String lastName, String email, @NotEmpty String password) {

        User userEntity = User.builder()
                .email(email)
                .lastName(lastName)
                .firstName(firstName)
                .build();
        ;
        var credentialEntity = new CredentialEntity(userEntity, password);
        credentialRepository.save(credentialEntity);
        var confirmationEntity = new ConfirmationEntity(userEntity);
        confirmationRepository.save(confirmationEntity);
        publisher.publishEvent(new UserEvent(userEntity, EventType.REGISTRATION, Map.of("key", confirmationEntity.getKey())));
    }

    @Override
    public User createUserRole(String firstName, String lastName, String email, @NotEmpty String password) {
        var role = getRoleName(Authority.USER.name());
        return createUser(firstName, lastName, email, role);
    }

    /**
     * @param userDto
     * @return
     */
    @Override
    public ResponseEntity saveUser( UserDto  userDto) {
        Optional<User> savedUser = Optional.of(usersRepository.save(userMapper.toUser(userDto)));
        return ResponseEntity.ok(userMapper.toDto(savedUser.get()));
    }

    /**
     * DEPRECATED
     *
     * @param usernameOrEmail
     * @param password
     * @return
     */
    @Override
    public UserDto loginUser(String usernameOrEmail, String password) {
        User u = usersRepository.findByEmail(usernameOrEmail).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", usernameOrEmail));
        return userMapper.toDto(u);
    }

    private User createUser(String firstName, String lastName, String email) {
        var role = getRoleName(Authority.USER.name());
        return createUser(firstName, lastName, email, role);
    }


    /**
     * @param id;
     * @return Optional<UserDto>
     */
    @Override
    public Optional<UserDto> getUser(int id) {
        try {
            User u = usersRepository.findById(id).get();
            return Optional.ofNullable(userMapper.toDto(u));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param name
     * @return
     */
    @Override
    public RoleEntity getRoleName(String name) {
        return roleRepository.findByName(name).orElseThrow(() -> new ApiException("Role not found"));

    }


    private ConfirmationEntity getConfirmationEntity(String key) {
        return confirmationRepository.findByKey(key).orElseThrow(() -> new ApiException("Confirmation not found"));
    }

    /**
     * @param email
     * @return
     */
    @Override
    public Optional<UserDto> getUser(String email) {
        return Optional.empty();
    }


    /**
     * @param uerEntityId
     * @return User
     */
//    @Override
    public APIResponseDto getUserById(Long uerEntityId) {
        APIResponseDto apiResponseDto = new APIResponseDto();
//        apiResponseDto.setStatusCode(200);
//        apiResponseDto.setMessage("User found");
//        apiResponseDto.setTimestamp(LocalDateTime.now().toString());
//        apiResponseDto.setPath("/api/users/" + uerEntityId);

//        Optional<app.mapl.models.UserEntity> uerEntity = usersRepository.findById(uerEntityId) ;

//        ResponseEntity<DashboardDto> responseEntity = getForEntity("http://localhost:8080/api/dashboards/" + uerEntity.getDashboardCode(),
//                DashboardDto.class);
//
//        DashboardDto dashboardDto = responseEntity.getBody();
//
//        DashboardDto dashboardDto = webClient.get()
//                .uri("http://localhost:8080/api/dashboards/" + uerEntity.getDashboardCode())
//                .retrieve()
//                .bodyToMono(DashboardDto.class)
//                .block();
//
//        DashboardDto dashboardDto = apiClient.getDashboard(uerEntity.getDashboardCode()); // TODO:
//
//        UserDto uerEntityDto = new UserDto(
//                uerEntity.getId(),
//                uerEntity.getFirstName(),
//                uerEntity.getLastName(),
//                uerEntity.getEmail(),
//                uerEntity.getDashboardCode(),
//                uerEntity.getOrganizationCode()
//        );
//
//        APIResponseDto apiResponseDto = new APIResponseDto();
//        apiResponseDto.setUserEntity(uerEntityDto);
//        apiResponseDto.setDashboard(dashboardDto);

        return apiResponseDto;
    }

    /**
     * @param email;
     * @return Optional<UserDto>
     */
    @Override
    public Optional<User> getUserByEmail(String email) {
        Optional<User> result;
        try {
            User u = usersRepository.findByEmailIgnoreCase(email).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", email));
            result = Optional.ofNullable(u);
        } catch (Exception e) {
            result = null;
        }
        return result;
    }


    /**
     * @return List<UserDto>
     */
    @Override
    public List<UserDto> getUsers() {
        List<UserDto> userResponses = null;
        try {
            List<User> users = usersRepository.findAll();
            if (users == null) {
                throw new ResourceNotFoundException("not found", "not found", "not found");
            } else {
                return users.stream().map(userMapper::toDto).collect(Collectors.toList());
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

//    @Override
//    public Optional<UserDto> getUserByEmailAndPassword(String email, String pw) {
//        User u;
//        try {
//            u = usersRepository.findByEmailAndPassword(email,pw).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", email));
////                return usersRepository.findByEmailAndPassword(email, pw).get();
//        } catch (Exception e) {
//            return null;
//        }
//        return Optional.ofNullable(userMapper.toDto(u));
//    }


    /**
     * @param email
     * @param password
     * @return
     */
    @Override
    public Optional<UserDto> getUserByPassword(String email, String password) {
        return null;
    }

    /**
     * @param change
     * @return
     */
    @Override
    public Optional<UserDto> updateUser(UserDto change) {
        try {
            User uEntity = userMapper.partialUpdate(change, usersRepository.findByEmail(change.getEmail()).get());
            User uDone = usersRepository.save(uEntity);

            return Optional.of(userMapper.toDto(uDone));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(change);
    }

    /**
     * @param email
     * @param pw
     * @return
     */
    @Override
    public Optional<UserDto> getUserByEmailAndPassword(String email, String pw) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDto> patchUserById(Integer userId, UserDto user) {
        AtomicReference<Optional<UserDto>> atomicReference = new AtomicReference<>();

        usersRepository.findById(userId).ifPresentOrElse(foundUser -> {
            if (StringUtils.hasText(user.getEmail())) {
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
     * @param email
     * @return
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
     * @param user
     * @return
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

    /**
     * @param email
     * @param loginType
     * @return
     */
    @Override
    public UserDto updateLoginAttempt(String email, LoginType loginType) {
    var user = getUserByEmail(email).get();
//            .get()==null?null:getUserByEmail(email).get();
        RequestContext.setUserId(user.getId());
        switch(loginType) {
            case LOGIN_ATTEMPT:
                if(userCache.get(user.getEmail())==null){
                    user.setLoginAttempts(0);
                    user.setAccountNonLocked(true);
                }
                user.setLoginAttempts(user.getLoginAttempts() + 1);
                userCache.put(user.getEmail(), user.getLoginAttempts());
                if(userCache.get(user.getEmail()) > 5) {
                    user.setAccountNonLocked(false);
                }

            case LOGIN_SUCCESS:
                user.setAccountNonLocked(true);
                user.setLoginAttempts(0);
                user.setLastLogin(now());
                userCache.evict(user.getEmail());
                break;
            default:
                break;
        }
      return  userMapper.toDto(usersRepository.save(user));
    }

    /**
     * @param key
     * @return
     */
    @Override
    public void verifyAccountKey(String key) {
        var confirmationEntity = getConfirmationEntity(key);
//    Optional<UserDto> uerEntity = getUserByEmail(confirmationEntity
//            .getUser()
//            .getEmail());
        // TODO
//        uerEntity.get().set(true);
//        usersRepository.save(uerEntity);
//        confirmationRepository.delete(confirmationEntity);
//        return new APIResponseDto("Account verified");
    }

    private Object getUserConfirmation(String token) {
    return confirmationRepository.findByKey(token);
    }
}


