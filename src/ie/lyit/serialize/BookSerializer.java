package ie.lyit.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import ie.lyit.book.Book;

public class BookSerializer {
	ArrayList<Book> books;
	
	public BookSerializer(){
		books = new ArrayList<Book>();
		
	}
	public void addBook() {
		Book b1 = new Book();
		b1.read();
		books.add(b1);
	}
	
	public void list() {
		for(Book b: books) {
			System.out.println(b);
		}
	}
	
	public Book view() {
		Scanner sc = new Scanner(System.in);
		
		// Read number of book to be viewed from user
		System.out.println("ENTER LIBRARY NUMBER OF BOOK : ");
		int bookToView = sc.nextInt();
		
		// loop around for every book in the ArrayList
		for(Book tmpBook : books) {
			// If its key field equals the key field of the bookToView
			if(tmpBook.getLibraryNumber() == bookToView) {
				// Display object on screen
				System.out.println(tmpBook);
				// And return it
				return tmpBook;
			}	
		}
		return null;
	}
	
	public void delete() {
		// Call view() method to find, display and return the book
		Book bookToDelete=view();
			// If the Book to be deleted != null
			if(bookToDelete != null) {
				// Delete from ArrayList 
				books.remove(bookToDelete);
			}		
	}
	
	public void edit() {
		// Call view() method
		Book bookToEdit = view();
		// IF book to be edited != null
		if(bookToEdit != null) {
			// Get it's index 
			int index = books.indexOf(bookToEdit);
			// Read in the new details for it by calling it's read() method
			bookToEdit.read();
			// Reset it in the ArrayList to this new object using the ArrayList
			books.set(index, bookToEdit);
		}
		
		
		
		
	}
	
	public void serializeBooks() {
		final String FILENAME = "D:/Academic_Subjects_2021_2022/Sem5/Software Implementation/Week 6/ArrayBooks.bin";

		 //FileOutputStream fs=new FileOutputStream(FILENAME);
		 //ObjectOutputStream os = new ObjectOutputStream(fs);
		 // or	
		 //	ObjectOutputStream os = new ObjectOutputStream(
		 //	new FileOutputStream(FILENAME));
		
		ObjectOutputStream os = null;
		
		if(books instanceof Serializable) {
			try{
				 FileOutputStream fileStream = new 
				 FileOutputStream(FILENAME);
				 os = new ObjectOutputStream(fileStream);
				 os.writeObject(books);
				 }
				 catch(FileNotFoundException f){
					 System.out.println("File Not Found" + f.getMessage());
				 }catch(IOException e){
					 System.out.println("Input Output Error"+ e.getMessage());
				 }
				 finally{
				 try{
					 os.close();
				 }catch(IOException e){
					 System.out.println("I/p O/p Error" + e.getMessage());
				 }
			}
		}
	}
	
	public void deserializeBooks() {
		// And to deserialize it...
		final String FILENAME = "D:/Academic_Subjects_2021_2022/Sem5/Software Implementation/Week 6/ArrayBooks.bin";
		ObjectInputStream is = null;
		try{
			FileInputStream fileStream = new 
					FileInputStream(FILENAME);
			is = new ObjectInputStream(fileStream);
			books =(ArrayList<Book>) is.readObject();
			// OR SET STATIC HERE
			// Getting the number of the last element in ArrayList
			// set static to that number+1
		}
		 catch(FileNotFoundException f){
			 System.out.println("File Not Found" + f.getMessage());
		 }catch(IOException e){
			 System.out.println("Input Output Error" + e.getMessage());
		 } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
			 try{
				 is.close();
			 }	
			 catch(IOException e){
			 System.out.println("I/p O/p Error" + e.getMessage());
			 }
		 }

	}
	
	
}
