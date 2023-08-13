package com.example.backend.service;

import com.example.backend.Util.Database;
import com.example.backend.Util.Response;
import com.example.backend.model.BookRequest;
import com.example.backend.model.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private Database database= new Database();
    public Response<BookResponse> insertBook(BookRequest book){
        List<BookRequest> list = database.getDatabase();
        list.add(book);
        database.updateDatabase(list);

        return new Response<>(book.toResponse(),201,"Book Inserted successfully");
    }


    public Response<List<BookResponse>> getAllBooks() {
        List<BookResponse> listResponse = database.getDatabase().stream().map(BookRequest::toResponse).collect(Collectors.toList());
        return new Response<>(listResponse,200,"success");

    }

    public Response<BookResponse> getBook(Long id) {
        BookResponse bookResponse =null;
       for( BookRequest bookRequest : database.getDatabase() ){
            if (bookRequest.getKey()== id){
                bookResponse = bookRequest.toResponse();
                break;
            }
       }
       if(bookResponse == null)
           return new Response<>(bookResponse,404," Book Not Found");
       else
           return new Response<>(bookResponse,200," Success");
    }
    public Response<BookResponse> getBook(String name) {
        BookResponse bookResponse =null;
        for( BookRequest bookRequest : database.getDatabase() ){
            if (bookRequest.getName().equals(name)){
                bookResponse = bookRequest.toResponse();
                break;
            }
        }
        if(bookResponse == null)
            return new Response<>(null,404," Book Not Found");
        else
            return new Response<>(bookResponse,200," Success");
    }

    public Response<BookResponse> putBook(BookRequest book) {
        return new Response<>(null,200," Not Yet Implemented");
    }

    public Response<BookResponse> deleteBook(Long id) {
        BookRequest bookRequest1 =null;
        for( BookRequest bookRequest : database.getDatabase() ){
            if (bookRequest.getKey()== id){
                bookRequest1 = bookRequest;
                break;
            }
        }

        if(bookRequest1 == null)
            return new Response<>(null,404," Book Not Found");
        else {
            database.getDatabase().remove(bookRequest1);
            return new Response<>(bookRequest1.toResponse(), 200, "Book Deleted Successfully");
        }
    }

    public Response<BookResponse> deleteBook(String name) {
        BookRequest bookRequest1 =null;
        for( BookRequest bookRequest : database.getDatabase() ){
            if (bookRequest.getName().equals(name)){
                bookRequest1 = bookRequest;
                break;
            }
        }

        if(bookRequest1 == null)
            return new Response<>(null,404," Book Not Found");
        else {
            database.getDatabase().remove(bookRequest1);
            return new Response<>(bookRequest1.toResponse(), 200, "Book Deleted Successfully");
        }
    }
}
