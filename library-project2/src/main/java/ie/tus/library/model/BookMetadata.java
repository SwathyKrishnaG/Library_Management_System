package ie.tus.library.model;

import java.util.List;
import java.util.Objects;

public record BookMetadata(String isbn, String title, List<String> authors, int pubYear) {
    public BookMetadata {
        Objects.requireNonNull(isbn, "ISBN required");
        Objects.requireNonNull(title, "Title required");
        Objects.requireNonNull(authors, "Authors required");
        if (isbn.isBlank()) throw new IllegalArgumentException("ISBN blank");
        // defensive copy for authors list
        authors = List.copyOf(authors);
    }
    @Override
    public String toString() {
        return title + " (" + isbn + ")";
    }
}
