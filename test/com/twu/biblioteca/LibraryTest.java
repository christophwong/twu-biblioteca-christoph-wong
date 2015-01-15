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

    @Test public void testCheckedOutBookIsNotInList(){
        Library library1 = new Library();
        library1.addBook(book1);
        library1.addBook(book2);
        library1.addBook(book3);
        library1.checkOut(book1);

        assertFalse("after check out book should not be in library", library1.hasBook(book1));
    }

    @Test public void testLibraryCanLoadFromFile(){
        Library bookLibrary = new Library("books.txt");
        assertEquals(bookLibrary.bookCount(), 2);
    }
}