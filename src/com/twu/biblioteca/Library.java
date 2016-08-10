package com.twu.biblioteca;

import java.util.Arrays;
import java.util.stream.Stream;

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
                .filter(Book::isAvailable)
                .map(book -> String.format(
                        "%s, author: %s, year published: %s",
                        book.getName(),
                        book.getAuthor(),
                        book.getYearPublished()) )
                .toArray(String[]::new);
    }

    public Boolean checkout(String bookName) {
        Boolean isSuccess = false;
        for (Book book: books) {
            Boolean isTargetedBook = bookName.equals(book.getName());
            if(isTargetedBook) {
                book.setAvailability(false);
                isSuccess = true;
                break;
            }
        }

        return isSuccess;
    }
}
