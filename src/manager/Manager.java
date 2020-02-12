package manager;

import readingMaterial.Book;
import readingMaterial.CollectorEdition;
import readingMaterial.Comic;
import readingMaterial.ReadingMaterial;
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
			store.addReadingMaterial((ReadingMaterial)newBook);
		}
	}
	public void buyComics(Store store, String comicName, int quantity, int quality) {
		for (int i = 0; i < quantity; i++) {
			Comic newCommic= new Comic(comicName, quality);
			store.addReadingMaterial((ReadingMaterial)newCommic);
		}
	}
	
	public void buyCollectorEdition(Store store, String collectorEditionName, int quantity) {
		for (int i = 0; i < quantity; i++) {
			CollectorEdition newCollectorEdition= new CollectorEdition(collectorEditionName);
			store.addReadingMaterial((ReadingMaterial)newCollectorEdition);
		}
	}
}
