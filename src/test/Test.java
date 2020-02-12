package test;
import static org.junit.Assert.*;

import org.junit.Assert;

import customer.Customer;
import manager.Manager;
import store.Store;

public class Test {

	@org.junit.Test
	public void firstIteration() {
		Manager manager = new Manager("Peter");
		Store store = new Store(manager, "BookToHome");
		
		manager.buyBooks(store, "Rayuela", 4);
		manager.buyBooks(store, "El Aleph", 5);
		
		Assert.assertEquals(4, store.getStock("Rayuela"));
		Assert.assertEquals(5, store.getStock("El Aleph"));
	}

	@org.junit.Test
	public void secondIterationScenarioA() {
		Manager manager = new Manager("Peter");
		Store store = new Store(manager, "BookToHome");
		Customer customer = new Customer("Tom");
		
		manager.buyBooks(store, "Rayuela", 4);
		Assert.assertEquals(4, store.getStock("Rayuela"));
		
		customer.rentBook(store, "Rayuela");
		
		
		Assert.assertEquals(3, store.getStock("Rayuela"));
	}
	
	@org.junit.Test
	public void secondIterationScenarioB() {
		Manager manager = new Manager("Peter");
		Store store = new Store(manager, "BookToHome");
		Customer customer = new Customer("Tom");
		
		manager.buyBooks(store, "Rayuela", 4);
		customer.rentBook(store, "Rayuela");
		Assert.assertEquals(3, store.getStock("Rayuela"));
		
		Assert.assertTrue(customer.returnBook(store, "Rayuela")) ;
		Assert.assertEquals(4, store.getStock("Rayuela"));
	}
}
