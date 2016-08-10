package com.twu.biblioteca;

public class Book {
    private String name, author, yearPublished;
    private Boolean availability;

    public Book(String name, String author, String yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.availability = true;
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

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
