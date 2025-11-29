package ie.tus.library.service;

import ie.tus.library.model.*;
import ie.tus.library.repository.*;
import ie.tus.library.exception.*;
import java.time.LocalDate;
import java.util.*;
import java.math.BigDecimal;
import static java.time.temporal.ChronoUnit.DAYS;

public class LibraryServiceImpl implements LibraryService {
    private final InMemoryBookRepository bookRepo;
    private final InMemoryCopyRepository copyRepo;
    private final InMemoryMemberRepository memberRepo;
    private final InMemoryLoanRepository loanRepo;
    private final InMemoryFineRepository fineRepo;

    public LibraryServiceImpl(InMemoryBookRepository b, InMemoryCopyRepository c, InMemoryMemberRepository m, InMemoryLoanRepository l, InMemoryFineRepository f) {
        this.bookRepo = b; this.copyRepo = c; this.memberRepo = m; this.loanRepo = l; this.fineRepo = f;
    }

    @Override
    public Loan borrowBook(String memberId, String isbn) throws BookNotFoundException, NoAvailableCopyException {
        var book = bookRepo.findById(isbn).orElseThrow(() -> new BookNotFoundException(isbn));
        var copy = copyRepo.findByBookIsbn(isbn).stream().filter(Copy::isAvailable).findFirst()
            .orElseThrow(() -> new NoAvailableCopyException(isbn));
        var loan = new Loan(UUID.randomUUID().toString(), copy.getCopyId(), memberId, LocalDate.now(), LocalDate.now().plusWeeks(3), null);
        copy.setStatus(CopyStatus.ON_LOAN);
        loanRepo.save(loan);
        copyRepo.save(copy);
        // add loan id to member
        memberRepo.findById(memberId).ifPresent(m -> m.addLoan(loan.getLoanId()));
        return loan;
    }

    @Override
    public BigDecimal returnBook(String loanId) throws IllegalOperationException {
        var loan = loanRepo.findById(loanId).orElseThrow(() -> new IllegalOperationException("Loan not found"));
        if (loan.getReturned() != null) throw new IllegalOperationException("Already returned");
        loan.setReturned(LocalDate.now());
        long daysOverdue = DAYS.between(loan.getDue(), loan.getReturned());
        BigDecimal fine = BigDecimal.ZERO;
        if (daysOverdue > 0) {
            fine = BigDecimal.valueOf(daysOverdue).multiply(new BigDecimal("0.50"));
            var f = new Fine(UUID.randomUUID().toString(), loanId, fine);
            fineRepo.save(f);
        }
        loanRepo.save(loan);
        var copy = copyRepo.findById(loan.getCopyId()).orElseThrow();
        copy.setStatus(CopyStatus.AVAILABLE);
        copyRepo.save(copy);
        return fine;
    }

    @Override
    public List<Loan> listMemberLoans(String memberId) {
        return loanRepo.findByMember(memberId);
    }
}
