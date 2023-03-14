// This class contains a list of books and provides multiple functionalities

package com.project.PergamumLibrary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Functionality for adding a book into the library
    public void addBook(Book book) {
        this.books.add(book);
    }

    // Functionality for displaying all the books in the library
    public List<Book> getAllBooksSorted() {
        // Sort the books by author and then by title
        Comparator<Book> byAuthorAndTitle = Comparator
                .comparing(Book::getAuthor)
                .thenComparing(Book::getTitle);

        List<Book> sortedBooks = new ArrayList<>(this.books);
        sortedBooks.sort(byAuthorAndTitle);

        return sortedBooks;
    }

    // Functionality for deleting a book
    public void deleteBook(Book book) {
        books.removeIf(b -> b.getTitle().equals(book.getTitle()) && b.getAuthor().equals(book.getAuthor()));
    }

    // Functionality for getting a book by its title
    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        // If we don't find the book, we return null
        return null;
    }

    // Functionality for updating a book's author
    public boolean updateAuthor(String title, String author) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.setAuthor(author);
                return true;
            }
        }
        return false;
    }
}


