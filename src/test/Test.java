package test;

import static org.junit.Assert.*;

import org.junit.Assert;

import customer.Customer;
import manager.Manager;
import readingMaterial.Book;
import readingMaterial.CollectorEdition;
import readingMaterial.Comic;
import store.Store;

public class Test {

	@org.junit.Test
	public void firstIteration() {
		Manager manager = new Manager("Peter");
		Store store = new Store(manager, "BookToHome");

		manager.buyBooks(store, "Rayuela", 4, 10);
		manager.buyBooks(store, "El Aleph", 5, 10);

		Assert.assertEquals(4, store.getStock("Rayuela"));
		Assert.assertEquals(5, store.getStock("El Aleph"));
	}

	@org.junit.Test
	public void secondIterationScenarioA() {
		Manager manager = new Manager("Peter");
		Store store = new Store(manager, "BookToHome");
		Customer customer = new Customer("Tom");

		manager.buyBooks(store, "Rayuela", 4, 10);
		Assert.assertEquals(4, store.getStock("Rayuela"));

		customer.rentBook(store, "Rayuela");

		Assert.assertEquals(3, store.getStock("Rayuela"));
	}

	@org.junit.Test
	public void secondIterationScenarioB() {
		Manager manager = new Manager("Peter");
		Store store = new Store(manager, "BookToHome");
		Customer customer = new Customer("Tom");

		manager.buyBooks(store, "Rayuela", 4, 10);
		customer.rentBook(store, "Rayuela");
		Assert.assertEquals(3, store.getStock("Rayuela"));

		Assert.assertTrue(customer.returnBook(store, "Rayuela"));
		Assert.assertEquals(4, store.getStock("Rayuela"));
	}

	@org.junit.Test
	public void thirdIteration() {
		System.out.println("Third iteration");
		Book newBook = new Book("Rayuela", 5);
		newBook.getTimeLeft();
		
		Manager manager = new Manager("Peter");
		Store store = new Store(manager, "BookToHome");
		
		manager.buyBooks(store, "Rayuela", 4, 0);
		Assert.assertEquals(4, store.getStock("Rayuela"));
		
		store.removeOldMaterial();
		
		Assert.assertEquals(0, store.getStock("Rayuela"));
		System.out.println();
	}
	
	@org.junit.Test
	public void fourthIteration() {
		System.out.println("Fourth iteration");
		Book newBook = new Book("Angel", 6);
		newBook.getTimeLeft();
		
		Comic newComic = new Comic("Robin", 6);
		newComic.getTimeLeft(); 
		
		Assert.assertNotEquals(newBook.getQuality(), newComic.getQuality());
		System.out.println();
	}
	
	@org.junit.Test
	public void fifthIteration() {
		System.out.println("Fifth iteration");
		//Uso otro constructor que tiene una fecha fija, para demostrar que suma su calidad por dia
		CollectorEdition newCollectorEdition = new CollectorEdition("Deadlock", "test");
		Assert.assertTrue(newCollectorEdition.getQuality()>0);
		System.out.println("Quality: "+newCollectorEdition.getQuality());
		
		System.out.println();
		
		Manager manager = new Manager("Peter");
		Store store = new Store(manager, "BookToHome");
		
		CollectorEdition newCollectorEdition2 = new CollectorEdition("Deadlock");
		Assert.assertTrue(newCollectorEdition2.getQuality()==0);
		System.out.println("Quality: "+newCollectorEdition2.getQuality());
		
		manager.buyCollectorEdition(store, "Rayuela", 4);
		Assert.assertEquals(4, store.getStock("Rayuela"));
		store.removeOldMaterial();
		Assert.assertEquals(4, store.getStock("Rayuela"));
		
		System.out.println();
	}
	
	@org.junit.Test
	public void sixthIteration() {
		System.out.println("Sixth iteration");
		Manager manager = new Manager("Peter");
		Store store = new Store(manager, "BookToHome");
		
		manager.buyBooks(store, "Rayuela", 2, 10);
		manager.buyBooks(store, "El Tunel", 2, 10);
		manager.buyBooks(store, "El Aleph", 10, 10);
		manager.minimumStock(store);
		
		
		System.out.println();
	}
}
