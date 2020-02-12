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
	
	public void minimumStock(Store store) {
		int r = 0;
		int t = 0;
		int a = 0;
		for (ReadingMaterial stock : store.getBooks()) {
			if(stock.getName()=="Rayuela") {
				r +=1;
			} else if(stock.getName()=="El Tunel") {
				t +=1;
			} else if(stock.getName()=="El Aleph") {
				a +=1;
			}
		}
		if(r<4)System.out.println(4-r + " units of \"Rayuela\" needed to have minimun stock");
		if(t<4)System.out.println(3-t + " units of \"El Tunel\" needed to have minimun stock");
		if(a<4)System.out.println(2-a + " units of \"El Aleph\" needed to have minimun stock");
	}
}
