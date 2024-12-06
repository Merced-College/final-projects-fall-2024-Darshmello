package library;
import java.util.*;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final Map<String, Book> bookMap = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
        bookMap.put(book.getTitle().toLowerCase(), book);
    }

    public void removeBook(String title) {
        Book book = bookMap.remove(title.toLowerCase());
        if (book != null) {
            books.remove(book);
            System.out.println("Book removed: " + title);
        } else {
            System.out.println("Book not found.");
        }
    }

    public Book searchBook(String title) {
        return bookMap.get(title.toLowerCase());
    }

    public void listBooks() {
        books.forEach(System.out::println);
    }

    public void sortBooks() {
        books.sort(Comparator.comparing(Book::getTitle));
        System.out.println("Books sorted by title.");
    }
}
