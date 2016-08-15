package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    private final Library library;

    public BibliotecaApp(Library library) {
        this.library = library;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book("book1", "author1", "1993", true),
                new Book("book2", "author2", "2001", true),
                new Book("book3", "author3", "2002", true)
        };

        BibliotecaApp app = new BibliotecaApp(new Library(books));
        app.showWelcomeMessage();
        app.showMainMenu();
    }

    public void showWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!");
    }

    public void showMainMenu() {
        System.out.print(
                "== Main menu ==\n" +
                "1) List Books\n" +
                "2) Checkout Book\n" +
                "3) Return Book\n" +
                "4) Quit\n" +
                "Select number: ");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine().trim();

        switch (option) {
            case "1":
                showBookList();
                break;
            case "2":
                checkoutBook();
                break;
            case "3":
                returnBook();
                break;
            case "4":
                return;
            default:
                System.out.println("Select a valid option!");
        }

        scanner.nextLine();
        showMainMenu();
    }

    private void showBookList() {
        for (String line: library.listAvailableBooks()) {
            System.out.println(line);
        }
    }

    private void checkoutBook() {
        operate(
                Library.Operation.CHECKOUT,
                "Which book do you want to checkout: ",
                "Thank you! Enjoy the book.",
                "That book is not available.");
    }

    private void returnBook() {
        operate(
                Library.Operation.RETURN,
                "Which book do you want to return: ",
                "Thank you for returning the book.",
                "That is not a valid book to return.");
    }

    private void operate(Library.Operation operation, String prompt, String successMessage, String failureMessage) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine().trim();
        System.out.println();
        boolean isSuccess;
        switch (operation) {
            case CHECKOUT:
                isSuccess = library.checkout(bookName);
                if(isSuccess) {
                    System.out.println(successMessage);
                } else {
                    System.out.println(failureMessage);
                    checkoutBook();
                }
                break;
            case RETURN:
                isSuccess = library.returnBook(bookName);
                if(isSuccess) {
                    System.out.println(successMessage);
                } else {
                    System.out.println(failureMessage);
                    returnBook();
                }
                break;
            default:
                throw new IllegalArgumentException("Operation not found");
        }
    }
}
