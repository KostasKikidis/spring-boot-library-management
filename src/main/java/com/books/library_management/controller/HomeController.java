package com.books.library_management.controller;


import com.books.library_management.service.BookService;
import org.springframework.stereotype.Controller;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

    private final BookService bookservice;

    public HomeController(BookService bookservice) {

        this.bookservice = bookservice;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", bookservice.getAllBooks());
        return "index";
    }

}
