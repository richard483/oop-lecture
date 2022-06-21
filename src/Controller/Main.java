package Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Model.Book;
import Model.Customer;
import Model.Movie;
import Model.Staff;

public class Main {
	DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	Scanner scan = new Scanner(System.in);
	DatabaseDAO db = new DatabaseDAO();
	ArrayList<Customer> customerList = new ArrayList<>();
	ArrayList<Staff> staffList = new ArrayList<>();
	ArrayList<Book> bookList = new ArrayList<>();
	ArrayList<Movie> movieList = new ArrayList<>();
	
	public Main() {
		staffList = db.syncStaffData();
		customerList = db.syncCustomerData();
		bookList = db.syncBookData();
		movieList = db.syncMovieData();
		
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
				viewMenu();
				break;
			case 3:
				update();
				break;
			case 4:
				deleteMenu();
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
	
	public void printMenuInputDataBaru() {
		int inpNum;
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
			scan.nextLine();
		} while (!(inpSalary != 0));
		Staff dataStaff = new Staff(inpNama, inpPhoneNumber, inpEmailAddress, inpGender, inpStaffId, inpSalary);
		staffList.add(dataStaff);
		db.updateStaffList(staffList);
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
		
		db.updateCustomerList(customerList);
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
		
		db.updateBookList(bookList);
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
			System.out.println("Masukkan Movie Studio: ");
			inpstudio = scan.nextLine();
		} while (inpstudio.length()< 1 || inpstudio.length() >50);
		Movie addMovieData = new Movie(inpitemID, inptitle, inpauthor, inpgenre, dateTemp, inpstudio);
		movieList.add(addMovieData);
		
