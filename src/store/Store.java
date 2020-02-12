package store;

import java.util.ArrayList;
import java.util.List;

import books.Book;
import manager.Manager;


public class Store {

	private String name;
	private List<Book> books;
	private Manager manager;

	public Store(Manager manager,String name) {
		this.name=name;
		this.manager = manager;
		this.books = new ArrayList<Book>();
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
	
	public void addBook(Book newBook) {
		books.add(newBook);
	}

	public int getStock(String bookName) {
		int aux = 0;
		for (Book book : books) {
			if(book.getName()==bookName)aux++;
		}
		return aux;
	}

}
