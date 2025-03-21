package app.mapl.services;

import app.mapl.models.CommentDto;

import java.util.List;

public interface CommentsService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(Long postId, Long commentId);

    CommentDto updateComment(Long postId, long commentId, CommentDto commentRequest);

    boolean deleteComment(Long postId, Long commentId);

}
