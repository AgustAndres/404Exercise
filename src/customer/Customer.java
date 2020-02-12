package customer;

import java.util.ArrayList;

import exception.NotFoundException;
import interfaces.GetBookByNameInterface;
import readingMaterial.Book;
import readingMaterial.ReadingMaterial;
import store.Store;

public class Customer implements GetBookByNameInterface{

	private String name;
	private ArrayList<ReadingMaterial> rentedBooks;

	public Customer(String name) {
		this.name=name;
		rentedBooks = new ArrayList<ReadingMaterial>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<ReadingMaterial> getRentedBooks() {
		return rentedBooks;
	}

	public void setRentedBooks(ArrayList<ReadingMaterial> rentedBooks) {
		this.rentedBooks = rentedBooks;
	}

	public void rentBook(Store store, String bookName) {
		try {
			rentedBooks.add(store.rentBook(bookName));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ReadingMaterial getBookByName(String bookName) throws NotFoundException {
		for (ReadingMaterial book : rentedBooks) {
			if (book.getName() == bookName)
				return book;
		}
		throw new NotFoundException("Book not found");
	}

	public Boolean returnBook(Store store, String bookName) {
		try {
			ReadingMaterial returnedBook = getBookByName(bookName);
			if(store.returnBook(returnedBook));{
				rentedBooks.remove(returnedBook);
				return true;
			}
			
		} catch (NotFoundException e) {
			System.out.println(e);
		}
		return false;
	}
	

}
