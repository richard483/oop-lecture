package Model;

import java.util.Date;

public class LoanItem {
	private String itemID; //for book, item ID starts with "B-", and movie starts with "M-"
	private String title;
	private String author;
	private String genre;
	private Date releaseDate;
	
	public LoanItem(String itemID, String title, String author, String genre, Date releaseDate) {
		super();
		this.itemID = itemID;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.releaseDate = releaseDate;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
}
