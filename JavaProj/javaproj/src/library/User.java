package library;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
    private static final Logger logger = Logger.getLogger(User.class.getName());
    private final String userID; // Unique identifier for the user
    private final List<Book> borrowedBooks = new ArrayList<>(); // List of books the user has borrowed
    private double penalties; // The user's total penalty amount, scrapped

    // Creates a new user with a given user ID and initializes penalties to zero.
    // Tried adding penalties, could not get points figured out
    // @param userID the unique identifier for the user
    public User(String userID) {
        this.userID = userID;
        this.penalties = 0.0;
    }

    // Adds a book to the list of books borrowed by the user and logs the action.
    // @param book the book being borrowed
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        logger.log(Level.INFO, "User {0} borrowed: {1}", new Object[]{userID, book.getTitle()});
    }

    // Removes a book from the user's borrowed list and logs the action.
    // @param book the book being returned
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        logger.log(Level.INFO, "User {0} returned: {1}", new Object[]{userID, book.getTitle()});
    }

    // Retrieves the list of books currently borrowed by the user.
    // @return a list of borrowed books
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
