package edu.umb.cs681.hw05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataProcessing {

    public static List<List<String>> parseCSVFileToList(String filePath) {
        Path path = Paths.get(filePath);
        try (Stream<String> lines = Files.lines(path)) {
            return lines.map(line -> {
                return Stream.of(line.split(","))
                        .map(value -> value.replaceAll("\"", "").trim())
                        .collect(Collectors.toList());
            }).collect(Collectors.toList());
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String[] listToArray(List<String> list) {
        return list.toArray(new String[0]);
    }

    public static List<String> arrayToList(String[] arr) {
        return Arrays.asList(arr);
    }
}