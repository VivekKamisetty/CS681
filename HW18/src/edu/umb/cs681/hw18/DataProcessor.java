package edu.umb.cs681.hw18;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class DataProcessor {

	public static void main(String[] args) {
        Path path = Paths.get("eco_stats.csv");

        List<List<String>> matrix;
        List<AirportData> airportDataList = null;

        try (Stream<String> lines = Files.lines(path)) {
            matrix = lines.parallel().map(line -> Stream.of(line.split(","))
                    .map(value -> value.replaceAll("\"", "")) 
                    .collect(Collectors.toList()))
                    .collect(Collectors.toList());

            airportDataList = matrix.stream().parallel().skip(1) 
                    .map(data -> new AirportData(
                            Integer.parseInt(data.get(0)),
                            Integer.parseInt(data.get(1)),
                            Integer.parseInt(data.get(2)),
                            Integer.parseInt(data.get(3)),
                            Float.parseFloat(data.get(4)),
                            Float.parseFloat(data.get(5)),
                            Integer.parseInt(data.get(6)),
                            Float.parseFloat(data.get(7)),
                            Float.parseFloat(data.get(8))
                    ))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        double averagePassengers2013 = airportDataList.stream()
        		.parallel()
                .filter(data -> data.getYear() == 2013)
                .mapToInt(AirportData::getLoganPassengers)
                .average()
                .orElse(0.0);

        double averagePassengers2019 = airportDataList.stream()
        		.parallel()
                .filter(data -> data.getYear() == 2019)
                .mapToInt(AirportData::getLoganPassengers)
                .average()
                .orElse(0.0);

        double maxUnemployment2013 = airportDataList.stream()
        		.parallel()
                .filter(data -> data.getYear() == 2013)
                .mapToDouble(AirportData::getUnemploymentRate)
                .max()
                .orElse(0.0);

        double maxUnemployment2019 = airportDataList.stream()
        		.parallel()
                .filter(data -> data.getYear() == 2019)
                .mapToDouble(AirportData::getUnemploymentRate)
                .max()
                .orElse(0.0);

        double averageOccupancy2013 = airportDataList.stream()
        		.parallel()
                .filter(data -> data.getYear() == 2013)
                .mapToDouble(AirportData::getHotelOccupancyRate)
                .average()
                .orElse(0.0);

        double averageOccupancy2019 = airportDataList.stream()
        		.parallel()
                .filter(data -> data.getYear() == 2019)
                .mapToDouble(AirportData::getHotelOccupancyRate)
                .average()
                .orElse(0.0);

        double avgTotalJobs2013 = airportDataList.stream()
        		.parallel()
                .filter(data -> data.getYear() == 2013)
                .mapToDouble(AirportData::getTotalJobs)
                .average()
                .orElse(0.0);

        double avgTotalJobs2019 = airportDataList.stream()
        		.parallel()
                .filter(data -> data.getYear() == 2019)
                .mapToDouble(AirportData::getTotalJobs)
                .average()
                .orElse(0.0);
        
        List<Integer> yearsByUnemployment = airportDataList.stream()
        		.parallel()
                .collect(Collectors.groupingBy(AirportData::getYear,
                        Collectors.averagingDouble(AirportData::getUnemploymentRate)))
                .entrySet().stream()
                .sorted(Comparator.comparingDouble(entry -> entry.getValue()))
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        

        System.out.println("Average logan_passengers in YEAR 2013: " + averagePassengers2013);
        System.out.println("Average logan_passengers in YEAR 2019: " + averagePassengers2019);
        System.out.println("Maximum unemp_rate in YEAR 2013: " + maxUnemployment2013);
        System.out.println("Maximum unemp_rate in YEAR 2019: " + maxUnemployment2019);
        System.out.println("Average hotel_occup_rate in YEAR 2013: " + averageOccupancy2013);
        System.out.println("Average hotel_occup_rate in YEAR 2019: " + averageOccupancy2019);
        System.out.println("Average total_jobs in YEAR 2013: " + avgTotalJobs2013);
        System.out.println("Average total_jobs in YEAR 2019: " + avgTotalJobs2019);
        System.out.println("Years in ascending order of unemployment rate:");
        yearsByUnemployment.forEach(System.out::println);
    }
}