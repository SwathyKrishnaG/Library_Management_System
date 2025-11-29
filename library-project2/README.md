# Library Management System — OOP1 (Java 21)

## Overview
This Maven project demonstrates a Library Management System built in Java 21 that implements required OOP and Java language features for the OOP1 assignment.

## Build & Run
Requirements: JDK 21 and Maven.

To compile:
```
mvn clean compile
```

To run the demo main (executes user-story flows):
```
mvn exec:java -Dexec.mainClass=ie.tus.library.App
```

Project structure highlights:
- `ie.tus.library.model` — domain classes and records (BookMetadata, Copy, Loan, Member)
- `ie.tus.library.repository` — in-memory repositories
- `ie.tus.library.service` — service layer (Catalogue and LibraryService implementations)
- `ie.tus.library.exception` — custom checked and unchecked exceptions
- `App` — main harness that demonstrates user stories for the screencast

See `REPORT.md` for the formal report and mapping of Java features.
