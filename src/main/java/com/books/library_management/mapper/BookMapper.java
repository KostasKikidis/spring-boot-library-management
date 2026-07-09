package com.books.library_management.mapper;

import com.books.library_management.dto.BookDTO;
import com.books.library_management.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(BookDTO bookdto) {

        Book book = new Book();

        book.setId(bookdto.getId());
        book.setTitle(bookdto.getTitle());
        book.setAuthor(bookdto.getAuthor());
        book.setPrice(bookdto.getPrice());
        book.setAvailable(bookdto.getAvailable());

        return book;
    }


    public BookDTO toBookDTO(Book book) {

        BookDTO bookdto = new BookDTO();

        bookdto.setId(book.getId());
        bookdto.setTitle(book.getTitle());
        bookdto.setAuthor(book.getAuthor());
        bookdto.setPrice(book.getPrice());
        bookdto.setAvailable(book.getAvailable());

        return bookdto;
    }


}
