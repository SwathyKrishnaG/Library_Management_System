package ie.tus.library.repository;

import ie.tus.library.model.BookMetadata;
import java.util.*;

public class InMemoryBookRepository implements Repository<BookMetadata> {
    private final Map<String, BookMetadata> map = new HashMap<>();
    @Override
    public BookMetadata save(BookMetadata b) {
        map.put(b.isbn(), b);
        return b;
    }
    @Override
    public Optional<BookMetadata> findById(String id) {
        return Optional.ofNullable(map.get(id));
    }
    public List<BookMetadata> findAll() { return List.copyOf(map.values()); }
}
