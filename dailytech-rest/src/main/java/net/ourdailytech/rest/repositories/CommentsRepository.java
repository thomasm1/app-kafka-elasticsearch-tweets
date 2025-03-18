package net.ourdailytech.rest.repositories;

import net.ourdailytech.rest.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}
