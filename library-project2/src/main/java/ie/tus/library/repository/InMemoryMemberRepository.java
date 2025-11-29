package ie.tus.library.repository;

import ie.tus.library.model.Member;
import java.util.*;

public class InMemoryMemberRepository implements Repository<Member> {
    private final Map<String, Member> map = new HashMap<>();
    @Override public Member save(Member m) { map.put(m.getId(), m); return m; }
    @Override public Optional<Member> findById(String id) { return Optional.ofNullable(map.get(id)); }
    public List<Member> findAll() { return List.copyOf(map.values()); }
}
