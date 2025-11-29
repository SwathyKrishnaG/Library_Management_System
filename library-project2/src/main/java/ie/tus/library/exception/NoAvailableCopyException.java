package ie.tus.library.exception;

public class NoAvailableCopyException extends Exception {
    public NoAvailableCopyException(String isbn) { super("No available copy for: " + isbn); }
}
