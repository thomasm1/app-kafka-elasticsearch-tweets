package app.mapl.repositories;

import app.mapl.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource( collectionResourceRel = "book", path = "books")
public interface BooksRepository extends JpaRepository<Book, Long> {

}