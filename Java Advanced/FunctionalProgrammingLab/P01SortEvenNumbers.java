package FunctionalProgrammingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(", "))
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());

        numbersList.removeIf(number -> number % 2 != 0);

        System.out.println(numbersList.toString().replaceAll("[\\[\\]]", ""));

        //numbersList.stream().sorted((l,r)->l.compareTo(r));
//        List<Integer> sortedNumbersList = numbersList
//                .stream()
//                .sorted()
//                .collect(Collectors.toList());

        List <String> temp = numbersList
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", temp));

    }
}

