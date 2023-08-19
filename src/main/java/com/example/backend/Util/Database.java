package com.example.backend.Util;

import com.example.backend.model.Book;


import java.util.ArrayList;
import java.util.List;


public class Database {
    private static List<Book> bookDatabase =null;

    public List<Book> getDatabase(){
        if(bookDatabase == null){
            bookDatabase = new ArrayList<>();
        }
        return bookDatabase;
    }
    public Database(){}


    public void updateDatabase(List<Book> list){
       bookDatabase = list;
    }


}
