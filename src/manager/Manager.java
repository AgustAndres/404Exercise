package manager;

import books.Book;
import store.Store;

public class Manager {
	private String name;

	public Manager(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public void buyBooks(Store store, String bookName, int quantity, int quality) {
		for (int i = 0; i < quantity; i++) {
			Book newBook = new Book(bookName, quality);
			store.addBook(newBook);
		}
	}
}
