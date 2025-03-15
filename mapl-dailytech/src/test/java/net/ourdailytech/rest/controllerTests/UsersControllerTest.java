package net.ourdailytech.rest.controllerTests;


import net.ourdailytech.rest.controllers.UsersController;
import net.ourdailytech.rest.mapper.UserMapper;
import net.ourdailytech.rest.models.User;
import net.ourdailytech.rest.models.dto.LoginDto;
import net.ourdailytech.rest.models.dto.RegisterDto;
import net.ourdailytech.rest.models.dto.UserDto;
import net.ourdailytech.rest.service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class UsersControllerTest {

        private MockMvc mockMvc;

        @Mock
        private UsersService usersService;

        @Mock
        private UserMapper userMapper;
        @InjectMocks
        private UsersController usersController;

        @BeforeEach
        void setUp() {
            mockMvc = MockMvcBuilders.standaloneSetup(usersController).build();
        }

        @Test
        void testGetUsers() throws Exception {
            when(usersService.getUsers()).thenReturn(Collections.singletonList(new UserDto()));

            mockMvc.perform(get("/api/users")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }

        @Test
        void testGetUserById_Found() throws Exception {
            UserDto userDto = new UserDto();
            userDto.setUserId(1);
            userDto.setEmail("test@example.com");

            when(usersService.getUser(anyInt())).thenReturn(Optional.of(userDto));

            mockMvc.perform(get("/api/users/1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.userId").value(1))
                    .andExpect(jsonPath("$.email").value("test@example.com"));
        }

        @Test
        void testGetUserById_NotFound() throws Exception {
            when(usersService.getUser(anyInt())).thenReturn(Optional.empty());

            mockMvc.perform(get("/api/users/1")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound());
        }

        @Test
        void testGetUserByEmail_Found() throws Exception {
            UserDto userDto = new UserDto();
            userDto.setUserId(1);
            userDto.setEmail("test@example.com");

            when(usersService.getUserByEmail(anyString())).thenReturn(Optional.of(userDto));

            mockMvc.perform(get("/api/users/email/test@example.com")
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.email").value("test@example.com"));
        }

        @Test
        void testCreateUser() throws Exception {
            UserDto userDto = new UserDto();
            userDto.setUserId(1);
            userDto.setEmail("newuser@example.com");

            when(usersService.createUser(any(UserDto.class))).thenReturn(userDto);

            mockMvc.perform(post("/api/users")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{ \"email\": \"newuser@example.com\" }"))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.email").value("newuser@example.com"));
        }


@Test
void testRegisterUser() throws Exception {
    RegisterDto registerDto = new RegisterDto();
    registerDto.setEmail("register@example.com");

    UserDto mockUser = new UserDto();
    mockUser.setEmail("register@example.com");

    when(usersService.register(any(RegisterDto.class))).thenReturn(Optional.of(mockUser));

    mockMvc.perform(post("/api/users/auth/register")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{ \"email\": \"register@example.com\", \"password\": \"password\" }"))
            .andExpect(status().isCreated())   // 201 CREATED
            .andExpect(jsonPath("$.email").value("register@example.com"));
}
        @Test
        void testLoginUser() throws Exception {
            LoginDto loginDto = new LoginDto();
            loginDto.setEmail("login@example.com");

            when(usersService.login(any(LoginDto.class))).thenReturn("mock-jwt-token");

            mockMvc.perform(post("/api/users/auth/login")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{ \"email\": \"login@example.com\", \"password\": \"password123\" }"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.accessToken").value("mock-jwt-token"));
        }

    @Test
    @WithMockUser(roles = "ADMIN")
    void testUpdateUser() throws Exception {
        UserDto userDto = new UserDto();
        userDto.setUserId(1);
        userDto.setEmail("updated@example.com");

        when(usersService.updateUser(any(UserDto.class))).thenReturn(Optional.of(userDto));

        mockMvc.perform(put("/api/users")  // ✅ Fixed path
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"userId\": 1, \"email\": \"updated@example.com\" }"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("updated@example.com"));
    }


        @Test
        @WithMockUser(roles = "ADMIN")
        void testDeleteUser_Success() throws Exception {
            UserDto userDto = new UserDto();
            userDto.setUserId(1);
            when(usersService.getUser(anyInt())).thenReturn(Optional.of(userDto));
            when(usersService.deleteUser(anyString())).thenReturn(true);

            mockMvc.perform(delete("/api/users/1"))
                    .andExpect(status().isOk());
        }

}
