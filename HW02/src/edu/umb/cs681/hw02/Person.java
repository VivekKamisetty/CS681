package edu.umb.cs681.hw02;
import java.time.LocalDate;
import java.util.LinkedList;

public class Person {

	private String firstName;
	private String lastName;
	private LocalDate dob;
	private LinkedList<Dose> doses;
	
//	public Person(String firstName, String lastName, LocalDate dob, LinkedList<Dose> doses) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.dob = dob;
//		this.doses = doses;
//	}
	
	public Person(String firstName, String lastName, LocalDate dob, LinkedList<Dose> dosess) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.doses = dosess;
	}
	
	public int getAge() {
		LocalDate currentDate = LocalDate.now();
		return currentDate.getYear() - dob.getYear();
	}
	
	public AgeCat getAgeCat() {
		int age = getAge();
		if (age >= 60) {
			return AgeCat.OLD;
		}
		else if (age >= 30) {
			return AgeCat.MID;
		}
		else {
			return AgeCat.YOUNG;
		}
			
	}
	
	public LinkedList<Dose> getDoses() {
		return doses;
	}
	
	public int getVacCount() {
		return doses.size();
	}
	
}
