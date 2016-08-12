package com.twu.biblioteca;

public class Book {
    final private String name, author, yearPublished;
    final private Boolean availability;

    public Book(String name, String author, String yearPublished, boolean availability) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public boolean isAvailable() {
        return this.availability;
    }

    public Book withAvailability(boolean availability) {
        return new Book(this.name, this.author, this.yearPublished, availability);
    }
}
