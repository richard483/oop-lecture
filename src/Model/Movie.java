package Model;

import java.util.ArrayList;
import java.util.Date;

public class Movie extends LoanItem {
	private String studio;
	ArrayList<Customer> renter = new ArrayList<>();

	public Movie(String itemID, String title, String author, String genre, Date releaseDate, String studio) {
		super(itemID, title, author, genre, releaseDate);
		this.studio = studio;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}

	public ArrayList<Customer> getRenter() {
		return renter;
	}

	public void setRenter(ArrayList<Customer> renter) {
		this.renter = renter;
	}
	
}
