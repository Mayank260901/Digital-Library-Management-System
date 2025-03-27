package com.library.service;

import com.library.model.Book;
import com.library.model.AvailabilityStatus;
import java.util.*;

// Implementation of LibraryService
public class LibraryServiceImpl implements LibraryService {
    private final Map<String, Book> bookCatalog = new HashMap<>();

    @Override
    public void addBook(Book book) {
        if (book == null || book.getBookId() == null || book.getBookId().trim().isEmpty()) {
            throw new IllegalArgumentException("Book or Book ID cannot be null or empty.");
        }
        if (bookCatalog.containsKey(book.getBookId())) {
            throw new IllegalArgumentException("Book ID already exists.");
        }
        bookCatalog.put(book.getBookId(), book);
    }

    @Override
    public List<Book> viewAllBooks() {
        return new ArrayList<>(bookCatalog.values());
    }

    @Override
    public Book searchBookById(String bookId) {
        if (bookId == null || bookId.trim().isEmpty()) {
            throw new IllegalArgumentException("Book ID cannot be null or empty.");
        }
        return bookCatalog.getOrDefault(bookId, null);
    }

    @Override
    public List<Book> searchBookByTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        List<Book> result = new ArrayList<>();
        for (Book book : bookCatalog.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public void updateBook(String bookId, String title, String author, String genre, AvailabilityStatus status) {
        if (bookId == null || bookId.trim().isEmpty()) {
            throw new IllegalArgumentException("Book ID cannot be null or empty.");
        }
        if (!bookCatalog.containsKey(bookId)) {
            throw new IllegalArgumentException("Book ID not found.");
        }
        if (title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty() ||
                genre == null || genre.trim().isEmpty() || status == null) {
            throw new IllegalArgumentException("Title, author, genre, and status cannot be null or empty.");
        }
        Book book = bookCatalog.get(bookId);
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setAvailabilityStatus(status);
    }

    @Override
    public void deleteBook(String bookId) {
        if (bookId == null || bookId.trim().isEmpty()) {
            throw new IllegalArgumentException("Book ID cannot be null or empty.");
        }
        if (!bookCatalog.containsKey(bookId)) {
            throw new IllegalArgumentException("Book ID not found.");
        }
        bookCatalog.remove(bookId);
    }
}
