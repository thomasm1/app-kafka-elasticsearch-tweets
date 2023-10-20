package app.mapl.controllers;


import app.mapl.models.Book;
import app.mapl.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(BooksController.API)
@RestController
public class BooksController {

    public static final String API = "/api";
    public static final String BOOKS = "/books";
    public static final String BOOKS_ID = "/books/{id}";
    public static final String BOOKS_BOOK_ID = "/books/{bookId}";
    BooksService booksService;
    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }
    @RequestMapping(value = BOOKS, method = RequestMethod.POST, consumes = "application/json")
    public Book createBook(@RequestBody Book c) {
        return booksService.createBooks(c);
    }
    @GetMapping(value = BOOKS_ID)
    public Book getBook(@PathVariable("id") long id) {

        return booksService.getBooks(id);
    }


    @GetMapping(value = BOOKS)
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

    @PutMapping(value = BOOKS, consumes = "application/json")
    public Book updateBook(@RequestBody Book change) {
        return booksService.updateBooks(change);
    }
    @DeleteMapping(value = BOOKS_BOOK_ID)
    public boolean deleteBook(@PathVariable("bookId") long bookId) {
        return booksService.deleteBooks(bookId);
    }


}
