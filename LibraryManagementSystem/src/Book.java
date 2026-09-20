public class Book {
	private int bookId;
    private String title;
    private String author;
    private String category;
    private boolean available;
    public Book(int bookId, String title, String author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = true;
    }
    public int getBookId() {
        return bookId;
    }
    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    @Override
    public String toString() {
        return "Book ID: " + bookId +
               ", Title: " + title +
               ", Author: " + author +
               ", Category: " + category +
               ", Available: " + available;
    }
    
    
}
