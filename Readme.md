
# Digital Library Book Management System

## Objective
This project is a command-line application designed to help librarians efficiently manage books, including adding, updating, searching, and deleting records while tracking their availability status.

## Features
- **Add a Book**: Enter book details and store them.
- **View All Books**: Display a list of all books.
- **Search by ID or Title**: Find books using their ID or title.
- **Update Book Details**: Modify book information, including availability status.
- **Delete a Book**: Remove a book from the system.
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

## Error Handling & Constraints
- Book ID must be unique.
- Title and Author cannot be empty.
- Availability status must be `AVAILABLE` or `CHECKED_OUT`.
- Exception handling ensures robustness against invalid inputs.

## Reflection
During the development process, the focus was on modular design and adherence to OOPS principles. Strictly according to the CODE EVALUATION CRITERIA mentioned in the given document the development was done.

It the more time has given  the enhancements can be done, which can include:
- Database integration for persistence. Could be Sql or No-Sql.
- Web-based UI for better usability. Spring Boot 
- Role-based access control. Authorization and Authentication

---
Developed by: * Mayank Bhargava *
