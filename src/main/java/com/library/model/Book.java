
package com.library.model;

// Book Model Class
public class Book {
    //Can be made final but that was not that necessary at this point of development.
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private AvailabilityStatus availabilityStatus;

    public Book(String bookId, String title, String author, String genre, AvailabilityStatus availabilityStatus) {
        if (bookId == null || bookId.isEmpty()) throw new IllegalArgumentException("Book ID cannot be empty");
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty");
        if (author == null || author.isEmpty()) throw new IllegalArgumentException("Author cannot be empty");
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }

    //these below options can be used in future when increasing the functionality of this system
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public AvailabilityStatus getAvailabilityStatus() { return availabilityStatus; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setAvailabilityStatus(AvailabilityStatus status) { this.availabilityStatus = status; }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Status: " + availabilityStatus;
    }
}
