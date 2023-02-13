package IteratorsAndComparatorsExercises.P04Froggy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lake lake = new Lake(numbers);

        List<String> result = new ArrayList<>();

        lake.forEach(element -> result.add(String.valueOf(element)));

        System.out.println(String.join(", ", result));

    }
}