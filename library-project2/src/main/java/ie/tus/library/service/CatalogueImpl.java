package ie.tus.library.service;

import ie.tus.library.model.BookMetadata;
import ie.tus.library.model.Copy;
import ie.tus.library.repository.InMemoryBookRepository;
import ie.tus.library.repository.InMemoryCopyRepository;
import java.util.*;
import java.util.function.Predicate;

public class CatalogueImpl implements Catalogue {
    private final InMemoryBookRepository bookRepo;
    private final InMemoryCopyRepository copyRepo;
    public CatalogueImpl(InMemoryBookRepository br, InMemoryCopyRepository cr) {
        this.bookRepo = br; this.copyRepo = cr;
    }
    @Override
    public void addBook(BookMetadata metadata, int copies) {
        bookRepo.save(metadata);
        for (int i=0;i<copies;i++) {
            var copy = new Copy(UUID.randomUUID().toString(), metadata.isbn());
            copyRepo.save(copy);
        }
    }
    @Override
    public Optional<BookMetadata> findByISBN(String isbn) { return bookRepo.findById(isbn); }
    @Override
    public List<BookMetadata> search(Predicate<BookMetadata> filter) {
        var all = bookRepo.findAll();
        var out = new ArrayList<BookMetadata>();
        for (var b : all) if (filter.test(b)) out.add(b);
        return List.copyOf(out);
    }
}
