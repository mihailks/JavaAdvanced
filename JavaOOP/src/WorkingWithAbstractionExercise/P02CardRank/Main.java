package WorkingWithAbstractionExercise.P02CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        CardRank[] cardRanks = CardRank.values();
        System.out.println(input + ":");
        for (CardRank cardRank : cardRanks) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", cardRank.getCardRank(), cardRank);
        }
    }
}
