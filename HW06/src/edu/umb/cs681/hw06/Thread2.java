package edu.umb.cs681.hw06;

import java.util.List;

public class Thread2 implements Runnable{

	private List<AirportData>  airportDataList;
	
	public Thread2(List<AirportData> airportDataList) {
		this.airportDataList = airportDataList;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 double maxUnemployment2013 = airportDataList.stream()
	                .filter(data -> data.getYear() == 2013)
	                .mapToDouble(AirportData::getUnemploymentRate)
	                .max()
	                .orElse(0.0);

	        double maxUnemployment2019 = airportDataList.stream()
	                .filter(data -> data.getYear() == 2019)
	                .mapToDouble(AirportData::getUnemploymentRate)
	                .max()
	                .orElse(0.0);
	        
	        System.out.println("Maximum unemp_rate in YEAR 2013: " + maxUnemployment2013);
	        System.out.println("Maximum unemp_rate in YEAR 2019: " + maxUnemployment2019);

	}

	
}