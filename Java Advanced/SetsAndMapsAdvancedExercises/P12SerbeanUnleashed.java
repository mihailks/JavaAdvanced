package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P12SerbeanUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();


        LinkedHashMap<String, LinkedHashMap<String, Integer>> cityMap = new LinkedHashMap<>();

        while (!input.equals("End")) {

            if (!input.contains("@") || input.charAt(input.indexOf("@") - 1) != ' ') {
                input = scanner.nextLine();
                continue;
            }

            String singer = input.substring(0, input.indexOf("@") - 1);
            int startNumberIndex = 0;

            for (int i = input.indexOf("@"); i < input.length(); i++) {
                char currentSymbol = input.charAt(i);
                if (Character.isDigit(currentSymbol) && input.charAt(i - 1) == ' ') {
                    startNumberIndex = i;
                    break;
                }
            }

            if (startNumberIndex == 0) {
                input = scanner.nextLine();
                continue;
            }

            String city = input.substring(input.indexOf("@") + 1, startNumberIndex - 1);
            String numbers = input.substring(startNumberIndex);
            String[] numbersArray = numbers.split("\\s+");
            if (numbersArray.length != 2) {
                input = scanner.nextLine();
                continue;
            }
            int price = Integer.parseInt(numbersArray[0]);
            int capacity = Integer.parseInt(numbersArray[1]);


            if (!cityMap.containsKey(city)) {
                LinkedHashMap<String, Integer> singers = new LinkedHashMap<>();
                singers.put(singer, price * capacity);
                cityMap.put(city, singers);
            } else {
                LinkedHashMap<String, Integer> currentSingers = cityMap.get(city);
                if (currentSingers.containsKey(singer)) {
                    currentSingers.put(singer, currentSingers.get(singer) + price * capacity);
                } else {
                    currentSingers.put(singer, price * capacity);
                }

                cityMap.put(city, currentSingers);
            }
            input = scanner.nextLine();
        }

        for (String place : cityMap.keySet()) {
            System.out.println(place);

            LinkedHashMap<String, Integer> singers = cityMap.get(place);

            singers.entrySet().stream().sorted((singer1, singer2) -> singer2.getValue().compareTo(singer1.getValue()))
                    .forEach(singer -> System.out.println(String.format("#  %s -> %d", singer.getKey(), singer.getValue())));
        }
    }
}
