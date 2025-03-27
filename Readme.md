# Digital Library Book Management System

## Objective
This project is a command-line application designed to help librarians efficiently manage books, including adding, updating, searching, and deleting records while tracking their availability status. It ensures data integrity with strict validation rules to prevent errors.

## Features
- **Add a Book**: Enter book details and store them with validation checks.
- **View All Books**: Display a list of all books.
- **Search by ID or Title**: Find books using their ID or title.
- **Update Book Details**: Modify book information, including availability status.
- **Delete a Book**: Remove a book from the system.
- **Data Validation**: Ensures book ID is unique, fields are non-empty, and availability status is valid.
- **Exit System**: Safely close the application.

## Project Structure
```
DigitalLibrarySystem/
│
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/library/
│   │   │   │   ├── model/
│   │   │   │   │   ├── Book.java
│   │   │   │   │   ├── AvailabilityStatus.java
│   │   │   │   ├── service/
│   │   │   │   │   ├── LibraryService.java
│   │   │   │   │   ├── LibraryServiceImpl.java
│   │   │   │   ├── ui/
│   │   │   │   │   ├── LibraryUI.java
│   │   │   │   ├── Main.java
│   ├── test/
│   │   ├── java/
│   │   │   ├── com/library/
│   │   │   │   ├── LibraryServiceTest.java
└── README.md
```

- **Model Layer**: Contains the Book class to represent book data.
- **Service Layer**: Provides business logic to manage books (add, update, delete, etc.).
- **UI Layer**: Provides a simple console interface to interact with the library system.
- **Main Class**: Starts the application and shows the main menu.
- **Test**: Unit tests for the LibraryService class.

## Setup and Run Instructions
### Prerequisites
- Java 8 or later
- Maven

### Steps to Run
1. Clone the repository:
   ```sh
   git clone https://github.com/Mayank260901/Digital-Library-Management-System.git
   cd DigitalLibrarySystem
   ```
2. Compile and package the application:
   ```sh
   mvn clean package
   ```
3. Run the application:
   ```sh
   java -jar target/DigitalLibrarySystem-1.0.jar
   ```

## Testing
To run the test cases, execute:
```sh
mvn test
```

## Data Validation & Error Handling
- **Book ID must be unique**: Duplicate entries are not allowed.
- **Title and Author cannot be empty**: Ensures meaningful book records.
- **Availability status must be `AVAILABLE` or `CHECKED_OUT`**.
- **Exception handling ensures robustness against invalid inputs.**

## Future Enhancements
If given more time, the following enhancements can be implemented:
- **Database Integration**: Store book records in SQL or NoSQL databases.
- **Web-based UI**: Develop a Spring Boot application for better usability.
- **Role-based Access Control**: Implement authentication and authorization.

---
Developed by: **Mayank Bhargava**
