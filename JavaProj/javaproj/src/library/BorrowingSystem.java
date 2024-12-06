package library;
import java.util.LinkedList;
import java.util.Queue;

public class BorrowingSystem {
    private final Queue<Book> borrowingQueue = new LinkedList<>();

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book borrowed: " + book.getTitle());
        } else {
            borrowingQueue.add(book);
            System.out.println("Book not available. Added to queue: " + book.getTitle());
        }
    }

    public void returnBook(Book book) {
        book.setAvailable(true);
        System.out.println("Book returned: " + book.getTitle());
        if (!borrowingQueue.isEmpty()) {
            Book nextBook = borrowingQueue.poll();
            borrowBook(nextBook);
        }
    }
}
