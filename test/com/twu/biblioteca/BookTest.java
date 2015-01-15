package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    private Book oldMan = new Book("The Old Man and the Sea", "Ernest Hemmingway", "1951", false);

    @Test
    public void bookShouldHaveTitle (){
        assertEquals(oldMan.title, "The Old Man and the Sea");
    }

    @Test public void bookShouldHaveAuthor () {
        assertEquals(oldMan.author, "Ernest Hemmingway");
    }

    @Test public void bookShouldHaveYearPublished(){
        assertEquals(oldMan.yearPublished, "1951");
    }

    @Test public void bookShouldHaveCheckedOutStatus(){
        assertEquals(oldMan.isCheckedOut, false);
    }
}