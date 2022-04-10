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
		System.out.println("0. Keluar dari aplikasi");
		System.out.print("Masukkan pilihan kamu >>> ");

	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	//fitur create
	public void printMenuInputDataBaru() {
		int inpNum;
		do {
			System.out.println("1. Staff");
			System.out.println("2. Customer");
			System.out.println("3. Book");
			System.out.println("4. Movie");
			System.out.println("5. Exit");
			System.out.print("Masukkan pilihan kamu >>> ");
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
}
