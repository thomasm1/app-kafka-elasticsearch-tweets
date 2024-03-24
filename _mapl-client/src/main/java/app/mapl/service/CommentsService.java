package app.mapl.service;

import app.mapl.dto.CommentDto;

import java.util.List;
import java.util.Optional;

public interface CommentsService {

    List<CommentDto> getCommentsByPostId(long postId);

    Optional<CommentDto>  getCommentById(Long postId, Long commentId);

    CommentDto  createComment(long postId, CommentDto commentDto);

    Optional<CommentDto> updateComment(Long postId, long commentId, CommentDto commentRequest);

    boolean deleteComment(Long postId, Long commentId);

}
