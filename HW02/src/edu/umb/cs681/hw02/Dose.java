package edu.umb.cs681.hw02;
import java.time.LocalDate;

public class Dose {
	
	private String vacProductName;
	private String iotNumber;
	private LocalDate date;
	private String vacSite;
	
//	public Dose(String vacProductName, String iotNumber, LocalDate date, String vacSite) {
//		this.vacProductName = vacProductName;
//		this.iotNumber = iotNumber;
//		this.date = date;
//		this.vacSite = vacSite;
//	}
	
	public Dose(String vacProductName, String iotNumber, LocalDate date, String vacSite) {
		// TODO Auto-generated constructor stub
		this.vacProductName = vacProductName;
		this.iotNumber = iotNumber;
		this.date = date;
		this.vacSite = vacSite;
	}

	public String getVacProductName() {
		return vacProductName;
	}
	
	public String getIotNumber() {
		return iotNumber;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public String getVacSite() {
		return vacSite;
	}
}
