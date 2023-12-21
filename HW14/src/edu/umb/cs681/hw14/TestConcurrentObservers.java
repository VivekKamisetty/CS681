package edu.umb.cs681.hw14;

import java.util.ArrayList;
import java.util.List;

public class TestConcurrentObservers {
	
	 public static void main(String[] args) {
	        StackQuoteObservable observable = new StackQuoteObservable();
	        TableObserver tableObserver = new TableObserver();
	        LineChartObserver lineChartObserver = new LineChartObserver();
	        Observer3D observer3D = new Observer3D();

	        observable.addObserver(tableObserver);
	        observable.addObserver(lineChartObserver);
	        observable.addObserver(observer3D);

	        int numThreads = 10;

	        List<Thread> threads = new ArrayList<>();
	        List<DataHandler> dataHandlers = new ArrayList<>();

	        for (int i = 0; i < numThreads; i++) {
	            DataHandler dataHandler = new DataHandler(observable);
	            dataHandlers.add(dataHandler);
	            Thread thread = new Thread(dataHandler);
	            threads.add(thread);
	            thread.start();
	        }

	        try {
	            Thread.sleep(10000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        for (DataHandler handler : dataHandlers) {
	            handler.stop();
	        }

	        for (Thread thread : threads) {
	            try {
	                thread.join();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

}
