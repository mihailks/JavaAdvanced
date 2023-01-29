package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> count = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            count.putIfAbsent(input[i], 0);
            count.put(input[i],count.get(input[i]) + 1);
        }

        for (Map.Entry<Double, Integer> entry : count.entrySet()){
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
