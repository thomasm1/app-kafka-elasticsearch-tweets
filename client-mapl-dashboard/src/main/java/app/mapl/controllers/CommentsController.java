package app.mapl.controllers;

import app.mapl.models.dto.CommentDto;
import app.mapl.exception.ResourceNotFoundException;
import app.mapl.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(CommentsController.API_POSTS)
public class CommentsController {

    public static final String POST_ID_COMMENTS = "/{postId}/comments";
    public static final String API_POSTS = "/api/posts";
    public static final String POST_ID_COMMENTS_ID = "/{postId}/comments/{id}";

    @Autowired
    private CommentsService commentsService;

    @PostMapping(POST_ID_COMMENTS)
    public ResponseEntity<CommentDto> createComment(@PathVariable long postId,
                                                    @Valid @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentsService.createComment(postId, commentDto), HttpStatus.CREATED);
    }

    @GetMapping(POST_ID_COMMENTS)
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") Long postId){
        return commentsService.getCommentsByPostId(postId);
    }

    @GetMapping(POST_ID_COMMENTS_ID)
    public ResponseEntity<Optional<CommentDto>> getCommentById(@PathVariable(value = "postId") Long postId,
                                                     @PathVariable(value = "id") Long commentId){
        Optional<CommentDto> commentDto = commentsService.getCommentById(postId, commentId);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PutMapping(POST_ID_COMMENTS_ID)
    public ResponseEntity<Optional<CommentDto>> updateComment(@PathVariable(value = "postId") Long postId,
                                                    @PathVariable(value = "id") Long commentId,
                                                    @Valid @RequestBody CommentDto commentDto){
        if (commentsService.updateComment(postId, commentId,commentDto).isEmpty()){
            throw new ResourceNotFoundException("Comment", "id", String.valueOf(commentId));
        }
        Optional<CommentDto> updatedComment = commentsService.updateComment(postId, commentId, commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping(POST_ID_COMMENTS_ID)
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,
                                                @PathVariable(value = "id") Long commentId){
        commentsService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }

}
