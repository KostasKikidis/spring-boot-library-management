package com.books.library_management.controller;

import com.books.library_management.dto.BookDTO;
import com.books.library_management.entity.Book;
import com.books.library_management.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {

        this.bookService = bookService;
    }


    @PostMapping("/addBook")
    public ResponseEntity<BookDTO> addBook(@Valid @RequestBody BookDTO bookdto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(bookdto));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<BookDTO>> getBooks() {

        if ((bookService.getAllBooks()).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }


    @GetMapping("/getBook/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Integer id) {

        if ((bookService.getBookById(id)) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
    }


    @GetMapping("/availableBooks")
    public ResponseEntity<List<BookDTO>> getAvailableBooks() {
        if ((bookService.getAvailableBooks()).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAvailableBooks());
    }

    @GetMapping("/notAvailableBooks")
    public ResponseEntity<List<BookDTO>> getNotAvailableBooks() {
        if (bookService.getNotAvailableBooks().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getNotAvailableBooks());
    }


    @GetMapping("/getBooksByAuthor/{author}")
    public ResponseEntity<List<BookDTO>> getBooksByAuthor(@PathVariable String author) {
        if ((bookService.getBooksByAuthor(author)).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksByAuthor(author));
    }


    @GetMapping("/getBooksByTitle/{title}")
    public ResponseEntity<List<BookDTO>> getBookByTitle(@PathVariable String title) {

        if ((bookService.getBookByTitle(title)).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookByTitle(title));

    }

    @GetMapping("/greaterThanPrice/{price}")
    public ResponseEntity<List<BookDTO>> getBooksGreaterThanPrice(@PathVariable Double price) {
        if (bookService.getBooksGreaterThanPrice(price).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksGreaterThanPrice(price));
    }

    @GetMapping("/lessThanPrice/{price}")
    public ResponseEntity<List<BookDTO>> getBooksLessThanPrice(@PathVariable Double price) {
        if (bookService.getBooksLessThanPrice(price).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooksLessThanPrice(price));
    }


    @PutMapping("/updateBook/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Integer id, @Valid @RequestBody BookDTO newbookdto) {

        if ((bookService.updateBook(id, newbookdto)) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(id, newbookdto));
    }


    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {

        if (!bookService.deleteBook(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllBooks() {

        bookService.deleteAllBooks();

        return ResponseEntity.noContent().build();

    }

}
