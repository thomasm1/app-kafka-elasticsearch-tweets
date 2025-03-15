package net.ourdailytech.rest.service;

import net.ourdailytech.rest.exception.PostApiException;
import net.ourdailytech.rest.exception.ResourceNotFoundException;
import net.ourdailytech.rest.mapper.CommentMapper;
import net.ourdailytech.rest.models.Comment;
import net.ourdailytech.rest.models.PostEntity;
import net.ourdailytech.rest.models.dto.CommentDto;
import net.ourdailytech.rest.repositories.CommentsRepository;
import net.ourdailytech.rest.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentRepository;
    @Autowired
    PostRepository postRepository;

    @Autowired
    private CommentMapper commentMapper;

    /**
     * @param postId
     * @param commentDto
     * @return
     */
    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
       Comment comment = commentMapper.toEntity(commentDto);
       PostEntity post = postRepository.findById(postId).orElseThrow(
               () -> new ResourceNotFoundException("Post", "id", Long.toString(postId)));

       comment.setPost(post);
       Comment newComment = commentRepository.save(comment);
        return commentMapper.toDto(newComment);
    }

    /**
     * @param postId
     * @return
     */
    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);

        return comments.stream().map(
                comment -> commentMapper.toDto(comment)
        ).collect(Collectors.toList());
    }

    /**
     * @param postId
     * @param commentId
     * @return
     */
    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        PostEntity post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", Long.toString(postId)));

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("Comment", "id", Long.toString(commentId)));

        if(!Objects.equals(comment.getPost().getId(), post.getId())) {
            throw new PostApiException(HttpStatus.NOT_FOUND, Long.toString(commentId));
        }
        return commentMapper.toDto(comment);
    }

    /**
     * @param postId
     * @param commentId
     * @param commentRequest
     * @return
     */
    @Override
    public CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest) {
       PostEntity post = postRepository.findById(postId).orElseThrow(
               () -> new ResourceNotFoundException("Post", "id", Long.toString(postId)));
       Comment comment = commentRepository.findById(commentId).orElseThrow(
               () -> new ResourceNotFoundException("Comment", "id", Long.toString(commentId)));
       if(!comment.getPost().getId().equals(post.getId())) {
           throw new PostApiException(HttpStatus.NOT_FOUND,  Long.toString(commentId));
       }
        comment.setName(commentRequest.getName());
        comment.setBody(commentRequest.getBody());
        comment.setEmail(commentRequest.getEmail());

        Comment updatedComment = commentRepository.save(comment);
        return commentMapper.toDto(updatedComment);
    }

    /**
     * @param postId
     * @param commentId
     */
    @Override
    public boolean deleteComment(Long postId, Long commentId) {
        PostEntity post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", Long.toString(postId)));
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("Comment", "id", Long.toString(commentId)));
        if (!comment.getPost().getId().equals(post.getId())) {
            throw new PostApiException(HttpStatus.NOT_FOUND, Long.toString(commentId));
        } else {
            commentRepository.delete(comment);
            return true;
        }
    }

}
