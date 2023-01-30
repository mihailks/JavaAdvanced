package SetsAndMapsAdvancedExercises;

import java.util.*;
import java.util.stream.Collectors;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> printSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            List<String> input = Arrays.stream(scanner.nextLine().split(" "))
                    .collect(Collectors.toList());
            printSet.addAll(input);
        }


        printSet.forEach(entry -> System.out.print(entry + " "));

    }
}
