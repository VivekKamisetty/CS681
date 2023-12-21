package edu.umb.cs681.ThreadSafe;

public class SalesThread implements Runnable{

	  private SafeItemInventory inventory;
	    private int soldQuantity;
	    private volatile boolean done = false;

	    public SalesThread(SafeItemInventory inventory, int soldQuantity) {
	        this.inventory = inventory;
	        this.soldQuantity = soldQuantity;
	    }

	    public void setDone() {
	        this.done = true;
	    }

	    @Override
	    public void run() {
	        while (!done) {
	            inventory.updateQuantity(soldQuantity);
	            try {
	                Thread.sleep(100);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	        
	    }
	
}
