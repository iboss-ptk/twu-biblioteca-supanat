package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTest {
    @Test
    public void testListAllBooks() {
        Book[] books = {
                new Book("book1", "author1", "1993"),
                new Book("book2", "author2", "2001"),
        };
        String[] booksResult = {
                "book1, author: author1, year published: 1993",
                "book2, author: author2, year published: 2001"
        };
        Library library = new Library(books);
        assertArrayEquals(booksResult, library.listAllBooks());
    }

    @Test
    public void testSuccessfulBookCheckout() {
        Book[] books = {
                new Book("book1", "author1", "1993"),
                new Book("book2", "author2", "2001"),
                new Book("book3", "author3", "2002")
        };
        String[] booksResult = {
                "book2, author: author2, year published: 2001",
                "book3, author: author3, year published: 2002"
        };
        Library library = new Library(books);
        Boolean isSuccess = library.checkout("book1");
        assertTrue(isSuccess);
        assertArrayEquals(booksResult, library.listAllBooks());
    }

    @Test
    public void testUnsuccessfulBookCheckout() {
        Book[] books = {
                new Book("book1", "author1", "1993"),
                new Book("book2", "author2", "2001"),
                new Book("book3", "author3", "2002")
        };
        String[] booksResult = {
                "book1, author: author1, year published: 1993",
                "book2, author: author2, year published: 2001",
                "book3, author: author3, year published: 2002"
        };
        Library library = new Library(books);
        Boolean isSuccess = library.checkout("book99");
        assertFalse(isSuccess);
        assertArrayEquals(booksResult, library.listAllBooks());
    }
}
