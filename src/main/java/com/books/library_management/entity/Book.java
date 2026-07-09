package com.books.library_management.entity;


import jakarta.persistence.*;


import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String author;

    private Double price;

    private Boolean available = false;


    public Book() {
    }

    public Book(Integer id, String title, String author, Double price, Boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    public Integer getId() {

        return id;
    }

    public String getTitle() {

        return title;
    }

    public String getAuthor() {

        return author;
    }

    public Double getPrice() {

        return price;
    }

    public Boolean getAvailable() {

        return available;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public void setPrice(Double price) {

        this.price = price;
    }

    public void setAvailable(Boolean available) {

        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(price, book.price) && Objects.equals(available, book.available);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, author, price, available);
    }
}