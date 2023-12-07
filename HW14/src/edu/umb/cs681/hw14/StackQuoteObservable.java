package edu.umb.cs681.hw14;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class StackQuoteObservable extends Observable<StockEvent> {
    private Map<String, Double> quotes = new HashMap<>();
    private ReentrantLock lockTQ = new ReentrantLock();
    private ReentrantLock lockObs = new ReentrantLock();

    public StackQuoteObservable() {
        lockTQ.lock();
    	try {
    	Map<String, Double> quotes = new HashMap<>();
        } finally {
        	lockTQ.unlock();
        }
    }

    public void changeQuote(String ticker, double quote) {
    	lockTQ.lock();
    	try {
    	quotes.put(ticker, quote);
    	} finally {
    		lockTQ.unlock();
    	}
    	
    	lockObs.lock();
    	try {
    	notifyObservers(new StockEvent(ticker, quote));	
    	} finally {
    		lockObs.unlock();
    	}
    }

    public Map<String, Double> getQuote() {
    	lockTQ.lock();
    	try {
    	return quotes;
    	} finally {
    		lockTQ.unlock();
    	}
    }
}