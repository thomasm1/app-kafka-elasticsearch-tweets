package app.mapl.serviceTests;

import app.mapl.models.auth.UserRequest;
import app.mapl.models.dto.UserDto;
import app.mapl.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class UserServiceMockTest {

    public static final String USER_4_CRYPTOMAVEN_XYZ = "user4@cryptomaven.xyz";
    //    @InjectMocks
//	private UsersService userServiceTester;
    @Mock
    private UsersService userServiceMock;
    // Impl usersServiceImpl = mock(UsersServiceImpl.class);


    @BeforeAll
    public final static void setup() {
//        MockitoAnnotations.openMocks(UsersServiceImpl.class);
    }
//    TODO mockito Service INJECTION
    @Test
    public void add_new_user() {
        UserRequest u = new UserRequest( );
//        when(userServiceMock.saveUser(u)).thenReturn(new ResponseEntity<UserRequest>, u));
//        assertEquals(userServiceMock.createUser(u), u);u
     }


    @Test
    public void get_user() {
        UserDto user = new UserDto( );
        user.setEmail(USER_4_CRYPTOMAVEN_XYZ);
//        when(userServiceMock.getUser(user.getEmail())).thenReturn( assertInstanceOf(UserDto.class, user));
        assertEquals(USER_4_CRYPTOMAVEN_XYZ, user.getEmail());
    }

    @Test
    public void get_users() {
        List<UserDto> users =   userServiceMock.getUsers();
        when(userServiceMock.getUsers()).thenReturn((List<UserDto>) assertInstanceOf(List.class, users));
        assertEquals(userServiceMock.getUsers(), users);

    }
//    @Test
//    public void update_user() {
//            UserDto uUpdated = new UserDto( );   // PASSES
//        when(userServiceMock.updateUser(uUpdated)).thenReturn((Optional<UserDto>) assertInstanceOf(UserDto.class, uUpdated));
//        assertEquals(userServiceMock.updateUser(uUpdated), uUpdated);
//    };

    @Test
    public void delete_user() {
        UserDto u = new UserDto( );    // PASSES
        u.setEmail("email@email.com");
//        when(userServiceMock.createUser(u)).thenReturn(assertInstanceOf(UserDto.class, u));
        when(userServiceMock.deleteUser(u.getEmail())).thenReturn( assertInstanceOf(Boolean.class, true));

        assertTrue(userServiceMock.deleteUser(u.getEmail()));
//		log.info("deleteed just now ..."+ x);
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
