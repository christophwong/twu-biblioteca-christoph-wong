package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Library {

    public ArrayList<Book> bookList = new ArrayList<Book>();

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

    public Boolean hasBook(String title){
        Book testBook = new Book(title, "noauthor", "fakeyear", false);
        return bookList.contains(testBook);
    }

    public void checkOut(Book book) {
        bookList.remove(book);
    }

    public int bookCount(){
        return bookList.size();
    }

    public void listBooks(){
        System.out.printf("%-32s%-32s%-32s%-32s\n", "Id", "Title", "Author", "Year Published");
        int id = 0;
        for (Book book : this.bookList){
            System.out.printf("%-32d%-32s%-32s%-32s\n", id, book.title, book.author, book.yearPublished);
            id++;
        }
    }

    public void returnBook(Book book) {
        this.addBook(book);
    }
}
