
    
public class EBook extends Book {

    public EBook(String bookID, String title,
                 String author, String category) {

        super(bookID, title, author, category);
    }

    @Override
    public String getBookType() {
        return "EBook";
    }

    @Override
    public int calculateBorrowDuration() {
        return 7;
    }
}


