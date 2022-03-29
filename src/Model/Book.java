package Model;

import java.util.ArrayList;
import java.util.Date;

public class Book extends LoanItem {
	private String isbn;
	private String publisher;
	private static ArrayList<Customer> renter = new ArrayList<>();
	
	public Book(String itemID, String title, String author, String genre, Date releaseDate, String isbn,
			String publisher) {
		super(itemID, title, author, genre, releaseDate);
		this.isbn = isbn;
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public static ArrayList<Customer> getRenter() {
		return renter;
	}

	public static void setRenter(ArrayList<Customer> renter) {
		Book.renter = renter;
	}
	
	
}
