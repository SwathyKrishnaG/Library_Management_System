package ie.tus.library.model;

import java.time.LocalDate;

public class Loan {
    private final String loanId;
    private final String copyId;
    private final String memberId;
    private LocalDate start;
    private LocalDate due;
    private LocalDate returned;

    public Loan(String loanId, String copyId, String memberId, LocalDate start, LocalDate due, LocalDate returned) {
        this.loanId = loanId;
        this.copyId = copyId;
        this.memberId = memberId;
        this.start = start;
        this.due = due;
        this.returned = returned;
    }

    public String getLoanId() { return loanId; }
    public String getCopyId() { return copyId; }
    public String getMemberId() { return memberId; }
    public LocalDate getStart() { return start; }
    public LocalDate getDue() { return due; }
    public LocalDate getReturned() { return returned; }

    public void setReturned(java.time.LocalDate d) { this.returned = d; }
    public void setDue(java.time.LocalDate d) { this.due = d; }

    @Override
    public String toString() {
        return "Loan[" + loanId + ", copy=" + copyId + ", member=" + memberId + ", due=" + due + ", returned=" + returned + "]";
    }
}
