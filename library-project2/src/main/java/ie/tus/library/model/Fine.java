package ie.tus.library.model;

import java.math.BigDecimal;

public class Fine {
    private final String fineId;
    private final String loanId;
    private final BigDecimal amount;
    public Fine(String fineId, String loanId, BigDecimal amount) {
        this.fineId = fineId; this.loanId = loanId; this.amount = amount;
    }
    public String getFineId() { return fineId; }
    public String getLoanId() { return loanId; }
    public BigDecimal getAmount() { return amount; }
    @Override public String toString() { return "Fine["+fineId+", loan="+loanId+", amt="+amount+"]"; }
}
