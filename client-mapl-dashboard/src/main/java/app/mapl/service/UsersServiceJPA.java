package app.mapl.service;

import app.mapl.dto.UserDto;
import app.mapl.dto.UserRequest;
import app.mapl.exception.ApiException;
import app.mapl.exception.ResourceNotFoundException;
import app.mapl.mapper.UserMapper;
import app.mapl.models.ConfirmationEntity;
import app.mapl.models.UserEvent;
import app.mapl.models.UserEntity;
import app.mapl.repositories.ConfirmationRepository;
import app.mapl.models.CredentialEntity;
import app.mapl.models.EventType;
import app.mapl.models.LoginType;
import app.mapl.models.RequestContext;
import app.mapl.models.User;
import app.mapl.repositories.CredentialRepository;
import app.mapl.repositories.UsersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


@AllArgsConstructor
@RequiredArgsConstructor
@Transactional(rollbackOn= Exception.class)
@Primary
@Service
public class UsersServiceJPA implements UsersService {
    private UsersRepository usersRepository;
    private CredentialRepository credentialRepository;
    private ConfirmationRepository confirmationRepository;

    private UserMapper userMapper;
    private ApplicationEventPublisher publisher;

    @Override
    public void createUser(String firstName, String lastName, String email, String password) {

        UserEntity userEntity = UserEntity.builder()
                .email(email)
                .lastName(lastName)
                .firstName(firstName)
                .build();;
        var credentialEntity = new CredentialEntity(userEntity, password);
        credentialRepository.save(credentialEntity);
        var confirmationEntity = new ConfirmationEntity(userEntity);
        confirmationRepository.save(confirmationEntity);
        publisher.publishEvent(new UserEvent(userEntity, EventType.REGISTRATION, Map.of("key", confirmationEntity.getKey())));
    }

    /**
     * @param user
     * @return
     */
    @Override
    public UserDto createUser(UserDto user) {
        return null;
    }

    /**
     * @param userRequest
     * @return
     */
    @Override
    public ResponseEntity saveUser(UserRequest userRequest) {
        return null;
    }

    /**
     * DEPRECATED
     * @param usernameOrEmail
     * @param password
     * @return
     */
    @Override
    public UserDto loginUser(String usernameOrEmail, String password) {
        User u = usersRepository.findByEmail(  usernameOrEmail).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", usernameOrEmail));
        // T
            return null;

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
     * @param email;
     * @return Optional<UserDto>
     */
    @Override
    public Optional<UserDto> getUser(String email) {
        Optional<UserDto> result;
        try {
            User u = usersRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", email));
            result = Optional.ofNullable(userMapper.toDto(u));
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

    public Optional<UserDto> getUserByEmail(String email) {
        User u;
        try {

            u = usersRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("not found", "not found", email));
        } catch (Exception e) {
            return null;
        }
        return Optional.ofNullable(userMapper.toDto(u));
    }



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
            User uEntity = userMapper.toEntity(change);
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
     * @param password
     * @return
     */
    @Override
    public UserRequest updateLoginAttempt(String email, String password) {
        return null;
    }

    /**
     * @param email
     * @param loginType
     */
    @Override
    public void updateLoginAttempt(String email, LoginType loginType) {

    }


}


