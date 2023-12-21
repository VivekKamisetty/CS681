package edu.umb.cs681.hw13.ThreadUnsafe;

public class UnsafeItemInventory {

	 private int availableQuantity;

	    public UnsafeItemInventory(int initialQuantity) {
	        this.availableQuantity = initialQuantity;
	    }

	    public int getAvailableQuantity() {
	        return availableQuantity;
	    }

	    public void updateQuantity(int soldQuantity) {
	        if (soldQuantity <= availableQuantity) {
	            availableQuantity -= soldQuantity;
	            System.out.println("Sold Quantity = " + soldQuantity + "Available Quantity = " + availableQuantity);
	        } else {
	            System.out.println("Not enough items available.");
	        }
	    }
}
