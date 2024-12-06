package library; // Declare the package.

import java.util.LinkedList; // Import LinkedList.
import java.util.Queue; // Import Queue.

// Handles borrowing and returning of books, maintaining a queue for unavailable books.
public class BorrowingSystem {
    private final Queue<Book> borrowingQueue = new LinkedList<>(); // Queue for books waiting to be borrowed.

    public void borrowBook(Book book) {
        if (book.isAvailable()) { // Borrow if available.
            book.setAvailable(false);
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            borrowingQueue.add(book); // Add to queue if not available.
            System.out.println("Book not available. Added to queue: " + book.getTitle());
        }
    }

    public void returnBook(Book book) {
        book.setAvailable(true); // Mark book as available.
        System.out.println("Book returned: " + book.getTitle());
        if (!borrowingQueue.isEmpty()) {
            borrowBook(borrowingQueue.poll()); // Borrow next in queue.
        }
    }
}
