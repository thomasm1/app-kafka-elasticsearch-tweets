package xyz.cryptomaven.app.serviceTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import xyz.cryptomaven.app.dao.UserDAOimpl;
import xyz.cryptomaven.app.models.User;
import xyz.cryptomaven.app.service.UserService;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {      // *NOTE: change PK usernames before sending to DB

    @InjectMocks
	private UserService userServiceTester;
    @Mock
    private UserDAOimpl userDAOimplTester;

    //TODO mockito Service INJECTION
    @Test
    public void add_new_user() {
        User u = new User(
                "user0", "passwordX",
                "Smith", "Tom", 3, 1,
                "user4@cryptomaven.xyz", "5055087707", "http://www.dailytech.net",
                "photoPath",
                "userGroup",
                0,
                1,
                "id");
        when(userDAOimplTester.createUser(u)).thenReturn(true);
        assertTrue(userServiceTester.createUser(u));
     }

    @Test
    public void get_users() {

        when(userDAOimplTester.getUsers()).thenReturn(Arrays.asList(
                new User(
                        "user1", "password1",
                        "Smith", "Tom", 3, 1,
                        "user4@cryptomaven.xyz", "5055087707", "http://www.dailytech.net",
                        "photoPath",
                        "userGroup",
                        0,
                        1,
                        "id"),
                new User(
                        "user2", "password2",
                        "Smith", "Tom", 3, 1,
                        "user4@cryptomaven.xyz", "5055087707", "http://www.dailytech.net",
                        "photoPath",
                        "userGroup",
                        0,
                        1,
                        "id")));
        List<User> users = userServiceTester.getUsers();
        assertEquals("user0", users.get(0).getUserName());
        assertEquals("password1", users.get(1).getPassword());
    }

    @Test
    public void get_user() {

        when(userDAOimplTester.getUser("user1")).thenReturn(
                new User(
                        "user1", "password1",
                        "Smith", "Tom", 3, 1,
                        "user4@cryptomaven.xyz", "5055087707", "http://www.dailytech.net",
                        "photoPath",
                        "userGroup",
                        0,
                        1,
                        "id"));
        User user = userServiceTester.getUser("user1");

        assertEquals("user1", user.getUserName());
    }

    @Test
    public void update_user() {
//		User uUpdated = new User("password", "Smith", "Tom", 3, 1, "5055087707" , "user4@cryptomaven.xyz", "http://www.dailytech.net","photoPath", 	"userGroup",
//				0,
//				1,
//				"id");   // PASSES
//   		assertTrue(UserService.updateUser(uUpdated));
    }

    @Test
    public void delete_user() {
//		User u = new User("user4"+rand, "passwordX", "Smith", "Tom", 3, 1, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net",
//				"photoPath",
//				"userGroup",
//				0,
//				1,
//				"id");    // PASSES
//		String x = u.getUserName()+rand;
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