package ie.tus.library.repository;

import ie.tus.library.model.Copy;
import java.util.*;
import java.util.stream.Collectors;

public class InMemoryCopyRepository implements Repository<Copy> {
    private final Map<String, Copy> map = new HashMap<>();
    @Override public Copy save(Copy c) { map.put(c.getCopyId(), c); return c; }
    @Override public Optional<Copy> findById(String id) { return Optional.ofNullable(map.get(id)); }
    public List<Copy> findByBookIsbn(String isbn) {
        return map.values().stream().filter(c -> c.getIsbn().equals(isbn)).collect(Collectors.toList());
    }
    public List<Copy> findAll() { return List.copyOf(map.values()); }
    public void delete(String copyId) { map.remove(copyId); }
}
