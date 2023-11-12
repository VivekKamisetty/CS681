package edu.umb.cs681.hw07_1;


public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {
	
	public RunnablePrimeGenerator(long from, long to) {
		super(from, to);
	}
	
	public void run() {
		generatePrimes();
	}

	public static void main(String[] args) throws InterruptedException {

	        RunnableCancellablePrimeGenerator gen1 = new RunnableCancellablePrimeGenerator(1, 20);
	        RunnableCancellablePrimeGenerator gen2 = new RunnableCancellablePrimeGenerator(21, 40);
	        RunnableCancellablePrimeGenerator gen3 = new RunnableCancellablePrimeGenerator(41, 61);

	        Thread thread1 = new Thread(gen1);
	        Thread thread2 = new Thread(gen2);
	        Thread thread3 = new Thread(gen3);

	        thread1.start();
	        thread2.start();
	        thread3.start();

	        thread1.join();
	        thread2.join();
	        thread3.join();

	        System.out.println("Generated prime numbers (Thread 1): " + gen1.getPrimes());
	        System.out.println("Generated prime numbers (Thread 2): " + gen2.getPrimes());
	        System.out.println("Generated prime numbers (Thread 3): " + gen3.getPrimes());
	   
	}
}
