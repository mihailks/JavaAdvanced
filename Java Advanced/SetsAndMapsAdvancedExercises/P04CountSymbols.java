package SetsAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> countMap = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            countMap.putIfAbsent(currentChar,0);
            countMap.put(currentChar, countMap.get(currentChar) + 1);
        }

        countMap.forEach((k,v)->{
            System.out.printf("%c: %d time/s%n",k,v);
        });

    }
}
