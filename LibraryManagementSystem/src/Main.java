import java.util.Scanner;
import com.exception.BookNotFoundException;
import com.exception.BookNotAvailableException;
import com.exception.MemberNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
public class Main{
     public static void main(String[] args) {
    	 Scanner sc=new Scanner(System.in);
    	 ArrayList<Book>books=new ArrayList<>();
    	 ArrayList<Member>members=new ArrayList<>();
    	 ArrayList<Transaction> transactions = new ArrayList<>();
    	 while (true) {

    		    System.out.println("1. Add Book");
    		    System.out.println("2. View Books");
    		    System.out.println("3. Search Book");
    		    System.out.println("4. Register Member");
    		    System.out.println("5. Issue Book");
    		    System.out.println("6. Return Book");
    		    System.out.println("7. View Issued Books");
    		    System.out.println("8. Exit");

    		    System.out.print("Enter your choice: ");
    		    int choice = sc.nextInt();

    		    if (choice == 1) {

    		        System.out.print("Enter Book ID: ");
    		        int bookId = sc.nextInt();
    		        sc.nextLine();

    		        System.out.print("Enter Book Title: ");
    		        String title = sc.nextLine();

    		        System.out.print("Enter Author: ");
    		        String author = sc.nextLine();

    		        System.out.print("Enter Category: ");
    		        String category = sc.nextLine();

    		        Book book = new Book(bookId, title, author, category);

    		        books.add(book);

    		        System.out.println("Book added successfully!");
    		    }
    		    else if (choice == 2) {

    		        if (books.isEmpty()) {
    		            System.out.println("No books available.");
    		        } else {

    		            System.out.println("----- All Books -----");

    		            for (Book book : books) {
    		                System.out.println(book);
    		            }
    		        }
    		    }
    		    else if(choice==3) {
    		    	System.out.println("Enter BookId for Search: ");
    		    	int searchId=sc.nextInt();
    		    	boolean found=false;
    		    	for(Book book:books) {
    		    		if(book.getBookId()==searchId) {
    		    			System.out.println("Book Found!");
    		                System.out.println(book);
    		                found = true;
    		                break;
    		    		}
    		    		
    		    	}
    		    	if (!found) {
		    	        System.out.println("Book not found.");
		    	    }
    		    	
    		    }
    		    else if (choice == 4) {

    		        System.out.print("Enter Member ID: ");
    		        int memberId = sc.nextInt();
    		        sc.nextLine();

    		        System.out.print("Enter Member Name: ");
    		        String name = sc.nextLine();

    		        System.out.print("Enter Email: ");
    		        String email = sc.nextLine();

    		        System.out.print("Enter Phone: ");
    		        String phone = sc.nextLine();

    		        Member member = new Member(memberId, name, email, phone);

    		        members.add(member);

    		        System.out.println("Member registered successfully!");
    		    }
    		    else if (choice == 5) {

    		        System.out.print("Enter Member ID: ");
    		        int memberId = sc.nextInt();

    		        boolean memberFound = false;

    		        for (Member member : members) {

    		            if (member.getMemberId() == memberId) {
    		                memberFound = true;
    		                break;
    		            }
    		        }

    		        if (!memberFound) {
    		            System.out.println("Member not found.");
    		            continue;
    		        }

    		        System.out.print("Enter Book ID: ");
    		        int bookId = sc.nextInt();

    		        boolean bookFound = false;

    		        for (Book book : books) {

    		            if (book.getBookId() == bookId) {

    		                bookFound = true;

    		                if (book.isAvailable()) {

    		                    book.setAvailable(false);

    		                    int transactionId = transactions.size() + 1;

    		                    Transaction transaction =
    		                            new Transaction(transactionId, bookId, memberId);

    		                    transactions.add(transaction);

    		                    System.out.println("Book issued successfully!");
    		                    System.out.println("Transaction ID: " + transactionId);

    		                } else {
    		                    System.out.println("Book is already issued.");
    		                }

    		                break;
    		            }
    		        }

    		        if (!bookFound) {
    		            System.out.println("Book not found.");
    		        }
    		    }
    		    else if (choice == 6) {

    		        System.out.print("Enter Book ID to return: ");
    		        int bookId = sc.nextInt();

    		        boolean bookFound = false;
    		        boolean transactionFound = false;

    		        // Find the book
    		        for (Book book : books) {

    		            if (book.getBookId() == bookId) {

    		                bookFound = true;

    		                if (!book.isAvailable()) {

    		                    // Find active transaction
    		                    for (Transaction transaction : transactions) {

    		                        if (transaction.getBookId() == bookId &&
    		                            transaction.getReturnDate() == null) {

    		                            transaction.setReturnDate(LocalDate.now());

    		                            book.setAvailable(true);

    		                            transactionFound = true;

    		                            System.out.println("Book returned successfully!");
    		                            System.out.println("Return Date: " +
    		                                               transaction.getReturnDate());

    		                            break;
    		                        }
    		                    }

    		                    if (!transactionFound) {
    		                        System.out.println(
    		                            "Transaction record not found."
    		                        );
    		                    }

    		                } else {

    		                    System.out.println("This book is not currently issued.");
    		                }

    		                break;
    		            }
    		        }

    		        if (!bookFound) {
    		            System.out.println("Book not found.");
    		        }
    		    }
    		    else if (choice == 7) {

    		        boolean found = false;

    		        for (Transaction transaction : transactions) {

    		            if (transaction.getReturnDate() == null) {

    		                System.out.println(transaction);
    		                found = true;
    		            }
    		        }

    		        if (!found) {
    		            System.out.println("No books are currently issued.");
    		        }
    		    }
    		    else if (choice == 8) {

    		        System.out.println("Thank you for using Library Management System!");
    		        break;
    		    }
    		}        
     }
 }
