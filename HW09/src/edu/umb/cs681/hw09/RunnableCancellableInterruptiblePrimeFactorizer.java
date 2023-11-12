package edu.umb.cs681.hw09;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableInterruptiblePrimeFactorizer extends RunnableCancellablePrimeFactorizer {

    private boolean done = false;
	private final ReentrantLock lock = new ReentrantLock();

    public RunnableCancellableInterruptiblePrimeFactorizer(long dividend, long from, long to) {
        super(dividend, from, to);
    }

    public void setDone() {
        lock.lock();
        try {
            done = true;
        } finally {
            lock.unlock();
        }
    }

    public void generatePrimeFactors() {
        long divisor = from;
        while (dividend != 1 && divisor <= to) {
            lock.lock();
            try {
                if (Thread.interrupted()) {
                    System.out.println("Thread #" + Thread.currentThread().getId() + " is interrupted.");
                    this.factors.clear();
                    break;
                }

                if (done) {
                    this.factors.clear();
                    break;
                }

                if (dividend % divisor == 0) {
                    this.factors.add(divisor);
                    dividend /= divisor;
                } else {
                    if (divisor == 2) {
                        divisor++;
                    } else {
                        divisor += 2;
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Factorization of 125 with one thread");
        RunnableCancellableInterruptiblePrimeFactorizer interruptibleFactorizer =
                new RunnableCancellableInterruptiblePrimeFactorizer(125, 2, (long) Math.sqrt(125));
        Thread interruptibleThread = new Thread(interruptibleFactorizer);
        interruptibleThread.start();
        interruptibleThread.interrupt();
        try {
            interruptibleThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final result: " + interruptibleFactorizer.getPrimeFactors() + "\n");

        System.out.println("Factorization of 24 with two threads");
        LinkedList<RunnablePrimeFactorizer> runnables = new LinkedList<RunnablePrimeFactorizer>();
        LinkedList<Thread> threads = new LinkedList<Thread>();

        runnables.add(new RunnablePrimeFactorizer(24, 2, (long) Math.sqrt(24) / 2));
        runnables.add(new RunnableCancellableInterruptiblePrimeFactorizer(24, 1 + (long) Math.sqrt(24) / 2, (long) Math.sqrt(24)));

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