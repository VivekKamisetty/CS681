package edu.umb.cs681.hw03;

public class CarPriceResultHolder {
	
	private int numCarExamined;
	private double average;

	public CarPriceResultHolder() {
		this.numCarExamined = 0;
		this.average = 0;
	}
	
	public void accumulate(double price) {
		numCarExamined++;
		double totalPrice = (numCarExamined - 1)*average+price;
		average = totalPrice/this.numCarExamined;
	}
	
	public void combine(CarPriceResultHolder result) {
		this.numCarExamined += result.numCarExamined;
		this.average = (this.average * result.average + this.average * this.numCarExamined)/numCarExamined;
	}
	
	public double getAverage() {
		return this.average;
	}
	
}
