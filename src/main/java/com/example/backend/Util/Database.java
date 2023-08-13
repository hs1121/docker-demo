package com.example.backend.Util;

import com.example.backend.model.BookRequest;


import java.util.ArrayList;
import java.util.List;


public class Database {
    private static List<BookRequest> bookDatabase =null;

    public List<BookRequest> getDatabase(){
        if(bookDatabase == null){
            bookDatabase = new ArrayList<>();
        }
        return bookDatabase;
    }
    public Database(){}


    public void updateDatabase(List<BookRequest> list){
       bookDatabase = list;
    }


}
