package library; // Matches directory structure

import java.util.*;
import java.util.logging.Logger;

public class LibraryManagementSystem {
    private static final Logger logger = Logger.getLogger(LibraryManagementSystem.class.getName());

    // The main library instance that stores all the books
    private static final Library LIBRARY = new Library(); 
    // Handles borrowing logic, like managing a queue for unavailable books
    private static final BorrowingSystem BORROWING_SYSTEM = new BorrowingSystem(); 
    // A constant message to avoid repeating "Book not found." everywhere
    private static final String BOOK_NOT_FOUND = "Book not found.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner for reading user input
        int choice; // Stores the user's menu selection

        while (true) { // Infinite loop to keep the program running until the user chooses to exit
            logger.info(() -> String.join(System.lineSeparator(),
                "Library Management System",
                "1. Add Book",
                "2. Remove Book",
                "3. Search Book",
                "4. List Books",
                "5. Borrow Book",
                "6. Return Book",
                "7. Sort Books",
                "8. Exit",
                "Enter your choice:"
            ));
            choice = scanner.nextInt(); // Get the user's choice
            scanner.nextLine(); // Consume the newline character so it doesn't mess with input

            // Handle the user's choice
            switch (choice) {
                case 1 -> addBook(scanner); // Add a book to the library
                case 2 -> removeBook(scanner); // Remove a book from the library
                case 3 -> searchBook(scanner); // Search for a book by its title
                case 4 -> LIBRARY.listBooks(); // List all books in the library
                case 5 -> borrowBook(scanner); // Borrow a book (or queue for it if unavailable)
                case 6 -> returnBook(scanner); // Return a borrowed book
                case 7 -> LIBRARY.sortBooks(); // Sort the books by title
                case 8 -> { 
                    logger.info("Exiting Library Management System. Goodbye!"); // Friendly exit message
                    scanner.close(); // Close the scanner to free up resources
                    return; // End the program
                }
                default -> logger.warning("Invalid choice. Please try again."); // Warn the user about invalid input
            }
        }
    }

    // Adds a new book to the library
    private static void addBook(Scanner scanner) {
        logger.info("Enter book title: "); // Prompt for the title
        String title = scanner.nextLine(); // Read the title
        logger.info("Enter book author: "); // Prompt for the author
        String author = scanner.nextLine(); // Read the author
        LIBRARY.addBook(new Book(title, author)); // Add the book to the library
    }

    // Removes a book from the library by its title
    private static void removeBook(Scanner scanner) {
        logger.info("Enter book title to remove: "); // Ask for the title of the book to remove
        String title = scanner.nextLine(); // Read the title
        LIBRARY.removeBook(title); // Remove the book from the library
    }

    // Searches for a book in the library by its title
    private static void searchBook(Scanner scanner) {
        logger.info("Enter book title to search: "); // Ask for the title to search for
        String title = scanner.nextLine(); // Read the title
        Book book = LIBRARY.searchBook(title); // Search for the book in the library
        if (book != null) { // If the book is found
            logger.info(() -> String.format("Found: %s", book)); // Log the book details
        } else {
            logger.warning(BOOK_NOT_FOUND); // Log a warning if the book isn't found
        }
    }

    // Borrows a book from the library
    private static void borrowBook(Scanner scanner) {
        logger.info("Enter book title to borrow: "); // Ask for the title of the book to borrow
        String title = scanner.nextLine(); // Read the title
        Book book = LIBRARY.searchBook(title); // Search for the book in the library
        if (book != null) { // If the book is found
            BORROWING_SYSTEM.borrowBook(book); // Borrow the book using the borrowing system
        } else {
            logger.warning(BOOK_NOT_FOUND); // Warn the user if the book isn't found
        }
    }

    // Returns a book to the library
    private static void returnBook(Scanner scanner) {
        logger.info("Enter book title to return: "); // Ask for the title of the book to return
        String title = scanner.nextLine(); // Read the title
        Book book = LIBRARY.searchBook(title); // Search for the book in the library
        if (book != null) { // If the book is found
            BORROWING_SYSTEM.returnBook(book); // Return the book using the borrowing system
        } else {
            logger.warning(BOOK_NOT_FOUND); // Warn the user if the book isn't found
        }
    }
}
