package app.mapl.service;

import app.mapl.exception.PostApiException;
import app.mapl.exception.ResourceNotFoundException;
import app.mapl.models.Comment;
import app.mapl.dto.CommentDto;
import app.mapl.mapper.CommentMapper;
import app.mapl.models.PostEntity;
import app.mapl.repositories.CommentsRepository;
import app.mapl.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class CommentsServiceJPA implements CommentsService {

    private CommentsRepository commentRepository;
    PostRepository postRepository;

    private CommentMapper commentMapper;

    @Autowired
    public CommentsServiceJPA(CommentsRepository commentRepository, PostRepository postRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.commentMapper = commentMapper;
    }

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
    public Optional<CommentDto> getCommentById(Long postId, Long commentId) {
        PostEntity post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", Long.toString(postId)));

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new ResourceNotFoundException("Comment", "id", Long.toString(commentId)));

        if(comment.getPost().getId() != post.getId()) {
            throw new PostApiException(HttpStatus.NOT_FOUND, Long.toString(commentId));
        }
        return Optional.ofNullable(commentMapper.toDto(comment));
    }

    /**
     * @param postId
     * @param commentId
     * @param commentRequest
     * @return
     */
    @Override
    public Optional<CommentDto> updateComment(Long postId, long commentId, CommentDto commentRequest) {
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
        return Optional.ofNullable(commentMapper.toDto(updatedComment));
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
