# Library Management System

A Java console application that manages a small library: members, books, borrowing and returning. Built to practice Object-Oriented Programming.

## Features
- Add a member (Student, Teacher or Guest)
- Add a book (Physical Book, EBook or Reference Book)
- Borrow a book
- Return a book
- Show member information (requires the member's password)
- Show available books

## OOP concepts used
- **Abstraction:** `Book` and `LibraryMember` are abstract classes.
- **Inheritance:** `PhysicalBook`, `EBook` and `ReferenceBook` extend `Book`; `StudentMember`, `TeacherMember` and `GuestMember` extend `LibraryMember`.
- **Polymorphism:** subclasses override `getBookType()`, `calculateBorrowDuration()` and `getMemberType()`.
- **Encapsulation:** fields are private and accessed through getters and methods.

## Rules
| Member type | Max borrowed books |
|---|---|
| Student | 3 |
| Teacher | 5 |
| Guest | 1 |

| Book type | Borrow period |
|---|---|
| Physical Book | 14 days |
| EBook | 7 days |
| Reference Book | Cannot be borrowed (0) |

## Project structure
`Main` (menu and user input), `Library` (books, members, borrow and return logic), `Book` and its 3 subclasses, `LibraryMember` and its 3 subclasses.

## How to run
```bash
cd oop_project
javac *.java
java Main
```

## Author
Sara Ibrahim, Assiut University
