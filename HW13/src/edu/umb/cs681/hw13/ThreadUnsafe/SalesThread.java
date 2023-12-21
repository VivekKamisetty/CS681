package edu.umb.cs681.hw13.ThreadUnsafe;

public class SalesThread implements Runnable{

	 private UnsafeItemInventory inventory;
	    private int soldQuantity;
	    private boolean done = false;

	    public SalesThread(UnsafeItemInventory inventory, int soldQuantity) {
	        this.inventory = inventory;
	        this.soldQuantity = soldQuantity;
	    }

	    public void setDone() {
	    	this.done = true;
	    }
	    
	    @Override
	    public void run() {
	        while(!done) {
	        	inventory.updateQuantity(soldQuantity);
	        }
	    }
}
