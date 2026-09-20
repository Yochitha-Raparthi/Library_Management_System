import java.time.LocalDate;
public class Transaction {
	private int transactionId;
    private int bookId;
    private int memberId;
    private LocalDate issueDate;
    private LocalDate returnDate;
    public Transaction(int transactionId, int bookId, int memberId) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = LocalDate.now();
        this.returnDate = null;
    }
    public int getTransactionId() {
        return transactionId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
               ", Book ID: " + bookId +
               ", Member ID: " + memberId +
               ", Issue Date: " + issueDate +
               ", Return Date: " + returnDate;
    }
}
