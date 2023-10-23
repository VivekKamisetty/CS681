package edu.umb.cs681.hw05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcessingTest {

    public static void main(String[] args) {
        String filePath = "src/edu/umb/cs681/hw05/csv/tmptabidrxv.csv";

        List<List<String>> csvData = DataProcessing.parseCSVFileToList(filePath);

        if (csvData != null) {
            // Stream to array conversion
            Stream<String> rowStream = csvData.get(0).stream();
            String[] rowArray = rowStream.toArray(String[]::new);
            System.out.println("Stream to array conversion:");
            System.out.println(Arrays.toString(rowArray));

            // Array to stream conversion
            Stream<String> arrayStream = Arrays.stream(rowArray);
            System.out.println("\nArray to stream conversion:");
            arrayStream.forEach(System.out::println);

            // List to stream conversion
            List<String> rowList = csvData.get(1); 
            Stream<String> listStream = rowList.stream();
            System.out.println("\nList to stream conversion:");
            listStream.forEach(System.out::println);

            // List to array conversion
            List<String> listToConvert = csvData.get(2); 
            String[] listToArray = listToConvert.toArray(new String[0]);
            System.out.println("\nList to array conversion:");
            System.out.println(Arrays.toString(listToArray));

            // Array to list conversion
            String[] arrayToConvert = csvData.get(3).toArray(new String[0]); 
            List<String> arrayToList = Arrays.asList(arrayToConvert);
            System.out.println("\nArray to list conversion:");
            System.out.println(arrayToList);
        }
    }
}