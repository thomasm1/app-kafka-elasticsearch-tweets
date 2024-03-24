package app.mapl.serviceTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import app.mapl.dto.UserDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import app.mapl.models.User;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {      // *NOTE: change PK usernames before sending to DB



    @BeforeAll
    public void setup() {

        MockitoAnnotations.openMocks(this);
    }
    //TODO mockito Service INJECTION
    @Test
    public void add_new_user() {
//        UserDto u = new UserDto(0, "username", "password", "lastName", "firstName", 0, "organizationCode", "email", "cusUrl", "dashboardCode", 0, 0, null);
//        when(userDAOimplTester.createUser(userMapper.toEntity(u))).thenReturn(userMapper.toEntity(u));
//        assertEquals(userServiceTester.createUser(u),u);
     }

    @Test
    public void get_users() {
//        UserDto u = new UserDto(0, "username", "password", "lastName", "firstName", 0, "organizationCode", "email", "cusUrl", "dashboardCode", 0, 0, null);
//
//        when(userDAOimplTester.getUsers()).thenReturn(Arrays.asList(
//                new User(0, "username", "password", "lastName", "firstName", 0, "organizationCode", "email", "cusUrl", "dashboardCode", 0, 0, null)));
//        List<UserDto> users = userServiceTester.getUsers();
//        assertEquals("user0", users.get(0).getUsername());
//        assertEquals("password1", users.get(1).getPassword());
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
//        UserDto u = new UserDto(0, "username", "password", "lastName", "firstName", 0, "organizationCode", "email", "cusUrl", "dashboardCode", 0, 0, null);
//        when(userDAOimplTester.deleteUser(0)).thenReturn(true);
//        assertTrue(userServiceTester.deleteUser(0));

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
