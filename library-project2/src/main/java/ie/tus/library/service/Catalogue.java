package ie.tus.library.service;

import ie.tus.library.model.BookMetadata;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Catalogue {
    void addBook(BookMetadata metadata, int copies);
    Optional<BookMetadata> findByISBN(String isbn);
    List<BookMetadata> search(Predicate<BookMetadata> filter);
}
