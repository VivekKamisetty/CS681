package edu.umb.cs681.hw02;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class VaccinationStats {

	private static List<Person> generateRandomPersons(int numPersons) {
		List<Person> persons = new ArrayList<>();
		
		for (int i = 0; i < numPersons; i++) {
			Random random = new Random();
			String firstName = "First" + i;
			String lastName = "Last" + i;
			LocalDate dob = LocalDate.of(1940 + random.nextInt(80), random.nextInt(12) + 1, 1);
			
			LinkedList<Dose> doses = new LinkedList<>();
			for (int j=0; j< random.nextInt(5); j++) {
				Dose dose = new Dose("Vaccine" + j, "Iot" + j, LocalDate.now().minusDays(random.nextInt(100)), "Site" + j);
				doses.add(dose);
			}
			
			Person person = new Person(firstName, lastName, dob, doses);
			persons.add(person);
		}
		
		return persons;
	}
	
	public static void main(String[] args) {
		List<Person> persons = generateRandomPersons(1000);
		
		Map<Object, Long> vaccinationRateByAgeCat = persons.stream()
				.collect(Collectors.groupingBy(person -> person.getAgeCat(), Collectors.counting()));
		System.out.println("Vaccination for each category: " + vaccinationRateByAgeCat);
		
		Map<Object, Double> avgVaccinationsByAgeCat = persons.stream()
				.collect(Collectors.groupingBy(person -> person.getAgeCat(), Collectors.averagingDouble(person -> person.getVacCount())));
		System.out.println("Average Vaccination for each category: " + avgVaccinationsByAgeCat);
		
		Map<Boolean, Double> avgAgeUnvaccinated = persons.stream()
				.collect(Collectors.partitioningBy(person -> person.getVacCount() == 0, Collectors.averagingInt(person -> person.getAge())));
		System.out.println("Average age of unvaccinated: " + avgAgeUnvaccinated);
		
	}
}
