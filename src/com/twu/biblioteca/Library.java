package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> bookList = new ArrayList<Book>();

    public Library(){
        this.bookList = new ArrayList<Book>();
    }

    public Library(String fileName){
        try {
            File bookList = new File(fileName);
            FileReader fileReader = new FileReader(bookList);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            while ((line = reader.readLine()) != null){
                String[] details = line.split(", ");
                String title = details[0];
                String author = details[1];
                String publishYear = details[2];
                Book newBook = new Book(title, author, publishYear, false);
                this.addBook(newBook);
            }
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addBook(Book book){
        bookList.add(book);
    }

    public Boolean hasBook(Book book){
        return bookList.contains(book);
    }

    public void checkOut(Book book) {
        bookList.remove(book);
    }

    public int bookCount(){
        return bookList.size();
    }

    public void listBooks(){
        System.out.printf("%-32s%-32s%-32s\n", "Title", "Author", "Year Published");
        for (Book book : this.bookList){

            System.out.printf("%-32s%-32s%-32s\n", book.title, book.author, book.yearPublished);

        }
    }
}
