package Controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Book;
import Model.Customer;
import Model.Movie;
import Model.Staff;

public class DatabaseDAO {
    Connect connect = Connect.getConnection();
    PreparedStatement ps;
    ResultSet rs;
    String query;
    Date sqldate;
    
    public void updateStaffList(ArrayList<Staff> staffList){
        System.out.println("Syncing data to database...");
        query = "DELETE FROM `staff`";
        connect.executeUpdate(query);

        String sql = "INSERT INTO `staff`(`Id`, `Name`, `PhoneNumber`, `Email`, `Gender`, `Salary`) VALUES (?,?,?,?,?,?)";
        
        ps = connect.prepareStatement(sql);
        for (Staff staff : staffList) {
            try {
                ps.setString(1, staff.getStaffID());
                ps.setString(2, staff.getName());
                ps.setString(3, staff.getPhoneNumber());
                ps.setString(4, staff.getEmailAddress());
                ps.setString(5, staff.getGender());
                ps.setInt(6, staff.getSalary());
                ps.executeUpdate();
            } catch (Exception e) {
                System.err.println(e);
            }
        }

        System.out.println("Syncing done!");
        System.out.println();
    }
    
    public void updateCustomerList(ArrayList<Customer> customerList){
        System.out.println("Syncing data to database...");
        query = "DELETE FROM `customer`";
        connect.executeUpdate(query);

        String sql = "INSERT INTO `staff`(`Id`, `Name`, `PhoneNumber`, `Email`, `Gender`) VALUES (?,?,?,?,?)";
        
        ps = connect.prepareStatement(sql);
        for (Customer customer : customerList) {
            try {
                ps.setString(1, customer.getCustomerID());
                ps.setString(2, customer.getName());
                ps.setString(3, customer.getPhoneNumber());
                ps.setString(4, customer.getEmailAddress());
                ps.setString(5, customer.getGender());
                ps.executeUpdate();
            } catch (Exception e) {
                System.err.println(e);
            }
        }

        System.out.println("Syncing done!");
        System.out.println();
    }
    
    public void updateBookList(ArrayList<Book> bookList){
        System.out.println("Syncing data to database...");
        query = "DELETE FROM `book`";
        connect.executeUpdate(query);

        String sql = "INSERT INTO `book`(`Id`, `Title`, `Author`, `Genre`, `ReleaseDate`, `ISBN`, `Publisher`) VALUES (?,?,?,?,?,?,?)";
        
        ps = connect.prepareStatement(sql);
        for (Book book : bookList) {
            try {
                ps.setString(1, book.getItemID());
                ps.setString(2, book.getTitle());
                ps.setString(3, book.getAuthor());
                ps.setString(4, book.getGenre());
                
                sqldate = new Date(book.getReleaseDate().getTime());
                
                ps.setDate(5, sqldate);
                ps.setString(6, book.getIsbn());
                ps.setString(7, book.getPublisher());
                ps.executeUpdate();
            } catch (Exception e) {
                System.err.println(e);
            }
        }

        System.out.println("Syncing done!");
        System.out.println();
    }
    
    public void updateMovieList(ArrayList<Movie> movieList){
        System.out.println("Syncing data to database...");
        query = "DELETE FROM `movie`";
        connect.executeUpdate(query);

        String sql = "INSERT INTO `movie`(`Id`, `Title`, `Author`, `Genre`, `ReleaseDate`, `Studio`) VALUES (?,?,?,?,?,?)";
        
        ps = connect.prepareStatement(sql);
        for (Movie movie : movieList) {
            try {
                ps.setString(1, movie.getItemID());
                ps.setString(2, movie.getTitle());
                ps.setString(3, movie.getAuthor());
                ps.setString(4, movie.getGenre());
                
                sqldate = new Date(movie.getReleaseDate().getTime());
                
                ps.setDate(5, sqldate);
                ps.setString(6, movie.getStudio());
                ps.executeUpdate();
            } catch (Exception e) {
                System.err.println(e);
            }
        }

        System.out.println("Syncing done!");
        System.out.println();
    }
    
    public ArrayList<Staff> syncStaffData(){
    	ArrayList<Staff> staffList = new ArrayList<>();
    	String sql = "SELECT * FROM `staff`";
    	
    	rs = connect.executeQuery(sql);
    	
    	try {
			while(rs.next()) {
				Staff f = new Staff(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(1), rs.getInt(6));
				staffList.add(f);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
    	return staffList;
    }
    
    public ArrayList<Customer> syncCustomerData(){
    	ArrayList<Customer> customerList = new ArrayList<>();
    	String sql = "SELECT * FROM `customer`";
    	
    	rs = connect.executeQuery(sql);
    	
    	try {
			while(rs.next()) {
				Customer c = new Customer(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(1));
				customerList.add(c);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
    	return customerList;
    }
    
    public ArrayList<Book> syncBookData(){
    	ArrayList<Book> bookList = new ArrayList<>();
    	String sql = "SELECT * FROM `book`";
    	
    	rs = connect.executeQuery(sql);
    	
    	try {
			while(rs.next()) {
				java.util.Date date = new java.util.Date(rs.getDate(5).getTime());
				Book b = new Book(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), date, rs.getString(6), rs.getString(7));
				bookList.add(b);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
    	return bookList;
    }
    
    public ArrayList<Movie> syncMovieData(){
    	ArrayList<Movie> movieList = new ArrayList<>();
    	String sql = "SELECT * FROM `movie`";
    	
    	rs = connect.executeQuery(sql);
    	
    	try {
			while(rs.next()) {
				java.util.Date date = new java.util.Date(rs.getDate(5).getTime());
				Movie m = new Movie(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), date, rs.getString(6));
				movieList.add(m);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
    	return movieList;
    }
    
}
