package edu.umb.cs681.hw06;

import java.util.List;

public class Thread3 implements Runnable{

	private List<AirportData>  airportDataList;
	
	public Thread3(List<AirportData> airportDataList) {
		this.airportDataList = airportDataList;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		double averageOccupancy2013 = airportDataList.stream()
                .filter(data -> data.getYear() == 2013)
                .mapToDouble(AirportData::getHotelOccupancyRate)
                .average()
                .orElse(0.0);

        double averageOccupancy2019 = airportDataList.stream()
                .filter(data -> data.getYear() == 2019)
                .mapToDouble(AirportData::getHotelOccupancyRate)
                .average()
                .orElse(0.0);
	        
        System.out.println("Average hotel_occup_rate in YEAR 2013: " + averageOccupancy2013);
        System.out.println("Average hotel_occup_rate in YEAR 2019: " + averageOccupancy2019);

	}

	
}