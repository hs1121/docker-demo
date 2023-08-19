package com.example.backend.controller;

import com.example.backend.Util.Response;
import com.example.backend.model.BookRequest;
import com.example.backend.model.BookResponse;
import com.example.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class BookController {



    @Autowired
    private BookService bookService;


    @GetMapping(value = "health")
    public String health(){return "healthy";}


    @PostMapping(value = "book")
    @ResponseStatus(HttpStatus.CREATED)
    public Response<BookResponse> insertBook(BookRequest book){
       return bookService.insertBook(book);
    }
    @GetMapping(value = "book" , params = {"id"})
    public Response<BookResponse> getBook(@RequestParam  Long id){
        return bookService.getBook(id);
    }
    @GetMapping(value = "book" , params = { "name" })
    public Response<BookResponse> getBook2(@RequestParam String name){
        return bookService.getBook(name);
    }
    @PutMapping(value = "book")
    public Response<BookResponse> putBook(BookRequest book){
        return bookService.putBook(book);
    }
    @DeleteMapping(value = "book", params = {"id"})
    public Response<Void> deleteBook(@RequestParam Long id){
        return bookService.deleteBook(id);
    }
    @DeleteMapping(value = "book" , params = { "name" })
    public Response<Void> deleteBook2(@RequestParam String name){
        return bookService.deleteBook(name);
    }
    @GetMapping(value = "allbooks")
    public Response<List<BookResponse>> getAllBook(){
        return bookService.getAllBooks();
    }
}
