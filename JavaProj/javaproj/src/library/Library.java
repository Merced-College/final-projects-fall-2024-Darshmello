package library;

import java.util.*;

public class Library {
    // A list to keep track of all books in the library
    private final List<Book> books = new ArrayList<>();
    // A map to allow quick lookups for books by their title (case-insensitive)
    private final Map<String, Book> bookMap = new HashMap<>();

    // Adds a new book to the library
    // Updates both the books list and the bookMap for easy access
    public void addBook(Book book) {
        books.add(book); // Add the book to the main list
        bookMap.put(book.getTitle().toLowerCase(), book); // Store the book in the map with a lowercase title for case-insensitive searching
    }

    // Removes a book from the library by its title
    // Deletes the book from both the list and the map
    public void removeBook(String title) {
        Book book = bookMap.remove(title.toLowerCase()); // Try to remove the book from the map
        if (book != null) { // If the book exists
            books.remove(book); // Remove it from the list
            System.out.println("Book removed: " + title); // Confirm the removal to the user
        } else {
            System.out.println("Book not found."); // Let the user know if the book doesn't exist
        }
    }

    // Searches for a book in the library by its title
    // Returns the book if found, otherwise returns null
    public Book searchBook(String title) {
        return bookMap.get(title.toLowerCase()); // Look up the book in the map using a case-insensitive key
    }

    // Prints all books currently in the library
    // Uses a simple loop to display each book in the list
    public void listBooks() {
        books.forEach(System.out::println); // Print each book in the list
    }

    // Sorts all books in the library by their title in alphabetical order
    public void sortBooks() {
        books.sort(Comparator.comparing(Book::getTitle)); // Use the Comparator to sort books by their title
        System.out.println("Books sorted by title."); // Confirm to the user that the books have been sorted
    }
}
