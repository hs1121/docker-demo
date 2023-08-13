package com.example.backend.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private Long key;
    private String name;
    private String author;
    private Integer edition;
    private Double price;

    public BookResponse toResponse(){
        return new BookResponse(name,author,edition,price);
    }

}

