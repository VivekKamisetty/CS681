package edu.umb.cs681.hw12;

public class WithdrawRunnable implements Runnable {

    private ThreadSafeBankAccount2 bankAccount;
    private volatile boolean done = false;

    public WithdrawRunnable(ThreadSafeBankAccount2 account) {
        this.bankAccount = account;
    }

    public void setDone() {
        done = true;
    }

    @Override
    public void run() {
        while (!done) {
            bankAccount.withdraw(100);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getId() +
                " (w): Terminating the withdraw thread gracefully.");
    }
}
