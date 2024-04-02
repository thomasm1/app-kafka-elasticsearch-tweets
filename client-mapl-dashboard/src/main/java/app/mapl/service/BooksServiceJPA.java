package app.mapl.service;

import app.mapl.models.Book;
import app.mapl.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Primary
@Service
public class BooksServiceJPA implements BooksService {

    private final BookRepository booksRepository;

    @Override
    public Book createBooks(Book bkmk) {
        return booksRepository.save(bkmk);
    }

    @Override
    public Book getBooks(long id) {
        try {
            return booksRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    };

    @Override
    public Book updateBooks(Book change) {
        return booksRepository.save(change);
    }

    @Override
    public boolean deleteBooks(long id) {

        try {
            booksRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
