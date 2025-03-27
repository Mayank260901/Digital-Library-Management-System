
package com.library.ui;

import com.library.model.Book;
import com.library.model.AvailabilityStatus;
import com.library.service.LibraryService;
import com.library.service.LibraryServiceImpl;

import java.util.List;
import java.util.Scanner;

public class LibraryUI {
    private final LibraryService libraryService;
    private final Scanner scanner;

    public LibraryUI() {
        this.libraryService = new LibraryServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    //This helps in providing the command line interface and helps to select  the functionality by choosing the required option.
    public void start() {
        while (true) {
            System.out.println("\nLibrary Book Management System\n" +
                    "1. Add a Book\n" +
                    "2. View All Books\n" +
                    "3. Search Book by ID\n" +
                    "4. Search Book by Title\n" +
                    "5. Update Book Details\n" +
                    "6. Delete a Book\n" +
                    "7. Exit\n" +
                    "Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    searchBookById();
                    break;
                case 4:
                    searchBookByTitle();
                    break;
                case 5:
                    updateBook();
                    break;
                case 6:
                    deleteBook();
                    break;
                case 7:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //This provides UI to add Book into the database.
    private void addBook() {
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Availability Status (AVAILABLE / CHECKED_OUT): ");
        String statusInput = scanner.nextLine();

        try {
            AvailabilityStatus status = AvailabilityStatus.fromString(statusInput);
            Book book = new Book(bookId, title, author, genre, status);
            libraryService.addBook(book);
            System.out.println("Book added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //this code prints all book that are registered in the system
    private void viewAllBooks() {
        List<Book> books = libraryService.viewAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            books.forEach(System.out::println);
        }
    }

    //This block of code provides UI for searching the book with by ID from database.
    private void searchBookById() {
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        Book book = libraryService.searchBookById(bookId);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    //This block of code provides UI for searching the book with by title from database.
    private void searchBookByTitle() {
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        List<Book> books = libraryService.searchBookByTitle(title);
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            books.forEach(System.out::println);
        }
    }

    //This block of code provides UI for updating the information of the book from database.

    private void updateBook() {
        System.out.print("Enter Book ID to update: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter New Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter New Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter New Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter New Availability Status (AVAILABLE / CHECKED_OUT): ");
        String statusInput = scanner.nextLine();

        try {
            AvailabilityStatus status = AvailabilityStatus.fromString(statusInput);
            libraryService.updateBook(bookId, title, author, genre, status);
            System.out.println("Book updated successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    //This block of code provides UI for deleting the book from database
    private void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String bookId = scanner.nextLine();
        try {
            libraryService.deleteBook(bookId);
            System.out.println("Book deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
