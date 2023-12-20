package edu.umb.cs681.hw12;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class ThreadSafeBankAccount2 implements BankAccount{
	private double balance = 0;
	private ReentrantLock lock = new ReentrantLock();
	private Condition sufficientFundsCondition = lock.newCondition();
	private Condition belowUpperLimitFundsCondition = lock.newCondition();
	private volatile boolean done = false;

	public void deposit(double amount){
		lock.lock();
		try{
			System.out.println("Lock obtained");
			System.out.println(Thread.currentThread().threadId() +
					" (d): current balance: " + balance);
			while(balance >= 300){
				System.out.println(Thread.currentThread().threadId() +
						" (d): await(): Balance exceeds the upper limit.");
				belowUpperLimitFundsCondition.await();
			}
			balance += amount;
			System.out.println(Thread.currentThread().threadId() +
					" (d): new balance: " + balance);
			sufficientFundsCondition.signalAll();
			
			if (done) {
                System.out.println(Thread.currentThread().threadId() +
                        " (d): Terminating the deposit thread gracefully.");
                return; // Terminate the thread if done flag is set
                
		}
	}
		catch (InterruptedException exception){
			exception.printStackTrace();
		}
		finally{
			lock.unlock();
			System.out.println("Lock released");
		}
	}

	public void withdraw(double amount){
		lock.lock();
		try{
			System.out.println("Lock obtained");
			System.out.println(Thread.currentThread().threadId() +
					" (w): current balance: " + balance);
			while(balance <= 0){
				System.out.println(Thread.currentThread().threadId() +
						" (w): await(): Insufficient funds");
				sufficientFundsCondition.await();
			}
			balance -= amount;
			System.out.println(Thread.currentThread().threadId() +
					" (w): new balance: " + balance);
			belowUpperLimitFundsCondition.signalAll();
			
			if (done) {
                System.out.println(Thread.currentThread().threadId() +
                        " (w): Terminating the withdraw thread gracefully.");
                return; // Terminate the thread if done flag is set
            }
		}
		catch (InterruptedException exception){
			exception.printStackTrace();
		}
		finally{
			lock.unlock();
			System.out.println("Lock released");
		}
	}

	 public static void main(String[] args) {
	        ThreadSafeBankAccount2 bankAccount = new ThreadSafeBankAccount2();
	        WithdrawRunnable[] withdrawThreads = new WithdrawRunnable[5];
	        DepositRunnable[] depositThreads = new DepositRunnable[5];

	        for (int i = 0; i < 5; i++) {
	            withdrawThreads[i] = new WithdrawRunnable(bankAccount);
	            depositThreads[i] = new DepositRunnable(bankAccount);
	            new Thread(withdrawThreads[i]).start();
	            new Thread(depositThreads[i]).start();
	        }

	        // Let the threads run for some time (simulating prsocessing)
	        try {
	            Thread.sleep(2000); // Adjust this value as needed
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        // Terminate the threads
	        for (int i = 0; i < 5; i++) {
	            withdrawThreads[i].setDone();
	            depositThreads[i].setDone();
	        }
	    }

	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
	}
