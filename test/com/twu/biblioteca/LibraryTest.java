package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    private Library library = new Library();
    private Book book1 = new Book("test", "Jen", "2011", false);
    private Book book2 = new Book("test2", "Joe", "2012", false);
    private Book book3 = new Book("test3", "Sue", "2013", false);

    @Test public void testLibraryCanAddBooks(){
        library.addBook(book1);
        assertTrue("The Library does not have the added book", library.hasBook(book1));
    }

    @Test public void testLibraryCorrectlyChecksIfItHasBook(){
        assertFalse("Library should not have this book", library.hasBook(book2));
    }

}