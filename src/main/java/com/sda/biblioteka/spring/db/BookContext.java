package com.sda.biblioteka.spring.db;

import com.sda.biblioteka.spring.db.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookContext {
    private static BookContext instance;

    private List<Book> books;

    public static BookContext getInstance(){
        if (instance == null){
            instance = new BookContext();
        }
        return instance;
    }

    private BookContext() {
        books = new ArrayList<>();
    }

    public Book findBook(String title){
        //TODO implementation
        return null;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public int getBooksCount(){
        return books.size();
    }
}
