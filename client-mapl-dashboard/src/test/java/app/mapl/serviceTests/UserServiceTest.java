package app.mapl.serviceTests;


import app.mapl.dto.UserDto;
import app.mapl.mapper.UserMapper;
import app.mapl.service.UsersService;
import app.mapl.service.UsersServiceJPA;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {      // *NOTE: change PK emails before sending to DB
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
        UserDto u = UserDto.builder()
                .email("user-1@gmail.com")
                .lastName("lastName")
                .firstName("firstName")
                .organizationCode("orgCode")
                .dashboardCode("dashCode")
                .build();
        //when(userDAOimplTester.createUser(u)).thenReturn(u);
        assertEquals(u, userServiceTesterJPA.createUser(u));
     }

    @Test
    public void get_users() {
        UserDto u = UserDto.builder()
                .email("user-1@gmail.com")
                .lastName("lastName")
                .firstName("firstName")
                .organizationCode("orgCode")
                .dashboardCode("dashCode")
                .build();
        assertEquals(u, userServiceTesterJPA.getUserByEmailAndPassword(u.getEmail(), u.getPassword()));

    }


    @Test
    public void update_user() {
        UserDto u = UserDto.builder()
                .email("_user-1@gmail.com")
                .lastName("_lastName")
                .firstName("_firstName")
                .organizationCode("_orgCode")
                .dashboardCode("_dashCode")
                .build();

        assertEquals(userServiceTesterJPA.updateUser(u),u);

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
