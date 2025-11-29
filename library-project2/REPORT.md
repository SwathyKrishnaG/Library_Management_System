# Report — Library Management System (OOP1) — Java 21

## Abstract
This project implements a Library Management System (LMS) in Java 21 demonstrating core object-oriented principles and advanced language features required by the OOP1 assignment.

## Objectives
- Implement catalogue management, member registration, borrowing and returning with fines, search, and reporting.
- Demonstrate language features: records, sealed interfaces, lambdas, method references, var, defensive copying, enums, exceptions, and more.

## Architecture
(See UML in project README or the PlantUML snippet in the submission files.)

## User stories implemented
US1 — Add Book to Catalogue
US2 — Register Member
US3 — Borrow a Copy
US4 — Return a Copy and Pay Fine
US5 — Search Catalogue
US6 — List Member Loans
US7 — Add/Remove Copy
US8 — Enum-based Book Status & Reports
US9 — Fault-tolerant Input and Exceptions

## Evaluation
The implementation adheres to the project brief by providing a domain model with immutable metadata (`record`), mutable physical copies, repositories, and services. Both checked and unchecked exceptions were used to enforce correct client usage; defensive copying used for collection access; `Repository` interface demonstrates private/default/static methods; `LoanResult` is a sealed hierarchy.

Limitations: persistence is in-memory; concurrency control is minimal; UI is console-based for demonstration.

## Build & Run
See README.md for commands.
