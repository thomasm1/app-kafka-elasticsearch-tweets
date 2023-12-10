package app.mapl.repositories;

import app.mapl.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource( collectionResourceRel = "author", path = "author")
public interface AuthorRepository extends JpaRepository<Book, Long> {

}