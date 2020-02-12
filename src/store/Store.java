package store;

import java.util.ArrayList;
import java.util.List;

import books.Book;
import exception.NotFoundException;
import interfaces.GetBookByNameInterface;
import manager.Manager;

public class Store implements GetBookByNameInterface{

	private String name;
	private List<Book> books;
	private List<Book> rentedBooks;
	private Manager manager;

	public Store(Manager manager, String name) {
		this.name = name;
		this.manager = manager;
		this.books = new ArrayList<Book>();
		this.rentedBooks = new ArrayList<Book>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Book> getRentedBooks() {
		return rentedBooks;
	}

	public void setRentedBooks(List<Book> rentedBooks) {
		this.rentedBooks = rentedBooks;
	}

	public void addBook(Book newBook) {
		books.add(newBook);
	}

	public int getStock(String bookName) {
		int aux = 0;
		for (Book book : books) {
			if (book.getName() == bookName)
				aux++;
		}
		return aux;
	}

	public Book getBookByName(String bookName) throws NotFoundException {
		for (Book book : books) {
			if (book.getName() == bookName)
				return book;
		}
		throw new NotFoundException("Book not found");
	}

	public Book rentBook(String bookName) throws NotFoundException {
		Book rentedBook = getBookByName(bookName);
		books.remove(rentedBook);
		rentedBooks.add(rentedBook);
		return rentedBook;
	}

	public Boolean returnBook(Book returnedBook) {
		if(rentedBooks.contains(returnedBook)) {
			rentedBooks.remove(returnedBook);
			books.add(returnedBook);
			return true;
		} else {
			return false;
		}
	}

}
