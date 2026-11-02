
public abstract class Book {

    private String bookID;
    private String title;
    private String author;
    private String category;
    private boolean isAvailable;

    public Book(String bookID, String title,
                String author, String category) {

        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = true;
    }

    public abstract String getBookType();

    public abstract int calculateBorrowDuration();

    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

