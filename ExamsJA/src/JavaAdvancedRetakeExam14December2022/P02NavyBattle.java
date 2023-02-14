package JavaAdvancedRetakeExam14December2022;

import java.util.Scanner;

public class P02NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][];
        int subRow = -1;
        int subCol = -1;

        fillMatrix(matrix, size, scanner);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'S') {
                    subRow = i;
                    subCol = j;
                }
            }
        }
        int mines = 0;
        int cruisers = 0;

        while (true) {
            String input = scanner.nextLine();
            matrix[subRow][subCol] = '-';

            switch (input) {
                case "up":
                    subRow--;
                    break;
                case "down":
                    subRow++;
                    break;
                case "left":
                    subCol--;
                    break;
                case "right":
                    subCol++;
                    break;
            }
            if (matrix[subRow][subCol] == '*') {
                mines++;
            } else if (matrix[subRow][subCol] == 'C') {
                cruisers++;
            }
            matrix[subRow][subCol] = 'S';
            if (mines >= 3) {
                System.out.printf("Mission failed, U-9 disappeared! " +
                        "Last known coordinates [%d, %d]!%n", subRow, subCol);
                break;
            }
            if (cruisers >= 3) {
                System.out.println("Mission accomplished, U-9 has destroyed " +
                        "all battle cruisers of the enemy!");

                break;
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(char[][] matrix, int size, Scanner scanner) {
        for (int i = 0; i < size; i++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            matrix[i] = currentRow;
        }
    }
}
