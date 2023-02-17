package Others;

import java.util.Scanner;

public class P02Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][];

        fillMatrix(matrix, size, scanner);
        int pollinated = 0;
        int beeRow = 0;
        int beeCol = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (matrix[i][j] == 'B') {
                    beeRow = i;
                    beeCol = j;
                    break;
                }
            }
        }
        boolean finish = false;
        boolean isInField = true;
        while (true) {
            String input = scanner.nextLine();
            matrix[beeRow][beeCol] = '.';
            switch (input) {

                case "up":
                    if (beeRow - 1 < 0) {
                        isInField = false;
                    } else {
                        beeRow--;
                        pollinated = getPollinated(matrix, pollinated, beeRow, beeCol);
                        if (matrix[beeRow][beeCol] == 'O') {
                            matrix[beeRow][beeCol] = '.';
                            beeRow--;
                            pollinated = getPollinated(matrix, pollinated, beeRow, beeCol);

                        }
                    }
                    break;

                case "down":
                    if (beeRow + 1 > matrix.length - 1) {
                        isInField = false;
                    } else {
                        beeRow++;
                        pollinated = getPollinated(matrix, pollinated, beeRow, beeCol);
                        if (matrix[beeRow][beeCol] == 'O') {
                            matrix[beeRow][beeCol] = '.';
                            beeRow++;
                            pollinated = getPollinated(matrix, pollinated, beeRow, beeCol);
                        }
                    }
                    break;

                case "left":
                    if (beeCol - 1 < 0) {
                        isInField = false;
                    } else {
                        beeCol--;
                        pollinated = getPollinated(matrix, pollinated, beeRow, beeCol);

                        if (matrix[beeRow][beeCol] == 'O') {
                            matrix[beeRow][beeCol] = '.';
                            beeCol--;
                            pollinated = getPollinated(matrix, pollinated, beeRow, beeCol);

                        }
                    }
                    break;

                case "right":
                    if (beeCol + 1 > matrix.length - 1) {
                        isInField = false;
                    } else {
                        beeCol++;
                        pollinated = getPollinated(matrix, pollinated, beeRow, beeCol);
                        if (matrix[beeRow][beeCol] == 'O') {
                            matrix[beeRow][beeCol] = '.';
                            beeCol++;
                            pollinated = getPollinated(matrix, pollinated, beeRow, beeCol);
                        }
                    }
                    break;
                case "End":
                    finish = true;
                    break;
            }
            matrix[beeRow][beeCol] = 'B';
            if (finish) {
                break;
            }
            if (!isInField) {
                System.out.println("The bee got lost!");
                matrix[beeRow][beeCol] = '.';
                break;
            }
        }
        if (pollinated >= 5) {
            System.out.printf("Great job, the bee manage to " +
                    "pollinate %d flowers!%n", pollinated);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, " +
                    "she needed %d flowers more%n", 5 - pollinated);
        }
        printMatrix(matrix);
    }

    private static int getPollinated(char[][] matrix, int pollinated, int beeRow, int beeCol) {
        if (matrix[beeRow][beeCol] == 'f') {
            pollinated++;
        }
        return pollinated;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
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
