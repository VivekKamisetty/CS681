package edu.umb.cs681.ThreadSafe;

public class Main {
	
	  public static void main(String[] args) {
	        SafeItemInventory inventory = new SafeItemInventory(100000000);
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
	        
	        thread1.interrupt();
	        thread2.interrupt();
	        thread3.interrupt();
	        thread4.interrupt();
	        thread5.interrupt();
	        thread6.interrupt();
	        thread7.interrupt();

	        try {
	            thread1.join();
	            thread2.join();
	            thread3.join();
	            thread4.join();
	            thread5.join();
	            thread6.join();
	            thread7.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Remaining Items: " + inventory.getAvailableQuantity());
	    }

}
