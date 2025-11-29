package ie.tus.library.model;

import java.util.ArrayList;
import java.util.List;

public class Member extends Person {
    private final String email;
    private final List<String> loans = new ArrayList<>();

    public Member(String id, String name, String email) {
        super(id, name);
        this.email = email;
    }
    public String getEmail() { return email; }
    public List<String> getLoans() { return List.copyOf(loans); }
    public void addLoan(String loanId) { loans.add(loanId); }

    @Override
    public String getDisplayName() { return super.getDisplayName() + " <" + email + ">"; }

    @Override
    public String toString() {
        return "Member[" + id + ", " + name + ", " + email + "]";
    }
}
