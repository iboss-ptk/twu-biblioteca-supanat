package com.twu.biblioteca;

import java.util.Arrays;

public class Library {
    private Book[] items;
    public enum Operation { CHECKOUT, RETURN }

    public Library(Book[] books) {
        this.items = books;
    }

    public String[] listAvailableBooks() {
        return Arrays.stream(items)
                .filter(Book::isAvailable)
                .map(Book::getDetail)
                .toArray(String[]::new);
    }

    public boolean checkout(String itemName) {
        boolean isSuccess = isSuccess(Operation.CHECKOUT, itemName);
        items = operate(Operation.CHECKOUT, itemName);
        return isSuccess;
    }

    public boolean returnBook(String itemName) {
        boolean isSuccess = isSuccess(Operation.RETURN, itemName);
        items = operate(Operation.RETURN, itemName);
        return isSuccess;
    }

    private boolean isSuccess(Operation operation, String itemName) {
        boolean isSuccess = false;
        for (Book book : items) {
            isSuccess = isSuccess || canOperate(operation, book, itemName);
        }
        return isSuccess;
    }

    private Book[] operate(Operation operation, String itemName) {
        boolean targetAvailability = (operation == Operation.RETURN);
        return Arrays.stream(items)
                .map(book -> canOperate(operation, book, itemName)
                        ? book.withAvailability(targetAvailability)
                        : book)
                .toArray(Book[]::new);
    }

    private boolean canOperate(Operation operation, Book book, String itemName) {
        boolean isBookFound = book.getName().equals(itemName);
        boolean isCheckedOut = !book.isAvailable();
        switch (operation) {
            case CHECKOUT: return isBookFound;
            case RETURN: return isBookFound && isCheckedOut;
            default: return false;
        }
    }
}
