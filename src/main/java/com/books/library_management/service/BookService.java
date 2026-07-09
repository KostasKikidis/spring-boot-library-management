package com.books.library_management.service;

import com.books.library_management.dto.BookDTO;
import com.books.library_management.mapper.BookMapper;
import com.books.library_management.repository.BookRepository;
import com.books.library_management.entity.Book;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public BookService(BookRepository bookRepository, BookMapper bookMapper) {

        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }


    public BookDTO addBook(BookDTO bookdto) {
        Book booktoEntity = bookMapper.toEntity(bookdto);
        Book saved = bookRepository.save(booktoEntity);

        return bookMapper.toBookDTO(saved);
    }


    public List<BookDTO> getAllBooks() {

        return bookRepository.findAll().stream().map(bookMapper::toBookDTO).toList();
    }

    public BookDTO getBookById(Integer id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return bookMapper.toBookDTO(book);
    }

    public BookDTO updateBook(Integer id, BookDTO newbookdto) {
        if (bookRepository.existsById(id)) {
            Book oldbook = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
            oldbook.setTitle(newbookdto.getTitle());
            oldbook.setAuthor(newbookdto.getAuthor());
            oldbook.setPrice(newbookdto.getPrice());
            oldbook.setAvailable(newbookdto.getAvailable());
            Book book = bookRepository.save(oldbook);
            return bookMapper.toBookDTO(book);
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


    public List<BookDTO> getAvailableBooks() {
        List<BookDTO> temp = bookRepository.findAll().stream().map(bookMapper::toBookDTO).toList();
        List<BookDTO> availableBooks = new ArrayList<>();
        for (BookDTO bookdto : temp) {
            if (bookdto.getAvailable().equals(true)) {
                availableBooks.add(bookdto);
            }
        }
        return availableBooks;
    }

    public List<BookDTO> getBooksByAuthor(String author) {
        List<BookDTO> dbBooks = bookRepository.findAll().stream().map(bookMapper::toBookDTO).toList();
        List<BookDTO> booksByAuthor = new ArrayList<>();
        for (BookDTO bookdto : dbBooks) {
            if (bookdto.getAuthor().equals(author)) {
                booksByAuthor.add(bookdto);
            }
        }
        return booksByAuthor;
    }

    public List<BookDTO> getBookByTitle(String title) {
        List<BookDTO> allBooks = bookRepository.findAll().stream().map(bookMapper::toBookDTO).toList();
        List<BookDTO> booksByTitle = new ArrayList<>();
        for (BookDTO bookdto : allBooks) {
            if (bookdto.getTitle().equals(title)) {
                booksByTitle.add(bookdto);
            }

        }
        return booksByTitle;
    }

    public List<BookDTO> getBooksGreaterThanPrice(Double price) {
        List<BookDTO> theBooks = bookRepository.findAll().stream().map(bookMapper::toBookDTO).toList();
        List<BookDTO> tbooksbyprice = new ArrayList<>();
        for (BookDTO bookdto : theBooks) {
            if ((bookdto.getPrice()) >= price) {
                tbooksbyprice.add(bookdto);
            }
        }
        return tbooksbyprice;
    }

    public List<BookDTO> getBooksLessThanPrice(Double price) {
        List<BookDTO> theBooks = bookRepository.findAll().stream().map(bookMapper::toBookDTO).toList();
        List<BookDTO> bookslessbyprice = new ArrayList<>();
        for (BookDTO bookdto : theBooks) {
            if ((bookdto.getPrice()) < price) {
                bookslessbyprice.add(bookdto);
            }
        }
        return bookslessbyprice;
    }

    public void deleteAllBooks() {

        bookRepository.deleteAll();

    }

    public List<BookDTO> getNotAvailableBooks() {
        List<BookDTO> temp = bookRepository.findAll().stream().map(bookMapper::toBookDTO).toList();
        List<BookDTO> notAvailableBooks = new ArrayList<>();
        for (BookDTO bookdto : temp) {
            if (bookdto.getAvailable().equals(false)) {
                notAvailableBooks.add(bookdto);
            }
        }
        return notAvailableBooks;
    }
}




