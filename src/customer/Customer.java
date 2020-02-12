package customer;

import java.util.ArrayList;

import books.Book;
import exception.NotFoundException;
import interfaces.GetBookByNameInterface;
import store.Store;

public class Customer implements GetBookByNameInterface{

	private String name;
	private ArrayList<Book> rentedBooks;

	public Customer(String name) {
		this.name=name;
		rentedBooks = new ArrayList<Book>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Book> getRentedBooks() {
		return rentedBooks;
	}

	public void setRentedBooks(ArrayList<Book> rentedBooks) {
		this.rentedBooks = rentedBooks;
	}

	public void rentBook(Store store, String bookName) {
		try {
			rentedBooks.add(store.rentBook(bookName));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Book getBookByName(String bookName) throws NotFoundException {
		for (Book book : rentedBooks) {
			if (book.getName() == bookName)
				return book;
		}
		throw new NotFoundException("Book not found");
	}

	public Boolean returnBook(Store store, String bookName) {
		try {
			Book returnedBook = getBookByName(bookName);
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
