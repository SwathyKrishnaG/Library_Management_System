package ie.tus.library.repository;

import ie.tus.library.model.Loan;
import java.util.*;
import java.util.stream.Collectors;

public class InMemoryLoanRepository implements Repository<Loan> {
    private final Map<String, Loan> map = new HashMap<>();
    @Override public Loan save(Loan l) { map.put(l.getLoanId(), l); return l; }
    @Override public Optional<Loan> findById(String id) { return Optional.ofNullable(map.get(id)); }
    public List<Loan> findByMember(String memberId) {
        return map.values().stream().filter(l -> l.getMemberId().equals(memberId)).collect(Collectors.toList());
    }
    public List<Loan> findAll() { return List.copyOf(map.values()); }
}
