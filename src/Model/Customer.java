package Model;

import java.util.ArrayList;

public class Customer extends Person {
	private String customerID;
	ArrayList<LoanItem> loanItems = new ArrayList<>();
	
	public Customer(String name, String phoneNumber, String emailAddress, String gender, String customerID) {
		super(name, phoneNumber, emailAddress, gender);
		this.customerID = customerID;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public ArrayList<LoanItem> getLoanItems() {
		return loanItems;
	}

	public void setLoanItems(ArrayList<LoanItem> loanItems) {
		this.loanItems = loanItems;
	}
	
	public void loanBook() {
		
	}
	
	public void loanMovie() {
		
	}
}
