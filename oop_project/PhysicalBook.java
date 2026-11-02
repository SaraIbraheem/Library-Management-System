
public class PhysicalBook extends Book {

    public PhysicalBook(String bookID, String title,
                        String author, String category) {

        super(bookID, title, author, category);
    }

    @Override
    public String getBookType() {
        return "Physical Book";
    }

    @Override
    public int calculateBorrowDuration() {
        return 14;
    }
}


