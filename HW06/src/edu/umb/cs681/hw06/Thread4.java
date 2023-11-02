package edu.umb.cs681.hw06;

import java.util.List;

public class Thread4 implements Runnable{

	private List<AirportData>  airportDataList;
	
	public Thread4(List<AirportData> airportDataList) {
		this.airportDataList = airportDataList;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 double avgTotalJobs2013 = airportDataList.stream()
	                .filter(data -> data.getYear() == 2013)
	                .mapToDouble(AirportData::getTotalJobs)
	                .average()
	                .orElse(0.0);

	        double avgTotalJobs2019 = airportDataList.stream()
	                .filter(data -> data.getYear() == 2019)
	                .mapToDouble(AirportData::getTotalJobs)
	                .average()
	                .orElse(0.0);
	        
	        System.out.println("Average total_jobs in YEAR 2013: " + avgTotalJobs2013);
	        System.out.println("Average total_jobs in YEAR 2019: " + avgTotalJobs2019);

	}

	
}