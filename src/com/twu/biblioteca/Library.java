package com.twu.biblioteca;

/**
 * Created by Supanat Potiwarakorn on 10/8/59.
 */
public class Library {
    private String[] books;

    public Library(String[] books) {
        this.books = books;
    }
    public String[] listAllBooks() {
        return this.books;
    }
}
