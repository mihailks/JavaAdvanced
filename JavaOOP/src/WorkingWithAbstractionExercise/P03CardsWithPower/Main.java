package WorkingWithAbstractionExercise.P03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardRank_03 cardRank_03 = CardRank_03.valueOf(scanner.nextLine());
        CardSuit cardSuit = CardSuit.valueOf(scanner.nextLine());


        Card card = new Card(cardRank_03, cardSuit);
        int cardPower = card.calculatePower();

        System.out.printf("Card name: %s of %s; Card power: %d"
        ,card.getRank(), card.getSuit(), cardPower);
    }
}
