package ie.lyit;

import ie.lyit.book.Menu;
import ie.lyit.serialize.BookSerializer;

public class BookSerializerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookSerializer bs = new BookSerializer();
		
		bs.deserializeBooks();
		
		Menu menu = new Menu();
		
		do {
			// Call the Menu objects display() method
			menu.display();
			// Call the Menu objects readOption() method
			menu.readOption();
			// Switch on the chosen option and call the approapiate method
			switch(menu.getOption()) {
			case 1:	bs.addBook();
					break;
			case 2:	bs.list();
					break;
			case 3:	bs.view();
					break;
			case 4:	bs.edit();
					break;
			case 5:	bs.delete();
					break;
			case 6: 
					break;
			default:System.out.println("INVALID OPTION...");
			}
		}while(menu.getOption() != 6);
		
		bs.serializeBooks();
		
		
		
//		bs.deserializeBooks();
//		bs.addBook();
//		bs.addBook();
//	bs.serializeBooks();
//	bs.deserializeBooks();
//		bs.list();
	}

}
