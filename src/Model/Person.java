package Model;

public class Person {
	private String name;
	private String phoneNumber;
	private String emailAddress;
	private String gender;
	
	public Person(String name, String phoneNumber, String emailAddress, String gender) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
