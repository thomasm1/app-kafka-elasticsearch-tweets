package net.ourdailytech.rest.controllerTests;


import net.ourdailytech.rest.controllers.CommentsController;
import net.ourdailytech.rest.models.dto.CommentDto;
import net.ourdailytech.rest.service.CommentsService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class CommentsControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CommentsService commentsService;

    @InjectMocks
    private CommentsController commentsController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(commentsController).build();
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void testCreateComment() throws Exception {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(1L);
        commentDto.setBody("Test comment");

        when(commentsService.createComment(anyLong(), any(CommentDto.class))).thenReturn(commentDto);

        mockMvc.perform(post("/api/posts/1/comments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"body\": \"Test comment\" }"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.body").value("Test comment"));
    }

    @Test
    void testGetCommentsByPostId() throws Exception {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(1L);
        commentDto.setBody("Test comment");

        when(commentsService.getCommentsByPostId(anyLong())).thenReturn(Collections.singletonList(commentDto));

        mockMvc.perform(get("/api/posts/1/comments")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].body").value("Test comment"));
    }

    @Test
    void testGetCommentById() throws Exception {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(1L);
        commentDto.setBody("Test comment");

        when(commentsService.getCommentById(anyLong(), anyLong())).thenReturn(commentDto);

        mockMvc.perform(get("/api/posts/1/comments/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.body").value("Test comment"));
    }

    @Test
    void testUpdateComment() throws Exception {
        CommentDto updatedComment = new CommentDto();
        updatedComment.setId(1L);
        updatedComment.setBody("Updated comment");

        when(commentsService.updateComment(anyLong(), anyLong(), any(CommentDto.class))).thenReturn(updatedComment);

        mockMvc.perform(put("/api/posts/1/comments/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"body\": \"Updated comment\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.body").value("Updated comment"));
    }

    @Test
    void testDeleteComment() throws Exception {
        // Ensure deleteComment is a void method before using doNothing()
        when(commentsService.deleteComment(anyLong(), anyLong())).thenReturn(true);

        mockMvc.perform(delete("/api/posts/1/comments/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Comment deleted successfully"));

        // Verify that the service method was called once
        verify(commentsService, times(1)).deleteComment(anyLong(), anyLong());
    }
}