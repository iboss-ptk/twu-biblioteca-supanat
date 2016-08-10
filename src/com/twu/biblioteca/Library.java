package com.twu.biblioteca;

import java.util.Arrays;

/**
 * Created by Supanat Potiwarakorn on 10/8/59.
 */
public class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }
    public String[] listAllBooks() {
        return Arrays.stream(books)
                .map(book -> String.format(
                        "%s, author: %s, year published: %s",
                        book.getName(),
                        book.getAuthor(),
                        book.getYearPublished()) )
                .toArray(String[]::new);
    }

    public void checkout(String bookName) {
        books = Arrays.stream(books)
                .filter(book -> !bookName.equals(book.getName()))
                .toArray(Book[]::new);
    }
}
