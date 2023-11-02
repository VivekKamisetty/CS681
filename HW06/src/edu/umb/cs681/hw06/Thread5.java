package edu.umb.cs681.hw06;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Thread5 implements Runnable{

	private List<AirportData>  airportDataList;
	
	public Thread5(List<AirportData> airportDataList) {
		this.airportDataList = airportDataList;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		List<Integer> yearsByUnemployment = airportDataList.stream()
                .collect(Collectors.groupingBy(AirportData::getYear,
                        Collectors.averagingDouble(AirportData::getUnemploymentRate)))
                .entrySet().stream()
                .sorted(Comparator.comparingDouble(entry -> entry.getValue()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
	        
		 	System.out.println("Years in ascending order of unemployment rate:");
	        yearsByUnemployment.forEach(System.out::println);

	}

	
}