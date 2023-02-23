package WorkingWithAbstractionLab.P01RhombusOfStars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            printRow(i, n - i);
        }

        for (int i = n - 1; i > 0; i--) {
            printRow(i, n - i);
        }

    }

    private static void printRow(int numberOfStars, int numberOfLeadingSpaces) {
        for (int i = 0; i < numberOfLeadingSpaces; i++) {
            System.out.print(" ");
        }
        for (int i = 0; i < numberOfStars - 1; i++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}
