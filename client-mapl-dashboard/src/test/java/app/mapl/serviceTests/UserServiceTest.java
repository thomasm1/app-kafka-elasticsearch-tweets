package app.mapl.serviceTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import app.mapl.models.dto.UserDto;
import app.mapl.repositories.UsersRepository;
import app.mapl.service.UsersService;
import app.mapl.service.UsersServiceImpl;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import app.mapl.models.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {      // *NOTE: change PK usernames before sending to DB

    @Mock
	private UsersService usersService;
    @InjectMocks
    private UsersServiceImpl usersServiceImpl = mock(UsersServiceImpl.class);


    @BeforeEach
    public void setup() {

        MockitoAnnotations.openMocks(this);
    }
    //TODO mockito Service INJECTION
    @Test
    public void add_new_user() {
        UserDto u =   UserDto.builder()
        .username("user0")
        .lastName("Smith")
        .firstName("Tom")
        .userType(3)
        .organizationCode("CD")
        .dashboardCode("dashboardCd")
        .email("user4@cryptomaven.xyz")
        .cusUrl("http://www.dailytech.net/photoPath")
        .contactType(1)
        .isActive(1)
        .id("id")
                .build();
        when(usersService.createUser(u)).thenReturn(u);
        assertEquals(usersService.createUser(u), u);
     }

    @Test
    public void get_users() {

        UserDto uDto;
        when(usersService.getUsers()).thenReturn(Arrays.asList(
                  uDto = UserDto.builder()
                        .username("user0")
                        .lastName("Smith")
                        .firstName("Tom")
                        .userType(3)
                        .organizationCode("CD")
                        .dashboardCode("dashboardCd")
                        .email("user4@cryptomaven.xyz")
                        .cusUrl("http://www.dailytech.net/photoPath")
                        .contactType(1)
                        .isActive(1)
                        .id("id")
                        .build(),
        uDto = UserDto.builder()
                .username("user0")
                .lastName("Smith")
                .firstName("Tom")
                .userType(3)
                .organizationCode("CD")
                .dashboardCode("dashboardCd")
                .email("user4@cryptomaven.xyz")
                .cusUrl("http://www.dailytech.net/photoPath")
                .contactType(1)
                .isActive(1)
                .id("id")
                .build()
        ));
        List<UserDto> users = usersService.getUsers();
        assertEquals("user0", users.get(0).getUsername());
        assertEquals("Smith", users.get(1).getLastName());
    }

    @Test
    public void get_user() {

        when(usersService.getUser("user4@cryptomaven.xyz")).thenReturn(
                Optional.ofNullable(UserDto.builder()
                        .username("user4@cryptomaven.xyz")
                        .lastName("Smith")
                        .firstName("Tom")
                        .userType(3)
                        .organizationCode("CD")
                        .dashboardCode("dashboardCd")
                        .email("user4@cryptomaven.xyz")
                        .cusUrl("http://www.dailytech.net/photoPath")
                        .contactType(1)
                        .isActive(1)
                        .id("id")
                        .build()));
        Optional<UserDto> user = usersService.getUser("user4@cryptomaven.xyz");

        assertEquals("user4@cryptomaven.xyz", user.get().getUsername());
    }

    @Test
    public void update_user() {

    }

    @Test
    public void delete_user() {
//		User u = new User("user4"+rand, "passwordX", "Smith", "Tom", 3, 1, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net",
//				"photoPath",
//				"dashboardCode",
//				0,
//				1,
//				"id");    // PASSES
//		String x = u.getUsername()+rand;
//		System.out.println("about to delete just  ..."+x);
//		assertTrue(UserService.deleteUser(x));
//		System.out.println("deleteed just now ..."+ x);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("After Class executing ...");
    }

    @AfterAll  // static! (not needed with TestNG @BeforeClass
    public static void tearDownClass() {
        System.out.println("After Class executing ...");
    } // teardown


}