		db.updateMovieList(movieList);
	}
	
	public void searchMenu() {
		int inpNum;
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
	
	public void viewMenu(){
		System.out.println("Welcome to View Menu!");
		int inpNum;
		printMenuDetail();
		inpNum = scanInt();
		switch (inpNum) {
		case 1:
			viewStaff();
			break;
		case 2:
			viewCustomer();
			break;
		case 3:
			viewBook();
			break;
		case 4:
			viewMovie();
			break;
		default:
			break;
		}
	}

	public void deleteMenu() {
		int inp;
		System.out.println("Data mana yang ingin di hapus ?");
		System.out.println("1. Customer Data");
		System.out.println("2. Staff Data");
		System.out.println("3. Book Data");
		System.out.println("4. Movie Data");
		System.out.print(">> ");
		inp = scan.nextInt();
		scan.nextLine();
		switch (inp) {
		case 1:
			//delete Customer Data
			System.out.println("Customer Data:");
			System.out.println();
			viewCustomer();
			int nomorCust;
			System.out.println("Masukkan Nomor Customer yang ingin di hapus: ");
			nomorCust = scan.nextInt();
			scan.nextLine();
			try {
				customerList.remove(nomorCust - 1);
				System.out.println("Data telah dihapus");
			} catch (Exception e) {
				System.out.println("Data tidak ditemukan");	
			}
			System.out.println();
			break;
		case 2: 
			//delete Staff Data
			System.out.println("Staff Data:");
			System.out.println();
			viewStaff();
			int nomorStaff;
			System.out.println("Masukkan Nomor Staff yang ingin di hapus : ");
			nomorStaff = scan.nextInt();
			scan.nextLine();
			try {
				staffList.remove(nomorStaff - 1);
				System.out.println("Data telah dihapus");
			} catch (Exception e) {
				System.out.println("Data tidak ditemukan");
			}
			System.out.println();
			break;
		case 3: 
			//delete Book Data
			System.out.println("Book Data:");
			System.out.println();
			viewBook();
			int nomorBook;
			System.out.println("Masukkan Nomor Buku yang ingin di hapus : ");
			nomorBook = scan.nextInt();
			scan.nextLine();
			try {
				bookList.remove(nomorBook);
				System.out.println("Data telah dihapus");
			} catch (Exception e) {
				System.out.println("Data tidak ditemukan");
			}
			System.out.println();
			break;
		case 4:
			//delete Movie Data
			System.out.println("Movie Data:");
			System.out.println();
			viewBook();
			int nomorMovie;
			System.out.println("Masukkan Nomor Movie yang ingin dihapus : ");
			nomorMovie = scan.nextInt();
			scan.nextLine();
			try {
				movieList.remove(nomorMovie);
				System.out.println("Data telah dihapus");
			} catch (Exception e) {
				System.out.println("Data tidak ditemukan");
			}
			System.out.println();
			break;
		default:
			break;
		}
		
		db.updateBookList(bookList);
		db.updateMovieList(movieList);
		db.updateCustomerList(customerList);
		db.updateStaffList(staffList);
	}

	public void displayData() {
		Integer inp = 0;
		viewMenu();
		inp = scanInt();
		System.out.println();
		
		switch(inp) {
		//Book View
		case 1:
			viewBook();
			break;
				
		//Customer View
		case 2:
			viewCustomer();
			break;
				
		//Movie view
		case 3:
			viewMovie();
			break;
				
		//Staff view
		case 4:
			viewStaff();
			break;
		default:
			System.out.println("Menu tidak tersedia");
			break;
		}
		
	}

	public void viewBook(){
		int count = 1;
		if (bookList.isEmpty()) {
			System.out.println("Data buku tidak ditemukan!");
			System.out.println();
		}
		System.out.println("================================================================================================================================");
		System.out.println("| NO. |    ID    |        Book Title        |       Author       |  Genre  |      Release Date      |    Publisher    |  ISBN  |");
		System.out.println("================================================================================================================================");
		for (Book book : bookList) {
			System.out.printf("| %-4d| %-8s | %-24s | %-18s | %-7s | %-22s | %-15s | %-6s |\n", count, book.getItemID(), book.getTitle()
					, book.getAuthor(), book.getGenre(), df.format(book.getReleaseDate()), book.getPublisher(), book.getIsbn());
					count++;
		}
		System.out.println("================================================================================================================================");
		System.out.println();
	}
	
	public void viewCustomer(){
		int count = 1;
		if (customerList.isEmpty()) {
			System.out.println("There is no customer data!");
			System.out.println();
		}
		System.out.println("=================================================================================================");
		System.out.println("| NO. |    ID    |        Name        |  Phone Number  |        Email Address        |  Gender  |");
		System.out.println("=================================================================================================");
		for (Customer customer : customerList) {
			System.out.printf("| %-4d| %-8s | %-18s | %-14s | %-27s | %-8s |\n", count, customer.getCustomerID(), customer.getName() 
					, customer.getPhoneNumber(), customer.getEmailAddress(), customer.getGender());
					count++;
		}
		System.out.println("=================================================================================================");
		System.out.println();
	}

	public void viewMovie(){
		int count = 1;
		if(movieList.isEmpty()) {
			System.out.println("There is no film data!");
			System.out.println();
		}
		System.out.println("==============================================================================================================");
		System.out.println("| NO. |    ID    |        Movie Title        |       Author       |   Genre   |    Release Date    |  Studio  |");
		System.out.println("==============================================================================================================");
		for (Movie movie : movieList) {
			System.out.printf("| %-4d| %-8s | %-25s | %-18s | %-9s | %-18s | %-8s |\n", count, movie.getItemID(), movie.getTitle()
					, movie.getAuthor(), movie.getGenre(), df.format(movie.getReleaseDate()), movie.getStudio());
					count++;
		}
		System.out.println("==============================================================================================================");
		System.out.println();
	}

	public void viewStaff(){
		int count = 1;
		if(staffList.isEmpty()) {
			System.out.println("There is no staff listed!");
			System.out.println();
		}
		System.out.println("==============================================================================================================");
		System.out.println("| NO. |    ID    |        Name        |  Phone Number  |        Email Address        |  Gender  |   Salary   |");
		System.out.println("==============================================================================================================");
		for (Staff staff : staffList) {
			System.out.printf("| %-4d| %-8s | %-18s | %-14s | %-27s | %-8s | %-10d |\n", count,staff.getStaffID(), staff.getName() 
					, staff.getPhoneNumber(), staff.getEmailAddress(), staff.getGender(), staff.getSalary());
					count++;
		}
		System.out.println("==============================================================================================================");
		System.out.println();
	}

	public void update(){
		int inpNum;
		System.out.println("Pilih entitiy yang ingin di Update: ");
		printMenuDetail();
		inpNum = scanInt();
		switch (inpNum) {
		case 1:
			updateStaff();
			break;
		case 2:
			updateCustomer();
			break;
		case 3:
			updateBook();
			break;
		case 4:
			updateMovie();
			break;
		default:
			break;
		}
	}

	public void updateStaff(){
		int select;
		String inpNama;
		String inpPhoneNumber;
		String inpEmailAddress;
		String inpGender;
		String inpStaffId;
		Integer inpSalary;

		System.out.println("Staff data: ");
		viewStaff();
		System.out.println();

		System.out.print("Input the index number of data to be edited >> ");
		select = scanInt();

		try {
			System.out.println("Edit data field [input '0' to keep previous data]: ");

			do {
				System.out.println("Masukkan nama staff [length > 1 && < 50]: ");
				inpNama = scan.nextLine();
				if(inpNama == "0"){
					inpNama = staffList.get(select-1).getName();
				}
			} while (inpNama.length()< 1 || inpNama.length() >50);
			do {
				System.out.println("Masukkan nomor telepon staff [length < 12]: ");
				inpPhoneNumber = scan.nextLine();
				if(inpPhoneNumber == "0"){
					inpPhoneNumber = staffList.get(select-1).getPhoneNumber();
				}
			} while (inpPhoneNumber.length() >= 12);
			do {
				System.out.println("Masukkan Email Staff [must contain '@']: ");
				inpEmailAddress = scan.nextLine();
				if(inpEmailAddress == "0"){
					inpEmailAddress = staffList.get(select-1).getEmailAddress();
				}
			} while (!(inpEmailAddress.contains("@")));
			do {
				System.out.println("Masukkan Gender Staff ['Male' or 'Female']: ");
				inpGender = scan.nextLine();
				if(inpGender == "0"){
					inpGender = staffList.get(select-1).getGender();
				}
			} while (!(inpGender.equalsIgnoreCase("Male") || inpGender.equalsIgnoreCase("Female")));

			inpStaffId = staffList.get(select-1).getStaffID();

			do {
				System.out.println("Masukkan Salary Staff: ");
				inpSalary = scan.nextInt();
				scan.nextLine();
				if(inpSalary == 0){
					inpSalary = staffList.get(select-1).getSalary();
				}
			} while (!(inpSalary != 0));

			staffList.get(select-1).setName(inpNama);
			staffList.get(select-1).setPhoneNumber(inpPhoneNumber);;
			staffList.get(select-1).setEmailAddress(inpEmailAddress);;
			staffList.get(select-1).setGender(inpGender);
			staffList.get(select-1).setSalary(inpSalary);

			System.out.println("Data updated, tap enter to continue!");
			scan.nextLine();

		} catch (Exception e) {
			System.out.println("Data tidak ditemukan");
		}
		System.out.println();
		
		db.updateStaffList(staffList);
	}

	public void updateCustomer(){
		int select;
		String inpNama;
		String inpPhoneNumber;
		String inpEmailAddress;
		String inpGender;
		String inpCustomerId;

		System.out.println("Customer data: ");
		viewCustomer();
		System.out.println();

		System.out.print("Input the index number of data to be edited >> ");
		select = scanInt();

		try {
			System.out.println("Edit data field [input '0' to keep previous data]: ");

			do {
				System.out.println("Masukkan nama customer [length > 1 && < 50]: ");
				inpNama = scan.nextLine();
				if(inpNama == "0"){
					inpNama = staffList.get(select-1).getName();
				}
			} while (inpNama.length()< 1 || inpNama.length() >50);
			do {
				System.out.println("Masukkan nomor telepon customer [length < 12]: ");
				inpPhoneNumber = scan.nextLine();
				if(inpPhoneNumber == "0"){
					inpPhoneNumber = staffList.get(select-1).getPhoneNumber();
				}
			} while (inpPhoneNumber.length() >= 12);
			do {
				System.out.println("Masukkan Email customer [must contain '@']: ");
				inpEmailAddress = scan.nextLine();
				if(inpEmailAddress == "0"){
					inpEmailAddress = staffList.get(select-1).getEmailAddress();
				}
			} while (!(inpEmailAddress.contains("@")));
			do {
				System.out.println("Masukkan Gender customer ['Male' or 'Female']: ");
				inpGender = scan.nextLine();
				if(inpGender == "0"){
					inpGender = staffList.get(select-1).getGender();
				}
			} while (!(inpGender.equalsIgnoreCase("Male") || inpGender.equalsIgnoreCase("Female")));

			inpCustomerId = staffList.get(select-1).getStaffID();

			customerList.get(select-1).setName(inpNama);
			customerList.get(select-1).setPhoneNumber(inpPhoneNumber);;
			customerList.get(select-1).setEmailAddress(inpEmailAddress);;
			customerList.get(select-1).setGender(inpGender);

			System.out.println("Data updated, tap enter to continue!");
			scan.nextLine();

		} catch (Exception e) {
			System.out.println("Data tidak ditemukan");
		}
		System.out.println();
		
		db.updateCustomerList(customerList);
	}

	public void updateBook(){
		int select;
		String inpitemID;
		String inptitle;
		String inpauthor;
		String inpgenre;
		String inpreleaseDate;
		String inpisbn;
		String intpublisher;

		System.out.println("Book data: ");
		viewBook();
		System.out.println();

		System.out.print("Input the index number of data to be edited >> ");
		select = scanInt();

		try {
			System.out.println("Edit data field [input '0' to keep previous data]: ");

			do {
				System.out.println("Masukkan Book Title: ");
				inptitle = scan.nextLine();
				if(inptitle == "0"){
					inptitle = bookList.get(select-1).getTitle();
				}
			} while (inptitle.length()< 1 || inptitle.length() >50);
			do {
				System.out.println("Masukkan Book Author: ");
				inpauthor = scan.nextLine();
				if(inpauthor == "0"){
					inpauthor = bookList.get(select-1).getAuthor();
				}
			} while (inpauthor.length()< 1 || inpauthor.length() >50);
			do {
				System.out.println("Masukkan Book Genre: ");
				inpgenre = scan.nextLine();
				if(inpgenre == "0"){
					inpgenre = bookList.get(select-1).getGenre();
				}
			} while (inpgenre.length()< 1 || inpgenre.length() >50);

			//ini input date gw bikin gada validasi dl (ricat)
			System.out.println("Masukkan Release Date (dd-mm-yyyy): ");
			inpreleaseDate = scan.nextLine();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
			Date dateTemp = null;

			if(inpreleaseDate == "0"){
				dateTemp = bookList.get(select-1).getReleaseDate();
			}else{
				try{
					dateTemp = simpleDateFormat.parse(inpreleaseDate);
				} catch (Exception e){
					System.err.println(e);
				}
			}
			
			do {
				System.out.println("Masukkan Book ISBN: ");
				inpisbn = scan.nextLine();
				if(inpisbn == "0"){
					inpisbn = bookList.get(select-1).getIsbn();
				}
			} while (inpisbn.length() >= 12);
			do {
				System.out.println("Masukkan Book Publisher: ");
				intpublisher = scan.nextLine();
				if(intpublisher == "0"){
					intpublisher = bookList.get(select-1).getPublisher();
				}
			} while (intpublisher.length()< 1 || intpublisher.length() >50);

			inpitemID = staffList.get(select-1).getStaffID();

			bookList.get(select-1).setItemID(inpitemID);
			bookList.get(select-1).setTitle(inptitle);
			bookList.get(select-1).setAuthor(inpauthor);
			bookList.get(select-1).setGenre(inpgenre);
			bookList.get(select-1).setReleaseDate(dateTemp);
			bookList.get(select-1).setIsbn(inpisbn);
			

			System.out.println("Data updated, tap enter to continue!");
			scan.nextLine();

		} catch (Exception e) {
			System.out.println("Data tidak ditemukan");
		}
		System.out.println();
		
		db.updateBookList(bookList);
	}

	public void updateMovie(){
		int select;
		String inpitemID;
		String inptitle;
		String inpauthor;
		String inpgenre; 
		String inpreleaseDate; 
		String inpstudio; 

		System.out.println("Movie data: ");
		viewMovie();
		System.out.println();

		System.out.print("Input the index number of data to be edited >> ");
		select = scanInt();

		try {
			System.out.println("Edit data field [input '0' to keep previous data]: ");

			do {
				System.out.println("Masukkan Movie Title: ");
				inptitle = scan.nextLine();
				if(inptitle == "0"){
					inptitle = movieList.get(select-1).getTitle();
				}
			} while (inptitle.length()< 1 || inptitle.length() >50);
			do {
				System.out.println("Masukkan Movie Author: ");
				inpauthor = scan.nextLine();
				if(inpauthor == "0"){
					inpauthor = movieList.get(select-1).getAuthor();
				}
			} while (inpauthor.length()< 1 || inpauthor.length() >50);
			do {
				System.out.println("Masukkan Movie Genre: ");
				inpgenre = scan.nextLine();
				if(inpgenre == "0"){
					inpgenre = movieList.get(select-1).getGenre();
				}
			} while (inpgenre.length()< 1 || inpgenre.length() >50);

			//ini input date gw bikin gada validasi dl (ricat)
			System.out.println("Masukkan Release Date (dd-mm-yyyy): ");
			inpreleaseDate = scan.nextLine();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-mm-yyyy");
			Date dateTemp = null;

			if(inpreleaseDate == "0"){
				dateTemp = movieList.get(select-1).getReleaseDate();
			}else{
				try{
					dateTemp = simpleDateFormat.parse(inpreleaseDate);
				} catch (Exception e){
					System.err.println(e);
				}
			}
			
			do {
				System.out.println("Masukkan Movie Studio: ");
				inpstudio = scan.nextLine();
				if(inpstudio == "0"){
					inpstudio = movieList.get(select-1).getStudio();
				}
			} while (inpstudio.length()< 1 || inpstudio.length() >50);

			inpitemID = staffList.get(select-1).getStaffID();

			movieList.get(select-1).setItemID(inpitemID);
			movieList.get(select-1).setTitle(inptitle);
			movieList.get(select-1).setAuthor(inpauthor);
			movieList.get(select-1).setGenre(inpgenre);
			movieList.get(select-1).setReleaseDate(dateTemp);
			movieList.get(select-1).setStudio(inpstudio);
			

			System.out.println("Data updated, tap enter to continue!");
			scan.nextLine();

		} catch (Exception e) {
			System.out.println("Data tidak ditemukan");
		}
		System.out.println();
		
		db.updateMovieList(movieList);
	}

	public static void main(String[] args) {
		new Main();
	}
	
}
