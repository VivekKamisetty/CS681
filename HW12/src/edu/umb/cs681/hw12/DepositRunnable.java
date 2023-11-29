package edu.umb.cs681.hw12;

public class DepositRunnable implements Runnable {

    private ThreadSafeBankAccount2 bankAccount;
    private volatile boolean done = false;

    public DepositRunnable(ThreadSafeBankAccount2 account) {
        this.bankAccount = account;
    }

    public void setDone() {
        done = true;
    }

    @Override
    public void run() {
        while (!done) {
            bankAccount.deposit(100); // Deposit a fixed amount

            // Introduce a short delay for demonstration purposes (not mandatory)
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getId() +
                " (d): Terminating the deposit thread gracefully.");
    }
}
