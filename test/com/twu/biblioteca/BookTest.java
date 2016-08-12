package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void testBookAvailability() {
        Book book = new Book("book1", "author1", "1993", true);
        assertTrue(book.isAvailable());
        assertFalse(book.withAvailability(false).isAvailable());
    }
}