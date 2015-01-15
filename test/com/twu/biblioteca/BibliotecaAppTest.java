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
}
