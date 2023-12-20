package edu.umb.cs681.hw17;

import java.util.HashMap;
import java.util.Map;

public class LineChartObserver implements Observer<StockEvent> {
    private Map<String, Double> quotes = new HashMap<>();

    @Override
    public void update(Observable<StockEvent> sender, StockEvent event) {
        quotes.put(event.ticker(), event.quote());
        System.out.println(String.format("Line chart updated for %s with quote %.2f", event.ticker(), event.quote()));
    }

    public Map<String, Double> getQuotes() {
        return quotes;
    }
}
