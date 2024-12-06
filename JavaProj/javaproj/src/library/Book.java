package library; // Declare the package.

public class Book {
    private String title; // Book title.
    private final String author; // Book author.
    private boolean isAvailable; // Availability status.

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // Default to available.
    }

    public Book(String author) {
        this.author = author; // Constructor with only author.
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available; // Update availability status.
    }

    @Override
    public String toString() {
        return "Book [Title=" + title + ", Author=" + author + ", Available=" + isAvailable + "]";
    }
}
