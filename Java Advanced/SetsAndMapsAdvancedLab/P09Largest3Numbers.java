package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.sort(numbersList);
        Collections.reverse(numbersList);

        int limit = Math.min(numbersList.size(), 3);
        for (int i = 0; i < limit; i++) {
            System.out.print(numbersList.get(i) + " ");
        }
    }
}
