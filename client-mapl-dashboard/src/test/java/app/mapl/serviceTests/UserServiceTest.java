package app.mapl.serviceTests;

import static app.mapl.service.UsersServiceImpl.userMapper;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import app.mapl.dto.UserDto;
import app.mapl.models.Role;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import app.mapl.dao.UserDAOimpl;
import app.mapl.models.User;
import app.mapl.service.UsersServiceImpl;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {      // *NOTE: change PK usernames before sending to DB

    @InjectMocks
	private UsersServiceImpl userServiceTester;
    @Mock
    private UserDAOimpl userDAOimplTester = mock(UserDAOimpl.class);

    @BeforeAll
    public void setup() {

        MockitoAnnotations.openMocks(this);
    }
    //TODO mockito Service INJECTION
    @Test
    public void add_new_user() {
        UserDto u = new UserDto(0, "username", "password", "lastName", "firstName", 0, "organizationCode", "email", "cusUrl", "dashboardCode", 0, 0, null);
        when(userDAOimplTester.createUser(userMapper.toEntity(u))).thenReturn(userMapper.toEntity(u));
        assertEquals(userServiceTester.createUser(u),u);
     }

    @Test
    public void get_users() {
        UserDto u = new UserDto(0, "username", "password", "lastName", "firstName", 0, "organizationCode", "email", "cusUrl", "dashboardCode", 0, 0, null);

        when(userDAOimplTester.getUsers()).thenReturn(Arrays.asList(
                new User(0, "username", "password", "lastName", "firstName", 0, "organizationCode", "email", "cusUrl", "dashboardCode", 0, 0, null)));
        List<UserDto> users = userServiceTester.getUsers();
        assertEquals("user0", users.get(0).getUsername());
        assertEquals("password1", users.get(1).getPassword());
    }

//    @Test
//    public void get_user() {
//
//        when(userDAOimplTester.getUser("username")).thenReturn(
//                new UserDto(0, "username", "password", "lastName", "firstName", 0, "organizationCode", "email", "cusUrl", "dashboardCode", 0, 0, null)
//    }


    public void update_user() {
//		User uUpdated = new User("password", "Smith", "Tom", 3, 1, "5055087707" , "user4@cryptomaven.xyz", "http://www.dailytech.net","dashboardCode", 	"userGroup",
//				0,
//				1,
//				"id");   // PASSES
//   		assertTrue(UserService.updateUser(uUpdated));
    }

    @Test
    public void delete_user() {
//		User u = new User("user4"+rand, "passwordX", "Smith", "Tom", 3, 1, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net",
//				"dashboardCode",
//				"userGroup",
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
