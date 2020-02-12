package test;
import static org.junit.Assert.*;

import org.junit.Assert;

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

}
