package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    private Library library = new Library();
    private Book book1 = new Book("test", "Jen", "2011", false);
    private Book book2 = new Book("test2", "Joe", "2012", false);
    private Book bookNotInLibrary = new Book("test3", "Sue", "2013", false);

    @Before public void setupLibrary(){
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test public void testLibraryCanAddBooks(){
        assertTrue("The Library should have the added book", library.hasBook(book1));
    }

    @Test public void testLibraryCorrectlyChecksIfItHasBook(){
        assertFalse("Library should not have this book", library.hasBook(bookNotInLibrary));
    }

    @Test public void testCheckedOutBookIsNotInList(){
        library.checkOut(book1);
        assertFalse("after check out book should not be in library", library.hasBook(book1));
    }

    @Test public void testLibraryCanLoadFromFile(){
        Library bookLibrary = new Library("books.txt");
        assertEquals(bookLibrary.bookCount(), 2);
    }

    @Test public void testHasBookFromTitle(){
        assertTrue(library.hasBook("test"));
    }

    @Test public void testAfterCheckOutBookIsRecordedOnAnotherList(){
        library.checkOut(book2);
        assertTrue(library.checkedOutBookList.contains(book2));
    }

    @Test public void testReturnBookAddsBookBackToOriginalList(){
        library.checkOut(book2);
        library.returnBook(book2);
        assertTrue("after a return, the book should be on the book list", library.bookList.contains(book2));
    }

    @Test public void testReturnBookIsNotOnCheckedOutBookList(){
        library.checkOut(book2);
        library.returnBook(book2);
        assertFalse("after a return, the book should not be on the checked out book list",library.checkedOutBookList.contains(book2));
    }
}