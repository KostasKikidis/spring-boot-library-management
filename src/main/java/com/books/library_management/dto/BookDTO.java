package com.books.library_management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BookDTO {

    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @Positive
    @NotNull
    private Double price;
    @NotNull
    private Boolean available = false;


    public BookDTO() {
    }

    public BookDTO(Integer id, String title, String author, Double price, Boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getAuthor() {

        return author;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public Double getPrice() {

        return price;
    }

    public void setPrice(Double price) {

        this.price = price;
    }

    public Boolean getAvailable() {

        return available;
    }

    public void setAvailable(Boolean available) {

        this.available = available;
    }
}
