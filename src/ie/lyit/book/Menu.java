package ie.lyit.book;

import java.util.Scanner;

public class Menu {
	private int option;
	
	public Menu() {
		option=0;
	}
	
	public void display() {
		System.out.println("\t\tBOOK MENU\n");
		System.out.println("\t1. Add");
		System.out.println("\t2. List");
		System.out.println("\t3. View");
		System.out.println("\t4. Edit");
		System.out.println("\t5. Delete");
		System.out.println("\t6. Quit");
	}
	
	public void readOption() {
		//try {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\tEnter option [1|2|3|4|5|6]");
		option = sc.nextInt();
		//}
		//catch(NumberFormatException nFE)
	}
	
	public int getOption() {
		return option;
	}
}
