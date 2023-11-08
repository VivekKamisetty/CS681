package edu.umb.cs681.hw04;

//import edu.umb.cs681.hw04.Distance;
//import edu.umb.cs681.hw04.DistanceMetric;
//import edu.umb.cs681.hw04.Manhattan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.List;
import java.util.Random;



public class DistanceTest {
    public static void main(String[] args) {
        int numPoints = 1000;
        int numDimensions = 100;
        List<List<Double>> points = generateRandomPoints(numPoints, numDimensions);

        System.out.println("Generated Points:");
        for (List<Double> point : points) {
            System.out.println(point);
        }

        // Generating distance matrix using Euclidean metric
        List<List<Double>> euclideanMatrix = calculateDistanceMatrix(points, new Euclidean());

        // Display Euclidean distance matrix
        System.out.println("\nEuclidean Distance Matrix:");
        for (List<Double> row : euclideanMatrix) {
            System.out.println(row);
        }

        List<List<Double>> manhattanMatrix = calculateDistanceMatrix(points, new Manhattan());

        // Display Manhattan distance matrix
        System.out.println("\nManhattan Distance Matrix:");
        for (List<Double> row : manhattanMatrix) {
            System.out.println(row);
        }
    }

    private static List<List<Double>> generateRandomPoints(int numPoints, int numDimensions) {
        List<List<Double>> points = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < numPoints; i++) {
            List<Double> point = new ArrayList<>();
            for (int j = 0; j < numDimensions; j++) {
                point.add((random.nextDouble() * 999));
            }
            points.add(point);
        }

        return points;
    }

    private static List<List<Double>> calculateDistanceMatrix(List<List<Double>> points, DistanceMetric metric) {
        int numOfPoints = points.size();
        List<List<Double>> distanceMatrix = new ArrayList<>();

        IntStream.range(0, numOfPoints).forEach(i -> {
            List<Double> row = new ArrayList<>();
            List<Double> current = points.get(i);

            IntStream.range(0, numOfPoints).forEach(j -> {
                List<Double> peer = points.get(j);
                double distance = calculateDistance(metric, current, peer);
                row.add(distance);
            });

            distanceMatrix.add(row);
        });

        return distanceMatrix;
    }

    private static double calculateDistance(DistanceMetric metric, List<Double> p1, List<Double> p2) {
        return metric.distance(p1, p2);
    }
}
