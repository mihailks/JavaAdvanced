package SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> one = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> two = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Set<Integer> playerOne = new LinkedHashSet<>(one);
        Set<Integer> playerTwo = new LinkedHashSet<>(two);
        int counter = 0;

        while (!playerOne.isEmpty() && !playerTwo.isEmpty()) {
            counter++;
            if (counter >= 50) {
                break;
            }
            int currentCardOne = -1;
            int currentCardTwo = -1;
            for (Integer cardOne : playerOne) {
                currentCardOne = cardOne;
                break;
            }
            for (Integer cardTwo : playerTwo) {
                currentCardTwo = cardTwo;
                break;
            }

            playerOne.remove(currentCardOne);
            playerTwo.remove(currentCardTwo);

            if (currentCardOne > currentCardTwo) {
                playerOne.add(currentCardOne);
                playerOne.add(currentCardTwo);
            } else if (currentCardOne < currentCardTwo) {
                playerTwo.add(currentCardOne);
                playerTwo.add(currentCardTwo);

            }
        }
        if (playerOne.size() < playerTwo.size()) {
            System.out.println("Second player win!");
        } else if (playerTwo.size() < playerOne.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
