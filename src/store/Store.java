package store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exception.NotFoundException;
import interfaces.GetBookByNameInterface;
import manager.Manager;
import readingMaterial.Book;
import readingMaterial.CollectorEdition;
import readingMaterial.ReadingMaterial;

public class Store implements GetBookByNameInterface{
	
	private String name;
	private List<ReadingMaterial> readingMaterial;
	private List<ReadingMaterial> rentedMaterial;
	private Manager manager;

	public Store(Manager manager, String name) {
		this.name = name;
		this.manager = manager;
		this.readingMaterial = new ArrayList<ReadingMaterial>();
		this.rentedMaterial = new ArrayList<ReadingMaterial>();	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ReadingMaterial> getBooks() {
		return readingMaterial;
	}

	public void setBooks(List<ReadingMaterial> books) {
		this.readingMaterial = books;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<ReadingMaterial> getRentedBooks() {
		return rentedMaterial;
	}

	public void setRentedBooks(List<ReadingMaterial> rentedBooks) {
		this.rentedMaterial = rentedBooks;
	}

	public void addReadingMaterial(ReadingMaterial newBook) {
		readingMaterial.add(newBook);
	}

	public int getStock(String readingName) {
		int aux = 0;
		for (ReadingMaterial readingObject : readingMaterial) {
			if (readingObject.getName() == readingName)
				aux++;
		}
		return aux;
	}

	public ReadingMaterial getBookByName(String bookName) throws NotFoundException {
		for (ReadingMaterial readingObject : readingMaterial) {
			if (readingObject.getName() == bookName)
				return readingObject;
		}
		throw new NotFoundException("Book not found");
	}

	public ReadingMaterial rentBook(String bookName) throws NotFoundException {
		ReadingMaterial rentedBook = getBookByName(bookName);
		readingMaterial.remove(rentedBook);
		rentedMaterial.add(rentedBook);
		return rentedBook;
	}

	public Boolean returnBook(ReadingMaterial returnedBook) {
		if(rentedMaterial.contains(returnedBook)) {
			rentedMaterial.remove(returnedBook);
			readingMaterial.add(returnedBook);
			return true;
		} else {
			return false;
		}
	}
	public void removeOldMaterial() {
		Iterator<ReadingMaterial> itBooks = readingMaterial.iterator();
			while(itBooks.hasNext()) {
				ReadingMaterial material = itBooks.next();
				if(!(material instanceof CollectorEdition) && material.getQuality()<=0){
					itBooks.remove();
				}

				/*
				int quality= itBooks.next().getQuality();
				if(quality <= 0) {
					itBooks.remove();
				}*/
			}
	}
}
