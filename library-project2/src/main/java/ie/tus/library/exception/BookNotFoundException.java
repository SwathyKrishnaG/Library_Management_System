package ie.tus.library.exception;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(String isbn) { super("Book not found: " + isbn); }
}
