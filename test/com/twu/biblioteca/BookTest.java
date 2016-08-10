package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Supanat Potiwarakorn on 10/8/59.
 */
public class BookTest {
    @Test
    public void testBookAvailability() {
        Book book = new Book("book1", "author1", "1993");
        assertTrue(book.isAvailable());

        book.setAvailability(false);
        assertFalse(book.isAvailable());
    }
}