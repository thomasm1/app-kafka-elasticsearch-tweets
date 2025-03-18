package net.ourdailytech.rest.serviceTests;
 
import net.ourdailytech.rest.mapper.UserMapper;
import net.ourdailytech.rest.models.User;
import net.ourdailytech.rest.models.dto.RegisterDto;
import net.ourdailytech.rest.models.dto.UserDto;
import net.ourdailytech.rest.service.UsersService;
import net.ourdailytech.rest.service.UsersServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {      // *NOTE: change PK usernames before sending to DB

    @Mock
	private UsersService usersService;
    @Mock
    private UserMapper userMapper;
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
    public void register_new_user() {
        RegisterDto u =   RegisterDto.builder()
                .email("user4@cryptomaven.xyz")
                .password("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8")
                .build();
        User user = new User();
        when(usersService.register(any(RegisterDto.class))).thenReturn(any(Optional.class)); ;
        assertEquals(usersService.register(u), userMapper.toDto(user) );
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