package edu.umb.cs681.ThreadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SafeItemInventory {

	 private int availableQuantity;
	    private final Lock lock = new ReentrantLock();

	    public SafeItemInventory(int initialQuantity) {
	        this.availableQuantity = initialQuantity;
	    }

	    public int getAvailableQuantity() {
	        return availableQuantity;
	    }


		public void updateQuantity(int soldQuantity) {
			lock.lock();
	        try {
	            if (soldQuantity <= availableQuantity) {
	                availableQuantity -= soldQuantity;
	                System.out.println("Sold Quantity = " + soldQuantity + " Available Quantity = " + availableQuantity);
	            } else {
	                System.out.println("Not enough items available.");
	            }
	        } finally {
	            lock.unlock();
	        }
			
		}
	
}
