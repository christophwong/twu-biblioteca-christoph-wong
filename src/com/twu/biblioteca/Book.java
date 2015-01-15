package com.twu.biblioteca;

public class Book {

    public String title;
    public String author;
    public String yearPublished;
    public Boolean isCheckedOut;

    public Book(String title, String author, String yearPublished, boolean isCheckedOut) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isCheckedOut = isCheckedOut;
    }

    @Override
    public boolean  equals (Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            Book book = (Book) object;
            if (this.title == book.title) {
                result = true;
            }
        }
        return result;
    }
}
