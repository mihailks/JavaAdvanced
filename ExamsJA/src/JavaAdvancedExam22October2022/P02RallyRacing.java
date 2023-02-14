package JavaAdvancedExam22October2022;

import java.util.Scanner;

public class P02RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String carNumber = scanner.nextLine();
        char[][] matrix = new char[size][];

        int firstTunnelRow = -1;
        int firstTunnelCol = -1;

        int secondTunnelRow = -1;
        int secondTunnelCol = -1;

        int carRow = 0;
        int carCol = 0;

        fillMatrix(matrix, size, scanner);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'T') {
                    if (firstTunnelCol == -1) {
                        firstTunnelRow = i;
                        firstTunnelCol = j;
                    } else {
                        secondTunnelRow = i;
                        secondTunnelCol = j;
                    }
                }
            }
        }

        int km = 0;
        boolean hasFinished = false;
        matrix[carRow][carCol] = 'C';
        String input = scanner.nextLine();
        while (!input.equals("End")) {

            matrix[carRow][carCol] = '.';
            switch (input) {
                case "up":
                    carRow--;
                    break;
                case "down":
                    carRow++;
                    break;
                case "left":
                    carCol--;
                    break;
                case "right":
                    carCol++;
                    break;
            }
            if (matrix[carRow][carCol] == 'F') {
                matrix[carRow][carCol] = 'C';
                hasFinished = true;
                km += 10;
                break;
            } else if (matrix[carRow][carCol] == 'T') {
                matrix[carRow][carCol] = '.';
                if (carRow == firstTunnelRow && carCol == firstTunnelCol) {
                    carRow = secondTunnelRow;
                    carCol = secondTunnelCol;
                } else {
                    carRow = firstTunnelRow;
                    carCol = firstTunnelCol;
                }
                km += 30;
            } else {
                km += 10;
            }
            matrix[carRow][carCol] = 'C';
            input = scanner.nextLine();
        }
        if (hasFinished) {
            System.out.printf("Racing car %S finished the stage!%n", carNumber);
        } else {
            System.out.printf("Racing car %S DNF.%n", carNumber);
        }
        System.out.printf("Distance covered %d km.%n", km);

        printMatrix(matrix);
    }

    private static void fillMatrix(char[][] matrix, int size, Scanner scanner) {
        for (int i = 0; i < size; i++) {
            char[] currentRow = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = currentRow;
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
