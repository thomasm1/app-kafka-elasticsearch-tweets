package app.mapl.services;

import app.mapl.models.Book;
import app.mapl.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    BooksRepository booksRepository;

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
