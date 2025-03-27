
package com.library.service;

import com.library.model.Book;
import com.library.model.AvailabilityStatus;
import java.util.*;

// Service interface for Library operations
public interface LibraryService {
    void addBook(Book book);
    List<Book> viewAllBooks();
    Book searchBookById(String bookId);
    List<Book> searchBookByTitle(String title);
    void updateBook(String bookId, String title, String author, String genre, AvailabilityStatus status);
    void deleteBook(String bookId);
}
