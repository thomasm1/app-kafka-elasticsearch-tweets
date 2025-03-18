package net.ourdailytech.rest.controllerTests;

import net.ourdailytech.rest.controllers.PostEntityController;
import net.ourdailytech.rest.models.dto.PostEntityDto;
import net.ourdailytech.rest.models.dto.PostEntityResponse;
import net.ourdailytech.rest.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Collections;



@ExtendWith(MockitoExtension.class)
public class PostEntityControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PostService postService;

    @InjectMocks
    private PostEntityController postEntityController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(postEntityController).build();
    }

    @Test
    void testGetAllPosts() throws Exception {
        PostEntityResponse response = new PostEntityResponse();
        response.setContent(Collections.emptyList()); // Simulate no posts

        when(postService.getAllPosts(anyInt(), anyInt(), anyString(), anyString())).thenReturn(response);

        mockMvc.perform(get("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    void testGetAllPostsByUsername() throws Exception {
        PostEntityResponse response = new PostEntityResponse();
        response.setContent(Collections.singletonList(new PostEntityDto()));

        when(postService.getAllPostsByUsername(anyInt(), anyInt(), anyString(), anyString(), anyString()))
                .thenReturn(response);

        mockMvc.perform(get("/api/posts/username/testuser")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testGetPostById() throws Exception {
        PostEntityDto postEntityDto = new PostEntityDto();
        postEntityDto.setId(1L);
        postEntityDto.setTitle("Test Post");

        when(postService.getPostById(anyLong())).thenReturn(postEntityDto);

        mockMvc.perform(get("/api/posts/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(  jsonPath("$.id").value(1))
                .andExpect(  jsonPath("$.title").value("Test Post"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void testCreatePost() throws Exception {
        PostEntityDto postEntityDto = new PostEntityDto();
        postEntityDto.setId(1L);
        postEntityDto.setTitle("New Post");

        when(postService.createPost(any(PostEntityDto.class))).thenReturn(postEntityDto);

        mockMvc.perform(post("/api/posts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"title\": \"New Post\" }"))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.title").value("New Post"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void testUpdatePost() throws Exception {
        PostEntityDto postEntityDto = new PostEntityDto();
        postEntityDto.setId(1L);
        postEntityDto.setTitle("Updated Post");

        when(postService.updatePost(any(PostEntityDto.class), anyLong())).thenReturn(postEntityDto);

        mockMvc.perform(put("/api/posts/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"title\": \"Updated Post\" }"))
                .andExpect(status().isOk())
                .andExpect( jsonPath("$.title").value("Updated Post"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void testDeletePost() throws Exception {
        when(postService.deletePostById(anyLong())).thenReturn(true);

        mockMvc.perform(delete("/api/posts/1"))
                .andExpect(status().isOk());
    }
}
