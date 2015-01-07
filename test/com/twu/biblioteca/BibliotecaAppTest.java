package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void testDisplayOfWelcomeMessage() {
        application.welcome();
        assertEquals("Welcome to the Biblioteca Application\n",outputStream.toString());
    }

    @Test public void testDisplayOfBookList(){
        application.listBooks();
        assertEquals("The Old Man and the Sea\nThe Stranger\n", outputStream.toString());
    }
}
