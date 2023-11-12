package edu.umb.cs681.hw07_2;


import java.util.LinkedList;

// Generates prime factors of a given number (dividend)
// Factorization is performed in the range of 2 and Math.sqrt(dividend)
//
// When only one thread is used for factorization, create a Runnable as follows:
//     new RunnablePrimeFactorizer(dividend, 2, (long)Math.sqrt(dividend));
// The thread performs factorization for the entire range of 2 and sqrt(dividend). 
//
// When two threads are used for factorization, create two Runnables as follows:
//     new RunnablePrimeFactorizer(dividend, 2, (long)Math.sqrt(dividend)/2);
//     new RunnablePrimeFactorizer(dividend, 1+(long)Math.sqrt(dividend)/2, (long)Math.sqrt(dividend));

public class RunnablePrimeFactorizer extends PrimeFactorizer implements Runnable {
	
	public RunnablePrimeFactorizer(long dividend, long from, long to) {
		super(dividend);
		if (from >= 2 && to >= from) {
			this.from = from;
			this.to = to;
		} else {
			throw new RuntimeException(
				"from must be >= 2, and to must be >= from." + "from==" + from + " to==" + to);
		}
	}
	
	protected boolean isEven(long n){
		if(n%2 == 0){ return true; }
		else{ return false; }
	}

	public void generatePrimeFactors() {
		long divisor = from;
	    while( dividend != 1 && divisor <= to ){
	    	if( divisor > 2 && isEven(divisor)) {
	    		divisor+=2;
	    		continue;
	    	}
		    if(dividend % divisor == 0) {
		        factors.add(divisor);
		        dividend /= divisor;
		    }else {
		    	if(divisor==2){ divisor++; }
		    	else{ divisor += 2; }
		    }
		}
	}
	
	public void run() {
		generatePrimeFactors();
		System.out.println("Thread #" + Thread.currentThread().threadId() + " generated " + factors);
	}

	public static void main(String[] args) {

		    System.out.println("Factorization of 125 with one thread");
		    RunnablePrimeFactorizer singleThreadFactorizer2 = new RunnablePrimeFactorizer(125, 2, (long) Math.sqrt(125));
		    Thread singleThread2 = new Thread(singleThreadFactorizer2);
		    singleThread2.start();
		    try {
		        singleThread2.join();
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		    System.out.println("Final result: " + singleThreadFactorizer2.getPrimeFactors() + "\n");


		    System.out.println("Factorization of 24 with two threads");
		    LinkedList<RunnablePrimeFactorizer> runnables = new LinkedList<RunnablePrimeFactorizer>();
		    LinkedList<Thread> threads = new LinkedList<Thread>();

		    runnables.add(new RunnablePrimeFactorizer(24, 2, (long) Math.sqrt(24) / 2));
		    runnables.add(new RunnablePrimeFactorizer(24, 1 + (long) Math.sqrt(24) / 2, (long) Math.sqrt(24)));

		    for (RunnablePrimeFactorizer r : runnables) {
		        Thread t = new Thread(r);
		        threads.add(t);
		        t.start();
		    }

		    for (Thread t : threads) {
		        try {
		            t.join();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }

		    LinkedList<Long> factors = new LinkedList<Long>();
		    for (RunnablePrimeFactorizer r : runnables) {
		        factors.addAll(r.getPrimeFactors());
		    }
		    System.out.println("Final result: " + factors);
}
}
