package ie.tus.library.repository;

import ie.tus.library.model.Fine;
import java.util.*;

public class InMemoryFineRepository implements Repository<Fine> {
    private final Map<String, Fine> map = new HashMap<>();
    @Override public Fine save(Fine f) { map.put(f.getFineId(), f); return f; }
    @Override public Optional<Fine> findById(String id) { return Optional.ofNullable(map.get(id)); }
    public List<Fine> findAll() { return List.copyOf(map.values()); }
}
