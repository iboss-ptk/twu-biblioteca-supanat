package com.twu.biblioteca;

import java.util.Arrays;

public class Library {
    private Book[] books;
    public enum Operation { CHECKOUT, RETURN }

    public Library(Book[] books) {
        this.books = books;
    }

    public String[] listAvailableBooks() {
        return Arrays.stream(books)
                .filter(Book::isAvailable)
                .map(book -> String.format(
                        "%s, author: %s, year published: %s",
                        book.getName(),
                        book.getAuthor(),
                        book.getYearPublished()) )
                .toArray(String[]::new);
    }

    public boolean checkout(String bookName) {
        boolean isSuccess = isSuccess(Operation.CHECKOUT, bookName);
        books = operate(Operation.CHECKOUT, bookName);
        return isSuccess;
    }

    public boolean returnBook(String bookName) {
        boolean isSuccess = isSuccess(Operation.RETURN, bookName);
        books = operate(Operation.RETURN, bookName);
        return isSuccess;
    }

    private boolean isSuccess(Operation operation, String bookName) {
        boolean isSuccess = false;
        for (Book book : books) {
            isSuccess = isSuccess || canOperate(operation, book, bookName);
        }
        return isSuccess;
    }

    private Book[] operate(Operation operation, String bookName) {
        boolean targetAvailability = (operation == Operation.RETURN);
        return Arrays.stream(books)
                .map(book -> canOperate(operation, book, bookName)
                        ? book.withAvailability(targetAvailability)
                        : book)
                .toArray(Book[]::new);
    }

    private boolean canOperate(Operation operation, Book book, String bookName) {
        boolean isBookFound = book.getName().equals(bookName);
        boolean isCheckedOut = !book.isAvailable();
        switch (operation) {
            case CHECKOUT: return isBookFound;
            case RETURN: return isBookFound && isCheckedOut;
            default: return false;
        }
    }
}
