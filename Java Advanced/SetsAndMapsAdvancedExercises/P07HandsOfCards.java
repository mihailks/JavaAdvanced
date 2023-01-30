package SetsAndMapsAdvancedExercises;

import java.util.*;
import java.util.stream.Collectors;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(": ");
        Map<String, Set<String>> playersCards = new LinkedHashMap<>();
        while (!input[0].equals("JOKER")) {

            String name = input[0];
            List<String> cardsList = Arrays.stream(input[1].split(", "))
                    .collect(Collectors.toList());

            playersCards.putIfAbsent(name, new HashSet<>());
            playersCards.get(name).addAll(cardsList);

            input = scanner.nextLine().split(": ");
        }
        playersCards.forEach((k, v) -> {
            List<String> card = new ArrayList<>(v);
            int sum = 0;
            for (int i = 0; i < card.size(); i++) {
                int first = 0;
                int second;
                if (card.get(i).length() == 2) {
                    int index = 1;
                    second = calculateSecond(card, i, index);

                    if (Character.isDigit(card.get(i).charAt(0))) {
                        first = Integer.parseInt(String.valueOf(card.get(i).charAt(0)));
                    } else {
                        if (card.get(i).charAt(0) == 'J') {
                            first = 11;
                        } else if (card.get(i).charAt(0) == 'Q') {
                            first = 12;
                        } else if (card.get(i).charAt(0) == 'K') {
                            first = 13;
                        } else if (card.get(i).charAt(0) == 'A') {
                            first = 14;
                        }
                    }
                    sum += first * second;

                } else {
                    int index = 2;
                    second = calculateSecond(card, i, index);
                    sum += 10 * second;
                }
            }
            System.out.printf("%s: %s%n", k, sum);
        });
    }

    private static int calculateSecond(List<String> card, int i, int index) {
        int second;
        if (card.get(i).charAt(index) == 'S') {
            second = 4;
        } else if (card.get(i).charAt(index) == 'H') {
            second = 3;
        } else if (card.get(i).charAt(index) == 'D') {
            second = 2;
        } else {
            second = 1;
        }
        return second;
    }
}
