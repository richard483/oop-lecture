package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Model.Book;
import Model.Customer;
import Model.Movie;
import Model.Staff;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<Customer> customerList = new ArrayList<>();
	ArrayList<Staff> staffList = new ArrayList<>();
	ArrayList<Book> bookList = new ArrayList<>();
	ArrayList<Movie> movieList = new ArrayList<>();
	
	public Main() {
		Integer input = 0;
		
		do {
			printWelcome();
			printMenu();
			
			input = scanInt();
			System.out.println();
			
			switch (input) {
			case 1:
				//input data baru
				printMenuInputDataBaru();
				break;
			case 2:
				//view data
				break;
			case 3:
				//update data
				break;
			case 4:
				//delete data
				break;
			case 5:
				//search data	
				searchMenu();
				break;
			case 0:
				System.out.println("Terima kasih, selamat kembali lagi!");
				break;
			default:
				break;
			}
			
		}while(!input.equals(0));
		
	}
	
	public int scanInt() {
		int x = -1;
		
		try {
			x = scan.nextInt();
			scan.nextLine();
		} catch (Exception e) {
			System.err.println("Input harus dalam bentuk Integer!");
			System.out.println("Tekan spasi untuk melanjutkan");
			scan.nextLine();
			System.out.println();
		}
		return x;
	}
	
	public void printWelcome() {
		System.out.println(" __      __        ___                                         __               __          __                                     \r\n"
				+ "/\\ \\  __/\\ \\      /\\_ \\                                       /\\ \\__           /\\ \\      __/\\ \\                                    \r\n"
				+ "\\ \\ \\/\\ \\ \\ \\    _\\//\\ \\     ___    ___    ___ ___      __    \\ \\ ,_\\   ___    \\ \\ \\    /\\_\\ \\ \\____  _ __   __    _ __  __  __    \r\n"
				+ " \\ \\ \\ \\ \\ \\ \\ /'__`\\ \\ \\   /'___\\ / __`\\/' __` __`\\  /'__`\\   \\ \\ \\/  / __`\\   \\ \\ \\  _\\/\\ \\ \\ '__`\\/\\`'__/'__`\\ /\\`'__/\\ \\/\\ \\   \r\n"
				+ "  \\ \\ \\_/ \\_\\ /\\  __/\\_\\ \\_/\\ \\__//\\ \\L\\ /\\ \\/\\ \\/\\ \\/\\  __/    \\ \\ \\_/\\ \\L\\ \\   \\ \\ \\L\\ \\ \\ \\ \\ \\L\\ \\ \\ \\/\\ \\L\\.\\\\ \\ \\/\\ \\ \\_\\ \\  \r\n"
				+ "   \\ `\\___x___\\ \\____/\\____\\ \\____\\ \\____\\ \\_\\ \\_\\ \\_\\ \\____\\    \\ \\__\\ \\____/    \\ \\____/\\ \\_\\ \\_,__/\\ \\_\\ \\__/.\\_\\ \\_\\ \\/`____ \\ \r\n"
				+ "    '\\/__//__/ \\/____\\/____/\\/____/\\/___/ \\/_/\\/_/\\/_/\\/____/     \\/__/\\/___/      \\/___/  \\/_/\\/___/  \\/_/\\/__/\\/_/\\/_/  `/___/> \\\r\n"
				+ "                                                                                                                             /\\___/\r\n"
				+ "                                                                                                                             \\/__/ ");
	}
	
	public void printMenu() {
		System.out.println("Apa yang ingin kamu lakukan?");
		System.out.println("1. Input data baru");
		System.out.println("2. View data");
		System.out.println("3. Update data");
		System.out.println("4. Delete data");
		System.out.println("5. Search data");
		System.out.println("0. Keluar dari aplikasi");
		System.out.print("Masukkan pilihan kamu >>> ");

	}
	
	public void printMenuDetail() {
		System.out.println("1. Staff");
		System.out.println("2. Customer");
		System.out.println("3. Book");
		System.out.println("4. Movie");
		System.out.println("5. Exit");
		System.out.print("Masukkan pilihan kamu >>> ");
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	//fitur create
	public void printMenuInputDataBaru() {
		int inpNum;
		do {
			printMenuDetail();
			inpNum = scanInt();
			switch (inpNum) {
			case 1:
				addStaffData();
				break;
			case 2:
				addCustomerData();
				break;
			case 3:
				addBookData();
				break;
			case 4:
				addMovieData();
				break;
			case 0:
				
				break;

			default:
				break;
			}
		} while (inpNum != 5);
	}


	public void addStaffData() {
		String inpNama;
		String inpPhoneNumber;
		String inpEmailAddress;
		String inpGender;
		String inpStaffId;
		Integer inpSalary; 
		do {
			System.out.println("Masukkan nama staff [length > 1 && < 50]: ");
			inpNama = scan.nextLine();
		} while (inpNama.length()< 1 || inpNama.length() >50);
		do {
			System.out.println("Masukkan nomor telepon staff [length < 12]: ");
			inpPhoneNumber = scan.nextLine();
		} while (inpPhoneNumber.length() >= 12);
		do {
			System.out.println("Masukkan Email Staff [must contain '@']: ");
			inpEmailAddress = scan.nextLine();
		} while (!(inpEmailAddress.contains("@")));
		do {
			System.out.println("Masukkan Gender Staff ['Male' or 'Female']: ");
			inpGender = scan.nextLine();
		} while (!(inpGender.equalsIgnoreCase("Male") || inpGender.equalsIgnoreCase("Female")));
		do {
			System.out.println("Masukkan Staff ID [must contain EMP]: ");
			inpStaffId = scan.nextLine();
		} while (!(inpStaffId.contains("EMP")));
		do {
			System.out.println("Masukkan Salary Staff: ");
			inpSalary = scan.nextInt();
		} while (!(inpSalary != 0));
		Staff dataStaff = new Staff(inpNama, inpPhoneNumber, inpEmailAddress, inpGender, inpStaffId, inpSalary);
		staffList.add(dataStaff);
	}

	public void addCustomerData() {
		String inpNama;
		String inpPhoneNumber;
		String inpEmailAddress;
		String inpGender;
		String inpCustomerId;
		do {
			System.out.println("Masukkan nama customer [length > 1 && < 50]: ");
			inpNama = scan.nextLine();
		} while (inpNama.length()< 1 || inpNama.length() >50);
		do {
			System.out.println("Masukkan nomor telepon customer [length < 12]: ");
			inpPhoneNumber = scan.nextLine();
		} while (inpPhoneNumber.length() >= 12);
		do {
			System.out.println("Masukkan Email customer [must contain '@']: ");
			inpEmailAddress = scan.nextLine();
		} while (!(inpEmailAddress.contains("@")));
		do {
			System.out.println("Masukkan Gender customer ['Male' or 'Female']: ");
			inpGender = scan.nextLine();
		} while (!(inpGender.equalsIgnoreCase("Male") || inpGender.equalsIgnoreCase("Female")));
		do {
			System.out.println("Masukkan customer ID [must contain 'CUS']: ");
			inpCustomerId = scan.nextLine();
		} while (!(inpCustomerId.contains("CUS")));
		Customer customerData = new Customer(inpNama, inpPhoneNumber, inpEmailAddress, inpGender, inpCustomerId);
		customerList.add(customerData);
	}

	public void addBookData() {
		String inpitemID;
		String inptitle;
		String inpauthor;
		String inpgenre;
		String inpreleaseDate;
		String inpisbn;
		String intpublisher;
		do {
			System.out.println("Masukkan Item ID [must contain 'BOK']: ");
			inpitemID = scan.nextLine();
		} while (!(inpitemID.contains("BOK")));
		do {
			System.out.println("Masukkan Book Title: ");
			inptitle = scan.nextLine();
		} while (inptitle.length()< 1 || inptitle.length() >50);
		do {
			System.out.println("Masukkan Book Author: ");
			inpauthor = scan.nextLine();
		} while (inpauthor.length()< 1 || inpauthor.length() >50);
		do {
			System.out.println("Masukkan Book Genre: ");
			inpgenre = scan.nextLine();
		} while (inpgenre.length()< 1 || inpgenre.length() >50);

		//ini input date gw bikin gada validasi dl (ricat)
		System.out.println("Masukkan Release Date (dd-mm-yyyy): ");
		inpreleaseDate = scan.nextLine();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
		Date dateTemp = null;
		try{
			dateTemp = simpleDateFormat.parse(inpreleaseDate);
		} catch (Exception e){
			System.err.println(e);
		}

		do {
			System.out.println("Masukkan Book ISBN: ");
			inpisbn = scan.nextLine();
		} while (inpisbn.length() >= 12);
		do {
			System.out.println("Masukkan Book Publisher: ");
			intpublisher = scan.nextLine();
		} while (intpublisher.length()< 1 || intpublisher.length() >50);
		Book addBookData = new Book(inpitemID, inptitle, inpauthor, inpgenre, dateTemp, inpisbn, intpublisher);
		bookList.add(addBookData);
		
	}

	public void addMovieData() {
		String inpitemID;
		String inptitle;
		String inpauthor;
		String inpgenre; 
		String inpreleaseDate; 
		String inpstudio; 
		
		do {
			System.out.println("Masukkan Item ID: ");
			inpitemID = scan.nextLine();
		} while (!(inpitemID.contains("MOV")));
		do {
			System.out.println("Masukkan Movie Title: ");
			inptitle = scan.nextLine();
		} while (inptitle.length()< 1 || inptitle.length() >50);
		do {
			System.out.println("Masukkan Movie Author: ");
			inpauthor = scan.nextLine();
		} while (inpauthor.length()< 1 || inpauthor.length() >50);
		do {
			System.out.println("Masukkan Movie Genre: ");
			inpgenre = scan.nextLine();
		} while (inpgenre.length()< 1 || inpgenre.length() >50);

		//ini juga gw tiadain do-whilenya

		System.out.println("Masukkan Release Date (dd-mm-yyyy): ");
		inpreleaseDate = scan.nextLine();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
		Date dateTemp = null;
		try{
			dateTemp = simpleDateFormat.parse(inpreleaseDate);
		} catch (Exception e){
			System.err.println(e);
		}
		// do {
		// 	System.out.println("Masukkan Release Date: ");
		// 	inpreleaseDate = scan.next();
		// } while (!(inpreleaseDate.contains("January")));
		do {
			System.out.println("Masukkan Movie Studio: ");
			inpstudio = scan.nextLine();
		} while (inpstudio.length()< 1 || inpstudio.length() >50);
		Movie addMovieData = new Movie(inpitemID, inptitle, inpauthor, inpgenre, dateTemp, inpstudio);
		movieList.add(addMovieData);
	}
	
	public void searchMenu() {
		int inpNum;
		do {
			printMenuDetail();
			inpNum = scanInt();
			switch (inpNum) {
			case 1:
				searchStaffData();
				break;
			case 2:
				searchCustomerData();
				break;
			case 3:
				searchBookData();
				break;
			case 4:
				searchMovieData();
				break;
			default:
				break;
			}
		} while (inpNum != 5);
	}
	
	public void searchStaffData() {
		if(staffList.isEmpty()) {
			System.out.println("data staff masih kosong..");
			System.out.println("Press Enter to continue");
			scan.nextLine();
		}else {
			String staffSearch;
			System.out.println("Masukan nama staff yang ingin dicari..");
			System.out.print(">> ");
			staffSearch = scan.nextLine();
			boolean find = false;
			int i = 1;
			for (Staff staff : staffList) {
				if(staff.getName().contains(staffSearch)) {
					System.out.println(i++);
					System.out.println("Staff ID: " + staff.getStaffID());
					System.out.println("Staff Name: " + staff.getName());
					System.out.println("Staff Email: " + staff.getEmailAddress());
					System.out.println("Staff Phone: " + staff.getPhoneNumber());
					System.out.println("Staff Gender: " + staff.getGender());
					System.out.println("Staff Salary: " + staff.getSalary() + "\n");
					find = true;
					
				}
			}
			if(find == false) {
				System.out.println("data staff tidak ditemukan..");
			}
			System.out.println("Press Enter to continue");
			scan.nextLine();

		}
	}
	
	public void searchCustomerData() {
		if(customerList.isEmpty()) {
			System.out.println("data customer masih kosong..");
			System.out.println("Press Enter to continue");
			scan.nextLine();
		}else {
			String customerSearch;
			System.out.println("Masukan nama customer yang ingin dicari..");
			System.out.print(">> ");
			customerSearch = scan.nextLine();
			boolean find = false;
			int i = 1;
			for (Customer customer : customerList) {
				if(customer.getName().contains(customerSearch)) {
					System.out.println(i++);
					System.out.println("Customer ID: " + customer.getCustomerID());
					System.out.println("Customer Name: " + customer.getName());
					System.out.println("Customer Email: " + customer.getEmailAddress());
					System.out.println("Customer Phone: " + customer.getPhoneNumber());
					System.out.println("Customer Gender: " + customer.getGender() +"\n");
					find = true;
					
				}
			}
			if(find == false) {
				System.out.println("data customer tidak ditemukan..");
			}
			System.out.println("Press Enter to continue");
			scan.nextLine();
		}
	}
	
	public void searchBookData() {
		if (bookList.isEmpty()) {
			System.out.println("data buku masih kosong..");
			System.out.println("Press Enter to continue");
			scan.nextLine();
		} else {
			String searchBuku;
			System.out.println("Masukan judul buku atau karya penulis yang ingin dicari..");
			System.out.print(">> ");
			searchBuku = scan.nextLine();
			boolean find = false;
			int i = 1;
			for (Book book : bookList) {
				if(book.getAuthor().contains(searchBuku) || book.getTitle().contains(searchBuku)) {
					System.out.println(i++);
					System.out.println("Book ID: " + book.getItemID());
					System.out.println("Book Title: " + book.getTitle());
					System.out.println("Book ISBN: " + book.getIsbn());
					System.out.println("Book Author: " + book.getAuthor());
					System.out.println("Book Genre" + book.getGenre());
					System.out.println("Book Publisher: " + book.getPublisher() + "\n");
					find = true;
				}
			}
			if(find == false) {
				System.out.println("data buku tidak ditemukan..");
			}
			System.out.println("Press Enter to continue");
			scan.nextLine();
		}
	}
	
	public void searchMovieData() {
		if (movieList.isEmpty()) {
			System.out.println("data film masih kosong..");
			System.out.println("Press Enter to continue");
			scan.nextLine();
		} else {
			String searchMovie;
			System.out.println("Masukan judul film atau karya pencipta yang ingin dicari..");
			System.out.print(">> ");
			searchMovie = scan.nextLine();
			boolean find = false;
			int i = 1;
			for (Movie movie: movieList) {
				if(movie.getAuthor().contains(searchMovie) || movie.getTitle().contains(searchMovie)) {
					System.out.println(i++);
					System.out.println("Movie ID: " + movie.getItemID());
					System.out.println("Movie Title: " + movie.getTitle());
					System.out.println("Movie Author: " + movie.getAuthor());
					System.out.println("Movie Genre" + movie.getGenre());
					System.out.println("Movie Studio: " + movie.getStudio() + "\n");
					find = true;
				}
			}
			if(find == false) {
				System.out.println("data film tidak ditemukan..");
			}
			System.out.println("Press Enter to continue");
			scan.nextLine();
		}
	}
	
	
	
}
