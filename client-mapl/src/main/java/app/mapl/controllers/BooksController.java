package app.mapl.controllers;


import app.mapl.models.Book;
import app.mapl.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class BooksController {

    BooksService booksService;
    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }
    @RequestMapping(value = "/books", method = RequestMethod.POST, consumes = "application/json")
    public Book createBook(@RequestBody Book c) {
        return booksService.createBooks(c);
    }
    @GetMapping(value = "/books/{id}")
    public Book getBook(@PathVariable("id") long id) {

        return booksService.getBooks(id);
    }


    @GetMapping(value = "/books")
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

    @PutMapping(value = "/books", consumes = "application/json")
    public Book updateBook(@RequestBody Book change) {
        return booksService.updateBooks(change);
    }
    @DeleteMapping(value = "/books/{bookId}")
    public boolean deleteBook(@PathVariable("bookId") long bookId) {
        return booksService.deleteBooks(bookId);
    }


}
