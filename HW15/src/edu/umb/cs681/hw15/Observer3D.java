package edu.umb.cs681.hw15;

import java.util.HashMap;
import java.util.Map;


public class Observer3D implements Observer<StockEvent> {
    private Map<String, Double> quotes = new HashMap<>();

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        quotes.put(event.ticker(), event.quote());
        System.out.println(String.format("3D visualization updated with quote %.2f for %s", event.quote(), event.ticker()));
    }

    public Map<String, Double> getQuotes() {
        return quotes;
    }
}