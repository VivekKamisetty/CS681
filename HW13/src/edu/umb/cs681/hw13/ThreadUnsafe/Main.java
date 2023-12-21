package edu.umb.cs681.hw13.ThreadUnsafe;

public class Main {

	 public static void main(String[] args) {
	        UnsafeItemInventory inventory = new UnsafeItemInventory(100000000);
	        SalesThread st1 = new SalesThread(inventory, 10);
	        SalesThread st2 = new SalesThread(inventory, 20);


	        Thread thread1 = new Thread(st1);
	        Thread thread2 = new Thread(st2);
	        Thread thread3 = new Thread(st1);
	        Thread thread4 = new Thread(st2);
	        Thread thread5 = new Thread(st1);
	        Thread thread6 = new Thread(st2);
	        Thread thread7 = new Thread(st1);

	        thread1.start();
	        thread2.start();
	        thread3.start();
	        thread4.start();
	        thread5.start();
	        thread6.start();
	        thread7.start();

	        
	            try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	            
	            st1.setDone();
	            st2.setDone();


	        System.out.println("Remaining Items: " + inventory.getAvailableQuantity());
	    }
}
