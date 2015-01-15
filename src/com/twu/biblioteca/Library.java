package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> bookList = new ArrayList<Book>();

    public void addBook(Book book){
        bookList.add(book);
    }

    public Boolean hasBook(Book book){
        return bookList.contains(book);
    }
}
