package com.example.backend.service;

import com.example.backend.Util.Database;
import com.example.backend.Util.Response;
import com.example.backend.model.Book;
import com.example.backend.model.BookRequest;
import com.example.backend.model.BookResponse;
import com.example.backend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    private Database database= new Database();
    public Response<BookResponse> insertBook(BookRequest bookRequest){
        Book book = bookRequest.toBook();

        Book response =bookRepository.save(book);

        return new Response<>(response.toResponse(), HttpStatus.CREATED.value(),"Book Inserted successfully");
    }


    public Response<List<BookResponse>> getAllBooks() {
        List<BookResponse> response = bookRepository.getAllBooks().stream().map(Book::toResponse).collect(Collectors.toList());
        return new Response<>(response,200,"success");

    }

    public Response<BookResponse> getBook(Long id) {
        Optional<Book> optionalBook=bookRepository.findById(id);
        if (optionalBook.isEmpty())
            return new Response<>(null,HttpStatus.NOT_FOUND.value()," Book Not Found");

        return new Response<>(optionalBook.get().toResponse(), 200," Success");
    }
    public Response<BookResponse> getBook(String name) {
        Optional<Book> bookOptional=bookRepository.getBookByName(name);
        if (bookOptional.isEmpty())
            return new Response<>(null,404," Book Not Found");

        return new Response<>(bookOptional.get().toResponse(), 200," Success");


    }

    public Response<BookResponse> putBook(BookRequest book) {
        return new Response<>(null,200," Not Yet Implemented");
    }

    public Response<Void> deleteBook(Long id) {
        Optional<Book> bookOptional=bookRepository.findById(id);
        if (bookOptional.isEmpty())
            return new Response<>(null,HttpStatus.NOT_FOUND.value(), " Book Not Found");
         bookRepository.deleteById(id);
        return new Response<>(null, 200, "Book Deleted Successfully");
    }

    @Transactional
    public Response<Void> deleteBook(String name) {
        Optional<Book> bookOptional=bookRepository.getBookByName(name);
        if (bookOptional.isEmpty())
            return new Response<>(null,HttpStatus.NOT_FOUND.value(), " Book Not Found");
        bookRepository.deleteBookByName(name);

        return new Response<>(null, 200, " Book Deleted Successfully");
    }
}
