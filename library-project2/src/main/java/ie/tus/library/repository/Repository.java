package ie.tus.library.repository;

import java.util.Optional;

public interface Repository<T> {
    T save(T t);
    Optional<T> findById(String id);
    default void log(String msg) { System.out.println("[repo] " + msg); }
    static void sanity() { System.out.println("Repository sanity check"); }
    private void helper() { /* private helper in interface (not callable externally) */ }
}
