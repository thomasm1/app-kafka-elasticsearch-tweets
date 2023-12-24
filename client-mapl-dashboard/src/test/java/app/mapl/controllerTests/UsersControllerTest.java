package app.mapl.controllerTests;

import app.mapl.controllers.UsersController;
import app.mapl.dto.UserDto;
import app.mapl.models.User;
import app.mapl.service.UsersService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UsersControllerTest {


    @Mock
    private UsersService uService;

    @InjectMocks
    private UsersController urController;
//    @InjectMocks

    private MockMvc mockMvc;


    @BeforeAll
    public void setup(){
        MockitoAnnotations.initMocks(this);

        ResponseEntity<UserDto> u = urController.createUser(new UserDto());
        urController.createUser(new UserDto());

        mockMvc = MockMvcBuilders.standaloneSetup(urController).build();
    }

    @Test
    public void testGet() throws Exception {
        Integer id = 1;

        when(uService.getUser(id)).thenReturn(Optional.of(new UserDto()));

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk()); // 200  OK      // .andExpect(view().name("user/show"));
//                .andExpect(view().name("/api/users"))
//                .andExpect(model().attribute("user", instanceOf(UserDto.class)));
    }

    @Test
    public void testUpdate() throws Exception {
        Integer id = 0;

//        User user = new User();
        UserDto userDto = new UserDto();
        userDto.setUserId(id);
//        userDto = userMapper.toDto(user);

        when(uService.getUser(id)).thenReturn(Optional.of(userDto));

        mockMvc.perform(post("/api/users"))
                .andExpect(status().isOk())  ; // 200  OK      // .andExpect(view().name("user/show"));
//                .andExpect(view().name("user/userform"))
//                .andExpect(model().attribute("userForm", instanceOf(UserForm.class)));
    }


    @Test
    public void testSaveOrUpdate() throws Exception {
        Integer id = 0;
        User returnUser = new User();
        String firstName = "Thomas";
        String lastName = "Maestas";
        String email = "thomas1.maestas@gmail.com";
        String organizationCode = "305.333.0101";
        String username = "mweston";
        String password = "password";

//        returnUser.setId(id);
//        returnUser.setFirstName(firstName);
//        returnUser.setLastName(lastName);
//        returnUser.setAddress(new Address());
//        returnUser.getAddress().setAddressLine1(addressLine1);
//
//        returnUser.setEmail(email);
//        returnUser.setOrganizationCodeNumber(organizationCodeNumber);
//        returnUser.setUser(new User());
//        returnUser.getUser().setUsername(username);
//        returnUser.getUser().setPassword(password);
//
//        when(userService.saveOrUpdateUserForm(Matchers.<UserForm>any())).thenReturn(returnUser);
//        when(userService.getById(Matchers.<Integer>any())).thenReturn(returnUser);
//
//        mockMvc.perform(post("/user")
//                        .param("userId", "1")
//                        .param("firstName", firstName)
//                        .param("lastName", lastName)
//                        .param("username", username)
//                        .param("passwordText", password)
//                        .param("email", email)
//                        .param("organizationCode", organizationCoder))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:user/show/1"));
//
//        ArgumentCaptor<UserForm> userCaptor = ArgumentCaptor.forClass(UserForm.class);
//        verify(userService).saveOrUpdateUserForm(userCaptor.capture());
//
//        UserForm boundUser = userCaptor.getValue();
//
//        assertEquals(id, boundUser.getUserId());
//        assertEquals(firstName, boundUser.getFirstName());
//        assertEquals(lastName, boundUser.getLastName());
//        assertEquals(email, boundUser.getEmail());
//        assertEquals(organizationCodeNumber, boundUser.getOrganizationCodeNumber());

    }
}
