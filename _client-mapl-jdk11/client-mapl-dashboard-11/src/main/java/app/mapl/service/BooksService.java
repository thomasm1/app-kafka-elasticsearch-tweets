package app.mapl.service;

import app.mapl.models.Book;

import java.util.List;

public interface BooksService {
    public Book createBooks(Book bkmk);

    public Book getBooks(long id);


    public List<Book> getAllBooks();

    public Book updateBooks(Book change);

    public boolean deleteBooks(long id);

}
