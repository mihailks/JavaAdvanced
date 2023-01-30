package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        int first = Integer.parseInt(size[0]);
        int second = Integer.parseInt(size[1]);

        Set<Integer> one = new LinkedHashSet<>();
        Set<Integer> two = new LinkedHashSet<>();

        for (int i = 0; i < first; i++) {
            one.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < second; i++) {
            two.add(Integer.parseInt(scanner.nextLine()));
        }
        one.retainAll(two);
        one.forEach(entry -> System.out.print(entry + " "));
    }
}
