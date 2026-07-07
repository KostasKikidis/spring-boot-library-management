package com.books.library_management.service;

import com.books.library_management.repository.BookRepository;
import com.books.library_management.entity.Book;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {

        this.bookRepository = bookRepository;
    }


    public Book addBook(Book book) {

        return bookRepository.save(book);
    }


    public List<Book> getAllBooks() {

        return bookRepository.findAll();
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book updateBook(Integer id, Book newbook) {
        if (bookRepository.existsById(id)) {
            Book oldbook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
            oldbook.setTitle(newbook.getTitle());
            oldbook.setAuthor(newbook.getAuthor());
            oldbook.setPrice(newbook.getPrice());
            oldbook.setAvailable(newbook.getAvailable());
            return bookRepository.save(oldbook);
        }
        return null;

    }

    public boolean deleteBook(Integer id) {

        if (!bookRepository.existsById(id)) {
            return false;
        }
        bookRepository.deleteById(id);
        return true;
    }


    public List<Book> getAvailableBooks() {
        List<Book> temp = bookRepository.findAll();
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : temp) {
            if (book.getAvailable().equals(true)) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> dbBooks = bookRepository.findAll();
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : dbBooks) {
            if (book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public List<Book> getBookByTitle(String title) {
        List<Book> allBooks = bookRepository.findAll();
        List<Book> booksByTitle = new ArrayList<>();
        for (Book book : allBooks) {
            if (book.getTitle().equals(title)) {
                booksByTitle.add(book);
            }

        }
        return booksByTitle;
    }

    public List<Book> getBooksGreaterThanPrice(Double price) {
        List<Book> theBooks = bookRepository.findAll();
        List<Book> booksbyprice = new ArrayList<>();
        for (Book book : theBooks) {
            if ((book.getPrice()) >= price) {
                booksbyprice.add(book);
            }
        }
        return booksbyprice;
    }

    public List<Book> getBooksLessThanPrice(Double price) {
        List<Book> theBooks = bookRepository.findAll();
        List<Book> bookslessbyprice = new ArrayList<>();
        for (Book book : theBooks) {
            if ((book.getPrice()) < price) {
                bookslessbyprice.add(book);
            }
        }
        return bookslessbyprice;
    }

    public void deleteAllBooks() {

        bookRepository.deleteAll();

    }

    public List<Book> getNotAvailableBooks() {
        List<Book> temp = bookRepository.findAll();
        List<Book> notAvailableBooks = new ArrayList<>();
        for (Book book : temp) {
            if (book.getAvailable().equals(false)) {
                notAvailableBooks.add(book);
            }
        }
        return notAvailableBooks;
    }
}




