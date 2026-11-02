
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<LibraryMember> members;

    // Constructor
    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Add Member
    public boolean addMember(LibraryMember member) {

        for (LibraryMember m : members) {
            if (m.getMemberID().equals(member.getMemberID())) {
                System.out.println("Member ID already exists!");
                return false;
            }
        }

        members.add(member);
        System.out.println("Member added successfully!");
        return true;
    }

    // Add Book
    public boolean addBook(Book book) {

        for (Book b : books) {
            if (b.getBookID().equals(book.getBookID())) {
                System.out.println("Book ID already exists!");
                return false;
            }
        }

        books.add(book);
        System.out.println("Book added successfully!");
        return true;
    }

    // Find Member
    private LibraryMember findMember(String memberID) {

        for (LibraryMember member : members) {
            if (member.getMemberID().equals(memberID)) {
                return member;
            }
        }

        return null;
    }

    // Find Book
    private Book findBook(String bookID) {

        for (Book book : books) {
            if (book.getBookID().equals(bookID)) {
                return book;
            }
        }

        return null;
    }

    // Borrow Book
    public boolean borrowBook(String memberID,
                              String password,
                              String bookID) {

        LibraryMember member = findMember(memberID);

        if (member == null) {
            System.out.println("Member not found!");
            return false;
        }

        if (!member.authenticate(password)) {
            System.out.println("Wrong password!");
            return false;
        }

        Book book = findBook(bookID);

        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }

        if (book instanceof ReferenceBook) {
            System.out.println("Reference books cannot be borrowed!");
            return false;
        }

        if (!book.isAvailable()) {
            System.out.println("Book is not available!");
            return false;
        }

        if (!member.canBorrow()) {
            System.out.println("Borrowing limit reached!");
            return false;
        }

        member.addBorrowedBook(book);
        book.setAvailable(false);

        System.out.println("Book borrowed successfully!");
        System.out.println("Borrow duration: "
                + book.calculateBorrowDuration() + " days");

        return true;
    }

    // Return Book
    public boolean returnBook(String memberID,
                              String password,
                              String bookID) {

        LibraryMember member = findMember(memberID);

        if (member == null) {
            System.out.println("Member not found!");
            return false;
        }

        if (!member.authenticate(password)) {
            System.out.println("Wrong password!");
            return false;
        }

        Book book = findBook(bookID);

        if (book == null) {
            System.out.println("Book not found!");
            return false;
        }

        if (!member.hasBorrowedBook(bookID)) {
            System.out.println("This member did not borrow this book!");
            return false;
        }

        member.removeBorrowedBook(book);
        book.setAvailable(true);

        System.out.println("Book returned successfully!");

        return true;
    }

    // Show Member Information
    public void showMemberInfo(String memberID, String password) {

        LibraryMember member = findMember(memberID);

        if (member == null) {
            System.out.println("Member not found!");
            return;
        }

        if (!member.authenticate(password)) {
            System.out.println("Wrong password!");
            return;
        }

        System.out.println("\n===== MEMBER INFORMATION =====");
        System.out.println("Member ID: " + member.getMemberID());
        System.out.println("Name: " + member.getName());
        System.out.println("Member Type: " + member.getMemberType());

        System.out.println("Maximum Borrow Limit: "
                + member.getMaxBorrowLimit());

        System.out.println("Borrowed Books: "
                + member.getBorrowedBookCount());

        member.showBorrowedBooks();
    }

    // Show Available Books
    public void showAvailableBooks() {

        System.out.println("\n===== AVAILABLE BOOKS =====");

        boolean found = false;

        for (Book book : books) {

            if (book.isAvailable()) {

                System.out.println("Book ID: " + book.getBookID());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Category: " + book.getCategory());
                System.out.println("Type: " + book.getBookType());

                System.out.println("----------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No available books.");
        }
    }
}


