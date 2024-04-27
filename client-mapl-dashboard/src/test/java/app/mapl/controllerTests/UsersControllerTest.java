package app.mapl.controllerTests;

import app.mapl.controllers.UsersController;
import app.mapl.models.auth.User;
import app.mapl.models.auth.UserRequest;
import app.mapl.models.auth.UserResponse;
import app.mapl.models.dto.UserDto;
import app.mapl.service.UsersService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class UsersControllerTest {


    @Mock
    private UsersService usersService;

    @InjectMocks
    private UsersController urController;
//    @InjectMocks

    private MockMvc mockMvc;


    @BeforeAll
    public void setup(){
        MockitoAnnotations.initMocks(this);

        ResponseEntity<UserResponse> u = urController.createUser(new UserRequest());
        urController.createUser(new UserRequest());

        mockMvc = MockMvcBuilders.standaloneSetup(urController).build();
    }

    @Test
    public void testGet() throws Exception {
        Integer id = 1;

        when(usersService.getUser(id)).thenReturn(( Optional.of(new UserDto()));

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk()); // 200  OK      // .andExpect(view().name("user/show"));
//                .andExpect(view().name("/api/users"))
//                .andExpect(model().attribute("user", instanceOf(UserDto.class)));
    }

    @Test
    public void testUpdate() throws Exception {
        Integer id = 0;

//        User user = new User();
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(String.valueOf(id));
//        userDto = userMapper.toDto(user);

        when(usersService.getUser(id)).thenReturn(Optional.of(userResponse));

        mockMvc.perform(post("/api/users"))
                .andExpect(status().isOk())  ; // 200  OK      // .andExpect(view().name("user/show"));
//                .andExpect(view().name("user/userform"))
//                .andExpect(model().attribute("userForm", instanceOf(UserForm.class)));
    }


    @Test
    public void testSaveOrUpdate() throws Exception {
        long id = 0;
        User returnUser = new User();
        String firstName = "Thomas";
        String lastName = "Maestas";
        String email = "thomas1.maestas@gmail.com"; 
        String password = "password";

        returnUser.setId(id);
        returnUser.setFirstName(firstName);
        returnUser.setLastName(lastName); 
        returnUser.setEmail(email);  
        returnUser.setPassword(password);

        UserDto userResponse = new UserDto() ;
        userResponse.setFirstName(firstName);
        userResponse.setLastName(lastName);
        userResponse.setEmail(email);
        userResponse.setPassword(password);

        when(usersService.saveUser(UserDto.class.newInstance()));


        when(usersService.getUser(String.valueOf(Integer.class))).thenReturn(Optional.of(userResponse));

        mockMvc.perform(post("/user")
                        .param("userId", "1")
                        .param("Thomas", firstName)
                        .param("Maestas", lastName) 
                        .param("password", password)
                        .param("thomas1.maestas@gmail.com", email) )
                .andExpect(status().is2xxSuccessful());
//                .andExpect(view().name("redirect:user/show/1"));

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
//        verify(usersService.getUser(String.valueOf(Integer.class))).saveOrUpdateUserForm(userCaptor.capture());

//        UserForm boundUser = userCaptor.getValue();
//
//        assertEquals(id, boundUser.getUserId());
//        assertEquals(firstName, boundUser.getFirstName());
//        assertEquals(lastName, boundUser.getLastName());
//        assertEquals(email, boundUser.getEmail());
//        assertEquals(organizationCodeNumber, boundUser.getOrganizationCodeNumber());

    }
}
