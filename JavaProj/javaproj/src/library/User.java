package library;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a library user who can borrow books and manage penalties.
 */
public class User {
    private static final Logger logger = Logger.getLogger(User.class.getName());
    private final String userID; // Unique identifier for the user
    private final List<Book> borrowedBooks = new ArrayList<>(); // List of books the user has borrowed
    private double penalties; // The user's total penalty amount

    /**
     * Creates a new user with a given user ID and initializes penalties to zero.
     *
     * @param userID the unique identifier for the user
     */
    public User(String userID) {
        this.userID = userID;
        this.penalties = 0.0;
    }

    /**
     * Adds a book to the list of books borrowed by the user and logs the action.
     *
     * @param book the book being borrowed
     */
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        logger.log(Level.INFO, "User {0} borrowed: {1}", new Object[]{userID, book.getTitle()});
    }

    /**
     * Removes a book from the user's borrowed list and logs the action.
     *
     * @param book the book being returned
     */
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        logger.log(Level.INFO, "User {0} returned: {1}", new Object[]{userID, book.getTitle()});
    }

    /**
     * Allows the user to pay off penalties and adjusts the total penalty amount.
     * Logs the payment if successful or warns if the payment exceeds the owed amount.
     *
     * @param amount the amount being paid toward penalties
     */
    public void payPenalty(double amount) {
        if (amount <= penalties) {
            penalties -= amount;
            logger.log(Level.INFO, "Penalty paid: ${0}", amount);
        } else {
            logger.warning("Amount exceeds penalties owed.");
        }
    }

    /**
     * Retrieves the list of books currently borrowed by the user.
     *
     * @return a list of borrowed books
     */
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}
