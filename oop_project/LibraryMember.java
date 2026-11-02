

import java.util.ArrayList;

public abstract class LibraryMember {

    private String memberID;
    private String name;
    private String password;

    private ArrayList<Book> borrowedBooks;

    private int maxBorrowLimit;

    public LibraryMember(String memberID, String name,
                          String password, int maxBorrowLimit) {

        this.memberID = memberID;
        this.name = name;
        this.password = password;
        this.maxBorrowLimit = maxBorrowLimit;

        borrowedBooks = new ArrayList<>();
    }

    public abstract String getMemberType();

    public String getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public int getMaxBorrowLimit() {
        return maxBorrowLimit;
    }

    public int getBorrowedBookCount() {
        return borrowedBooks.size();
    }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public boolean canBorrow() {
        return borrowedBooks.size() < maxBorrowLimit;
    }

    public boolean hasBorrowedBook(String bookID) {

        for (Book book : borrowedBooks) {

            if (book.getBookID().equals(bookID)) {
                return true;
            }
        }

        return false;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void showBorrowedBooks() {

        if (borrowedBooks.isEmpty()) {
            System.out.println("No borrowed books.");
            return;
        }

        for (Book book : borrowedBooks) {

            System.out.println(
                book.getTitle() + " - " + book.getBookID()
            );
        }
    }
}

