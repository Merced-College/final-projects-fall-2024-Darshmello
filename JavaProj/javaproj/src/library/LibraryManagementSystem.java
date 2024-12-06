package library; // Matches directory structure

import java.util.*;
import java.util.logging.Logger;

public class LibraryManagementSystem {
    private static final Logger logger = Logger.getLogger(LibraryManagementSystem.class.getName());

    private static final Library LIBRARY = new Library(); // Fixed constant naming
    private static final BorrowingSystem BORROWING_SYSTEM = new BorrowingSystem(); // Fixed constant naming
    private static final String BOOK_NOT_FOUND = "Book not found."; // Fixed constant naming

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
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
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addBook(scanner);
                case 2 -> removeBook(scanner);
                case 3 -> searchBook(scanner);
                case 4 -> LIBRARY.listBooks();
                case 5 -> borrowBook(scanner);
                case 6 -> returnBook(scanner);
                case 7 -> LIBRARY.sortBooks();
                case 8 -> {
                    logger.info("Exiting Library Management System. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> logger.warning("Invalid choice. Please try again.");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        logger.info("Enter book title: ");
        String title = scanner.nextLine();
        logger.info("Enter book author: ");
        String author = scanner.nextLine();
        LIBRARY.addBook(new Book(title, author));
    }

    private static void removeBook(Scanner scanner) {
        logger.info("Enter book title to remove: ");
        String title = scanner.nextLine();
        LIBRARY.removeBook(title);
    }

    private static void searchBook(Scanner scanner) {
        logger.info("Enter book title to search: ");
        String title = scanner.nextLine();
        Book book = LIBRARY.searchBook(title);
        if (book != null) {
            logger.info(() -> String.format("Found: %s", book));
        } else {
            logger.warning(BOOK_NOT_FOUND);
        }
    }

    private static void borrowBook(Scanner scanner) {
        logger.info("Enter book title to borrow: ");
        String title = scanner.nextLine();
        Book book = LIBRARY.searchBook(title);
        if (book != null) {
            BORROWING_SYSTEM.borrowBook(book);
        } else {
            logger.warning(BOOK_NOT_FOUND);
        }
    }

    private static void returnBook(Scanner scanner) {
        logger.info("Enter book title to return: ");
        String title = scanner.nextLine();
        Book book = LIBRARY.searchBook(title);
        if (book != null) {
            BORROWING_SYSTEM.returnBook(book);
        } else {
            logger.warning(BOOK_NOT_FOUND);
        }
    }
}
