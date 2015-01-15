package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

public class BibliotecaAppTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    @Before
    public void setupStreams(){
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void cleanUpStreams(){
        System.setOut(null);
    }

    private BibliotecaApp application = new BibliotecaApp();

    @Test public void testDisplayOfWelcomeMessage() {
        application.welcome();
        assertEquals("Welcome to the Biblioteca Application\n",outputStream.toString());
    }

    @Test public void testDisplayOfBookList(){
        application.listBooks();
        assertThat(outputStream.toString(), containsString("The Old Man and the Sea"));
        assertThat(outputStream.toString(), containsString("Albert Camus"));
        assertThat(outputStream.toString(), containsString("1951"));
    }

    @Test public void testDisplayOfMenu(){
        application.showmenu();
        assertThat(outputStream.toString(), containsString("List Books"));
    }

    @Test public void testAbleToChooseOption(){
        application.relayOptions(1);
        assertThat(outputStream.toString(), containsString("The Old Man and the Sea"));
    }

    @Test public void testInvalidOptionCausesRepromt(){
        application.relayOptions(32);
        assertThat(outputStream.toString(), containsString("Invalid option"));
    }

    @Test public void testCheckOutBookShouldNotShowUpInList(){
        application.checkOut(1);
        application.listBooks();
        assertThat(outputStream.toString(), containsString("The Old Man and the Sea"));
        assertThat(outputStream.toString(), not(containsString("Albert Camus")));
    }

    @Test public void testCheckOutShouldReplyWithThankYou(){
        application.checkOut(0);
        assertThat(outputStream.toString(), containsString("Thank you! Enjoy the book"));
    }

    @Test public void testCheckOutOfUnavailableBookGivesWarning(){
        application.checkOut(4);
        assertThat(outputStream.toString(), containsString("Book is unavailable"));
    }

    @Test public void testReturnBookShouldShowUp(){
        Library library = new Library();
        Book book1 = new Book("test title", "test author", "2011", false);
        library.addBook(book1);
        library.checkOut(book1);
        library.returnBook(book1);

        assertTrue("after return, library should have the book", library.hasBook(book1));

    }
}
