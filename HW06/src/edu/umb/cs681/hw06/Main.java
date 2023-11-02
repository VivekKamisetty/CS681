package edu.umb.cs681.hw06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	
	public static void main(String[] args) {
        Path path = Paths.get("eco_stats.csv");
        List<List<String>> matrix;
        List<AirportData> airportDataList = null;

        try (Stream<String> lines = Files.lines(path)) {
            matrix = lines.map(line -> Stream.of(line.split(","))
                    .map(value -> value.replaceAll("\"", ""))
                    .collect(Collectors.toList()))
                    .collect(Collectors.toList());

            airportDataList = matrix.stream().skip(1)
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

        Thread thread1 = new Thread(new Thread1(airportDataList));
        Thread thread2 = new Thread(new Thread2(airportDataList));
        Thread thread3 = new Thread(new Thread3(airportDataList));
        Thread thread4 = new Thread(new Thread4(airportDataList));
        Thread thread5 = new Thread(new Thread5(airportDataList));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        try {
//        	System.out.println("Before join thread1");
        	thread1.join();
//        	System.out.println("After join thread1");
//        	System.out.println("Before join thread2");
        	thread2.join();
//        	System.out.println("After join thread2");
//        	System.out.println("Before join thread3");
        	thread3.join();
//        	System.out.println("After join thread3");
//        	System.out.println("Before join thread4");
        	thread4.join();
//        	System.out.println("After join thread4");
//        	System.out.println("Before join thread5");
        	thread5.join();
//        	System.out.println("After join thread5");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
