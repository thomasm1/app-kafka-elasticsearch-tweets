package app.mapl.repositories;

import app.mapl.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource( collectionResourceRel = "book", path = "book")
public interface BookRepository extends JpaRepository<Book, Long> {
    @Override
    <S extends Book> S save(S entity);
}