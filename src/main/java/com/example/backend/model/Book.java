package com.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id=0L;
    private String name;
    private String author;
    private Integer edition;
    private Double price;

    public Book(String name, String author, Integer edition, Double price) {
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.price = price;
    }

    public BookResponse toResponse(){
        return new BookResponse(name,author,edition,price);
    }
    public BookRequest toRequest(){
        return new BookRequest(name,author,edition,price);
    }
}
