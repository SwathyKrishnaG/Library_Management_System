package ie.tus.library.service;

import ie.tus.library.model.Loan;
import java.math.BigDecimal;
import ie.tus.library.exception.*;
import java.util.List;

public interface LibraryService {
    Loan borrowBook(String memberId, String isbn) throws BookNotFoundException, NoAvailableCopyException;
    BigDecimal returnBook(String loanId) throws IllegalOperationException;
    List<Loan> listMemberLoans(String memberId);
}
