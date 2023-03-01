package WorkingWithAbstractionExercise.P01CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardType[] values = CardType.values();

        String input = scanner.nextLine();

        System.out.println(input + ":");
        for (CardType value : values) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.getValue(), value);
        }
    }
}
