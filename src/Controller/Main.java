package Controller;

import java.util.ArrayList;
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

}
