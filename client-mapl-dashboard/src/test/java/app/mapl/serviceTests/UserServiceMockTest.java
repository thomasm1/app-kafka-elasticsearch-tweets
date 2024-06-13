package app.mapl.serviceTests;

import app.mapl.models.auth.Authority;
import app.mapl.models.auth.CredentialEntity;
import app.mapl.models.auth.RoleEntity;
import app.mapl.models.auth.User;
import app.mapl.models.auth.UserRequest;
import app.mapl.models.dto.UserDto;
import app.mapl.repositories.CredentialRepository;
import app.mapl.repositories.UsersRepository;
import app.mapl.service.UsersService;
import app.mapl.service.UsersServiceJPA;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class UserServiceMockTest {
    @Mock
    private UsersRepository usersRepository;
    @Mock
    private CredentialRepository credentialRepository;
    @InjectMocks
	private UsersServiceJPA usersServiceJPA;


    public static final String USER_4_CRYPTOMAVEN_XYZ = "user4@cryptomaven.xyz";



    @BeforeAll
    public final static void setup() {


    }

    @Test
    @DisplayName("Test find user by email")
    public void testFindUserByEmail() {
        User user = new User();
        user.setEmail(USER_4_CRYPTOMAVEN_XYZ);
        when(usersRepository.findByEmailIgnoreCase(USER_4_CRYPTOMAVEN_XYZ)).thenReturn(Optional.of(user));
        Optional<UserDto> foundUser = usersServiceJPA.getUser(USER_4_CRYPTOMAVEN_XYZ);
        assertEquals(USER_4_CRYPTOMAVEN_XYZ, foundUser.get().getEmail());
    }
    @Test
    @DisplayName("Test find user by ID")
    public void testFindUserById() {
    // Arrange - Given
    var userEntity = new User();
    userEntity.setEmail(USER_4_CRYPTOMAVEN_XYZ);
    userEntity.setFirstName("user4");
    userEntity.setId(1L);

    var roleEntity = new RoleEntity("USER", Authority.USER);
    userEntity.setRole(roleEntity);

    var credentialEntity = new CredentialEntity();
    credentialEntity.setPassword("password");
    credentialEntity.setUserEntity(userEntity);

    // Act - When
    when(usersRepository.findUserByUserId("1")).thenReturn(Optional.of(userEntity));
    when(credentialRepository.findByUser(userEntity)).thenReturn(Optional.of(credentialEntity));

    // Assert - Then
    assertEquals(USER_4_CRYPTOMAVEN_XYZ, userEntity.getEmail());
    assertEquals("password", credentialEntity.getPassword());


    }
    @Test
    public void add_new_user() {
        UserRequest u = new UserRequest( );
        when(usersServiceJPA.saveUser(u)).thenReturn(new ResponseEntity <>(u, null, 200)); // object, headers, rawSstatus int
        assertEquals(usersServiceJPA.saveUser(u), u);
     }


    @Test
    public void get_user() {
        UserDto user = new UserDto( );
        user.setEmail(USER_4_CRYPTOMAVEN_XYZ);
        when(usersServiceJPA.getUser(user.getEmail())).thenReturn(  assertInstanceOf(Optional.class, user));
        assertEquals(USER_4_CRYPTOMAVEN_XYZ, user.getEmail());
    }

    @Test
    public void get_users() {
        List<UserDto> users =   usersServiceJPA.getUsers();
        when(usersServiceJPA.getUsers()).thenReturn((List<UserDto>) assertInstanceOf(List.class, users));
        assertEquals(usersServiceJPA.getUsers(), users);

    }
    @Test
    public void update_user() {
            UserDto uUpdated = new UserDto( );   // PASSES
        when(usersServiceJPA.updateUser(uUpdated)).thenReturn(  assertInstanceOf(Optional.class, uUpdated));
        assertEquals(usersServiceJPA.updateUser(uUpdated), uUpdated);
    };

    @Test
    public void delete_user() {
        UserDto u = new UserDto( );    // PASSES
        u.setEmail("email@email.com");
        when(usersServiceJPA.saveUser(u)).thenReturn( new ResponseEntity(u, null, 200)); // object, headers, rawSstatus int
        when(usersServiceJPA.deleteUser(u.getEmail())).thenReturn( assertInstanceOf(Boolean.class, true));

        assertTrue(usersServiceJPA.deleteUser(u.getEmail()));
    }

    @AfterEach
    public void tearDown() {
        log.info("After Class executing ...");
    }

    @AfterAll  // static! (not needed with TestNG @BeforeClass
    public static void tearDownClass() {
        log.info("After Class executing ...");
    } // teardown


}
