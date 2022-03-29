package Model;

public class Staff extends Person {
	private String staffID;
	private Integer salary;
	
	public Staff(String name, String phoneNumber, String emailAddress, String gender, String staffID, Integer salary) {
		super(name, phoneNumber, emailAddress, gender);
		this.staffID = staffID;
		this.salary = salary;
	}
	
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
}
