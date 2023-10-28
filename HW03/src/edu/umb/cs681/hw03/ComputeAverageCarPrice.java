package edu.umb.cs681.hw03;
import java.util.LinkedList;

public class ComputeAverageCarPrice {
	
	public static void main(String[] args) {
		LinkedList<Car> carList = new LinkedList<Car>();
		   
		carList.add(new Car("Toyota", "RAV4", 35000, 2018, 10000f));
		carList.add(new Car("320i", "BMW", 40, 2018, 35000f));
		carList.add(new Car("A3", "Audi", 30, 2021, 40000f));
		carList.add(new Car("Acadia", "GMC", 45, 2017, 25000f));
		carList.add(new Car("Accord", "Honda", 50, 2016, 27000f));
		carList.add(new Car("Accent", "Hyundai", 53, 2013, 15000f));
		
		double averagePriceResult = carList.stream()
				.map(car -> car.getPrice())
				.reduce(new CarPriceResultHolder(), (result, price) -> {
					result.accumulate(price);
					return result;
				}, (finalResult, intermediateResult) -> finalResult
				).getAverage();

		System.out.println("Average car price: " + averagePriceResult);
	}

}
