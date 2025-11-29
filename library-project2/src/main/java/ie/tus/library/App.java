package ie.tus.library;

import ie.tus.library.model.*;
import ie.tus.library.repository.*;
import ie.tus.library.service.*;
import ie.tus.library.exception.*;
import java.math.BigDecimal;
import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Library Management System — Demo (Java 21)");
        var bookRepo = new InMemoryBookRepository();
        var copyRepo = new InMemoryCopyRepository();
        var memberRepo = new InMemoryMemberRepository();
        var loanRepo = new InMemoryLoanRepository();
        var fineRepo = new InMemoryFineRepository();

        var catalogue = new CatalogueImpl(bookRepo, copyRepo);
        var library = new LibraryServiceImpl(bookRepo, copyRepo, memberRepo, loanRepo, fineRepo);
        var report = new ReportService(bookRepo, copyRepo, loanRepo);

        // US1 - Add Book
        var meta = new BookMetadata("9780134685991", "Effective Java", List.of("Joshua Bloch"), 2018);
        catalogue.addBook(meta, 2);
        System.out.println("Added book: " + meta.title());

        // US2 - Register Member
        var member = new Member("m-001", "Alice Example", "alice@example.com");
        memberRepo.save(member);
        System.out.println("Registered member: " + member.getDisplayName());

        // US3 - Borrow a copy
        try {
            var loan = library.borrowBook(member.getId(), meta.isbn());
            System.out.println("Loan created: " + loan);
        } catch (Exception e) {
            System.err.println("Borrow failed: " + e.getMessage());
        }

        // US4 - Return (simulate overdue by manipulating loan due date in repo)
        var loans = loanRepo.findByMember(member.getId());
        if (!loans.isEmpty()) {
            var l = loans.get(0);
            // simulate overdue by setting due date earlier
            l.setDue(l.getDue().minusWeeks(5));
            try {
                BigDecimal fine = library.returnBook(l.getLoanId());
                System.out.println("Return processed. Fine: €" + fine);
            } catch (Exception e) {
                System.err.println("Return failed: " + e.getMessage());
            }
        }

        // US5 - Search catalogue using lambda
        var hits = catalogue.search(b -> b.title().toLowerCase().contains("effective"));
        System.out.println("Search hits: " + hits);

        // US8 - Report
        report.generateInventoryStatusReport();

        System.out.println("Demo complete.");
    }
}
