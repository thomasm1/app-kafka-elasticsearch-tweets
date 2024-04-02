package app.mapl.serviceTests;


import app.mapl.dto.UserDto;
import app.mapl.mapper.UserMapper;
import app.mapl.models.User;
import app.mapl.service.UsersService;
import app.mapl.service.UsersServiceJPA;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {      // *NOTE: change PK usernames before sending to DB
    UsersService userServiceTesterJPA ;
    UserMapper usersMapper;


    @BeforeAll
    public void setup() {
        userServiceTesterJPA = new UsersServiceJPA();
        MockitoAnnotations.openMocks(this);
    }
    //TODO mockito Service INJECTION
    @Test
    public void add_new_user() {
        UserDto u = new UserDto(0, "username", "password", "lastName", "firstName", 0, "organizationCode", "email", "cusUrl", "dashboardCode", 0, 0, null);
        //when(userDAOimplTester.createUser(u)).thenReturn(u);
        assertEquals(u, userServiceTesterJPA.createUser(u));
     }

    @Test
    public void get_users() {
        UserDto u = new UserDto(0, "username", "password", "lastName", "firstName", 0, "organizationCode", "email", "cusUrl", "dashboardCode", 0, 0, null);

    }


    @Test
    public void update_user() {
        UserDto u = new UserDto(0, "username", "password", "lastName", "firstName", 0, "organizationCode", "email", "cusUrl", "dashboardCode", 0, 0, null);

        assertEquals(userServiceTesterJPA.updateUser(u),u);

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
