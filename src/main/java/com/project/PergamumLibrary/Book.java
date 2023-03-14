package com.project.PergamumLibrary;

public class Book {
    private String title;
    private String author;

    // Defining constructor so that each book is assigned a title and an author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Defining setter and getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
