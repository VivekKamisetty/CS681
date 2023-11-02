package edu.umb.cs681.hw06;

import java.util.List;

public class Thread1 implements Runnable{

	private List<AirportData>  airportDataList;
	
	public Thread1(List<AirportData> airportDataList) {
		this.airportDataList = airportDataList;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		double averagePassengers2013 = airportDataList.stream()
				.filter(data -> data.getYear() == 2013)
                .mapToInt(AirportData::getLoganPassengers)
                .average()
                .orElse(0.0);
		
        System.out.println("Average logan_passengers in YEAR 2013: " + averagePassengers2013);
				
        double averagePassengers2019 = airportDataList.stream()
                .filter(data -> data.getYear() == 2019)
                .mapToInt(AirportData::getLoganPassengers)
                .average()
                .orElse(0.0);
        
        System.out.println("Average logan_passengers in YEAR 2019: " + averagePassengers2019);

	}

	
}
