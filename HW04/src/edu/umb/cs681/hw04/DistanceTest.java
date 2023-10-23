package edu.umb.cs681.hw04;

//import edu.umb.cs681.hw04.Distance;
//import edu.umb.cs681.hw04.DistanceMetric;
//import edu.umb.cs681.hw04.Euclidean;
//import edu.umb.cs681.hw04.Manhattan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DistanceTest {
    public static void main(String[] args) {
        int numPoints = 1000;
        int numDimensions = 100;
        List<List<Double> > points = generateRandomPoints(numPoints, numDimensions);

        // Test Euclidean distance for the first two points
        DistanceMetric euclidean = new Euclidean();
        double euclideanDistance = Distance.get(points.get(0), points.get(1), euclidean);
        System.out.println("Euclidean distance between the first two points: " + euclideanDistance);
//        System.out.println(euclideanDistance);

        // Test Manhattan distance for the first two points
        DistanceMetric manhattan = new Manhattan();
        double manhattanDistance = Distance.get(points.get(0), points.get(1), manhattan);
        System.out.println("Manhattan distance between the first two points: " + manhattanDistance);
        System.out.println(manhattanDistance);
    }

    private static List<List<Double>> generateRandomPoints(int numPoints, int numDimensions) {
        List<List<Double>> points = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < numPoints; i++) {
            List<Double> point = new ArrayList<>();
            for (int j = 0; j < numDimensions; j++) {
                point.add(random.nextDouble()); // Generated random values between 0 and 1
            }
            points.add(point);
        }

        return points;
    }
}
