package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Supanat Potiwarakorn on 10/8/59.
 */
public class LibraryTest {
    @Test
    public void testListAllBooks() {
        String[] books = {"book1", "book2"};
        Library library = new Library(books);
        assertArrayEquals(books, library.listAllBooks());
    }
}
