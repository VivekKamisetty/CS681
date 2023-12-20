package edu.umb.cs681.hw17;

import java.util.Random;

public class DataHandler implements Runnable {
    private Observable<StockEvent> observable;
    private volatile boolean running;

    public DataHandler(Observable<StockEvent> observable) {
        this.observable = observable;
        this.running = true;
    }

    public void stop() {
        this.running = false;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (running) {
            if (observable instanceof StackQuoteObservable) {
                StackQuoteObservable stackQuoteObservable = (StackQuoteObservable) observable;
                String ticker = generateRandomTicker(random);
                double quote = generateRandomQuote(random);
                stackQuoteObservable.changeQuote(ticker, quote);
            }
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private String generateRandomTicker(Random random) {
        return random.nextBoolean() ? "AAPL" : "GOOGL";
    }

    private double generateRandomQuote(Random random) {
        return 50 + random.nextDouble() * 100; // Random quote between 50 and 150
    }
}
