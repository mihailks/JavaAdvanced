package FunctionalProgrammingExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] namesArr = scanner.nextLine().split(" ");

        Predicate<String> removeName = name -> name.length() <= n;

        Arrays.stream(namesArr)
                .filter(removeName)
                .forEach(System.out::println);
    }
}
