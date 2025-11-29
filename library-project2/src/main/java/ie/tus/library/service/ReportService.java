package ie.tus.library.service;

import ie.tus.library.repository.*;
import ie.tus.library.model.*;
import java.util.*;
import java.util.stream.Collectors;

public class ReportService {
    private final InMemoryBookRepository bookRepo;
    private final InMemoryCopyRepository copyRepo;
    private final InMemoryLoanRepository loanRepo;
    public ReportService(InMemoryBookRepository b, InMemoryCopyRepository c, InMemoryLoanRepository l) {
        this.bookRepo = b; this.copyRepo = c; this.loanRepo = l;
    }
    public void generateInventoryStatusReport() {
        var map = copyRepo.findAll().stream().collect(Collectors.groupingBy(Copy::getStatus, Collectors.counting()));
        System.out.println("Inventory status report:");
        for (var e : map.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
}
