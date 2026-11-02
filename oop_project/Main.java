

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Library library = new Library();

        int choice = -1;

        do {

            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Member");
            System.out.println("2. Add Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Show Member Information");
            System.out.println("6. Show Available Books");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.println("\n--- Add Member ---");

                    System.out.print("Enter Member ID: ");
                    String memberID = input.nextLine();

                    System.out.print("Enter Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Password: ");
                    String password = input.nextLine();

                    System.out.println("1. Student");
                    System.out.println("2. Teacher");
                    System.out.println("3. Guest");

                    System.out.print("Choose Member Type: ");

                    int memberType;

                    try {
                        memberType = Integer.parseInt(input.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid choice!");
                        break;
                    }

                    LibraryMember member = null;

                    if (memberType == 1) {
                        member = new StudentMember(
                            memberID, name, password
                        );

                    } else if (memberType == 2) {
                        member = new TeacherMember(
                            memberID, name, password
                        );

                    } else if (memberType == 3) {
                        member = new GuestMember(
                            memberID, name, password
                        );

                    } else {
                        System.out.println("Invalid member type!");
                        break;
                    }

                    library.addMember(member);

                    break;


                case 2:

                    System.out.println("\n--- Add Book ---");

                    System.out.print("Enter Book ID: ");
                    String bookID = input.nextLine();

                    System.out.print("Enter Title: ");
                    String title = input.nextLine();

                    System.out.print("Enter Author: ");
                    String author = input.nextLine();

                    System.out.print("Enter Category: ");
                    String category = input.nextLine();

                    System.out.println("1. Physical Book");
                    System.out.println("2. EBook");
                    System.out.println("3. Reference Book");

                    System.out.print("Choose Book Type: ");

                    int bookType;

                    try {
                        bookType = Integer.parseInt(input.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid choice!");
                        break;
                    }

                    Book book = null;

                    if (bookType == 1) {
                        book = new PhysicalBook(
                            bookID, title, author, category
                        );

                    } else if (bookType == 2) {
                        book = new EBook(
                            bookID, title, author, category
                        );

                    } else if (bookType == 3) {
                        book = new ReferenceBook(
                            bookID, title, author, category
                        );

                    } else {
                        System.out.println("Invalid book type!");
                        break;
                    }

                    library.addBook(book);

                    break;


                case 3:

                    System.out.println("\n--- Borrow Book ---");

                    System.out.print("Enter Member ID: ");
                    String borrowMemberID = input.nextLine();

                    System.out.print("Enter Password: ");
                    String borrowPassword = input.nextLine();

                    System.out.print("Enter Book ID: ");
                    String borrowBookID = input.nextLine();

                    library.borrowBook(
                        borrowMemberID,
                        borrowPassword,
                        borrowBookID
                    );

                    break;


                case 4:

                    System.out.println("\n--- Return Book ---");

                    System.out.print("Enter Member ID: ");
                    String returnMemberID = input.nextLine();

                    System.out.print("Enter Password: ");
                    String returnPassword = input.nextLine();

                    System.out.print("Enter Book ID: ");
                    String returnBookID = input.nextLine();

                    library.returnBook(
                        returnMemberID,
                        returnPassword,
                        returnBookID
                    );

                    break;


                case 5:

                    System.out.println("\n--- Member Information ---");

                    System.out.print("Enter Member ID: ");
                    String infoMemberID = input.nextLine();

                    System.out.print("Enter Password: ");
                    String infoPassword = input.nextLine();

                    library.showMemberInfo(
                        infoMemberID,
                        infoPassword
                    );

                    break;


                case 6:

                    library.showAvailableBooks();

                    break;


                case 0:

                    System.out.println("Thank you for using our library!");

                    break;


                default:

                    System.out.println("Invalid choice! Try again.");

            }

        } while (choice != 0);

        input.close();
    }
}
