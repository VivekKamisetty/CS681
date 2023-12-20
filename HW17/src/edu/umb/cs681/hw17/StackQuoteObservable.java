package edu.umb.cs681.hw17;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class StackQuoteObservable extends Observable<StockEvent> {
    private Map<String, Double> quotes = new HashMap<>();


    public StackQuoteObservable() {

    	Map<String, Double> quotes = new HashMap<>();

    }

    public void changeQuote(String ticker, double quote) {

    	quotes.put(ticker, quote);

    	

    	notifyObservers(new StockEvent(ticker, quote));	

    }

    public Map<String, Double> getQuote() {

    	return quotes;

    }
}