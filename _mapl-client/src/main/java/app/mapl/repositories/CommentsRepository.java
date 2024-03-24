package app.mapl.repositories;

import app.mapl.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;

//@RepositoryRestResource( collectionResourceRel = "comment", path = "comment")
public interface CommentsRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}
