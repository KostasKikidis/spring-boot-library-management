package com.books.library_management.controller;

import com.books.library_management.dto.BookDTO;
import com.books.library_management.entity.Book;
import com.books.library_management.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookMvcController {

    private final BookService bookService;

    public BookMvcController(BookService bookService) {

        this.bookService = bookService;
    }

    // ADD BOOK
    @PostMapping("/addBook")
    public String addBook(BookDTO bookdto) {
        bookService.addBook(bookdto);
        return ("redirect:/");

    }

    //DELETE BOOK BY ID
    @PostMapping("/deleteBook")
    public String deleteBook(@RequestParam Integer id) {

        bookService.deleteBook(id);

        return ("redirect:/");
    }

    //UPDATE BOOK BY ID
    @PostMapping("/updateBook")
    public String updateBook(@RequestParam Integer id, BookDTO bookdto) {

        bookService.updateBook(id, bookdto);

        return ("redirect:/");
    }

    // GET BOOKS BY ID
    @GetMapping("/getBookById")
    public String getBookById(@RequestParam Integer id, Model model) {
        model.addAttribute("books", bookService.getBookById(id));
        return "index";
    }

    // GET BOOKS BY AUTHOR
    @GetMapping("/booksByAuthor")
    public String getByAuthor(@RequestParam String author, Model model) {
        model.addAttribute("books", bookService.getBooksByAuthor(author));
        return "index";
    }

    // GET BOOKS BY TITLE
    @GetMapping("/booksByTitle")
    public String getByTitle(@RequestParam String title, Model model) {
        model.addAttribute("books", bookService.getBookByTitle(title));
        return "index";
    }

    //GET BOOKS GREATER THAN PRICE
    @GetMapping("/greaterThanPrice")
    public String greaterThanPrice(@RequestParam Double price, Model model) {
        model.addAttribute("books", bookService.getBooksGreaterThanPrice(price));
        return "index";

    }

    //GET BOOKS LESS THAN PRICE
    @GetMapping("lessThanPrice")
    public String lessThanPrice(@RequestParam Double price, Model model) {
        model.addAttribute("books", bookService.getBooksLessThanPrice(price));
        return "index";

    }

    @GetMapping("/availableBooks")
    public String getAvailableBooks(Model model) {
        model.addAttribute("books", bookService.getAvailableBooks());
        return "index";
    }

    @GetMapping("/notAvailableBooks")
    public String getNotAvailableBooks(Model model) {
        model.addAttribute("books", bookService.getNotAvailableBooks());
        return "index";
    }

    @GetMapping("/getAllBooks")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

}

