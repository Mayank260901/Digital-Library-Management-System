
package com.library;

import com.library.model.Book;
import com.library.model.AvailabilityStatus;
import com.library.service.LibraryService;
import com.library.service.LibraryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class LibraryServiceTest {
    private LibraryService libraryService;

    //THis is to set up the test cases to be checked.
    @BeforeEach
    void setUp() {
        libraryService = new LibraryServiceImpl();
    }

    //This part check the add Book part of the code.
    @Test
    void testAddBook() {
        Book book = new Book("1", "Test Book", "Author", "Fiction", AvailabilityStatus.AVAILABLE);
        libraryService.addBook(book);
        assertEquals(1, libraryService.viewAllBooks().size());
    }

    //This part tests the search Book by id  part of the code.
    @Test
    void testSearchBookById() {
        Book book = new Book("2", "Another Book", "Author", "Non-Fiction", AvailabilityStatus.AVAILABLE);
        libraryService.addBook(book);
        assertNotNull(libraryService.searchBookById("2"));
    }

    //This part tests the search Book by title part of the code.
    @Test
    void testSearchBookByTitle() {
        Book book = new Book("3", "Unique Title", "Author", "Sci-Fi", AvailabilityStatus.AVAILABLE);
        libraryService.addBook(book);
        List<Book> books = libraryService.searchBookByTitle("Unique Title");
        assertFalse(books.isEmpty());
    }

    //This part checks if the books are getting updated or not.
    @Test
    void testUpdateBook() {
        Book book = new Book("4", "Old Title", "Author", "Fantasy", AvailabilityStatus.AVAILABLE);
        libraryService.addBook(book);
        libraryService.updateBook("4", "New Title", "New Author", "Horror", AvailabilityStatus.CHECKED_OUT);
        Book updatedBook = libraryService.searchBookById("4");
        assertEquals("New Title", updatedBook.getTitle());
    }

    //this part of code checks if books are getting deleted while doing or not.
    @Test
    void testDeleteBook() {
        Book book = new Book("5", "To Be Deleted", "Author", "Mystery", AvailabilityStatus.AVAILABLE);
        libraryService.addBook(book);
        libraryService.deleteBook("5");
        assertNull(libraryService.searchBookById("5"));
    }
}
