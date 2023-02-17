package Others;

import java.util.Scanner;

public class P02Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][];
        String[] input = scanner.nextLine().split(",\\s+");
        fillMatrix(matrix, size, scanner);

        int snakeRow = -1;
        int snakeCol = -1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (matrix[i][j] == 's') {
                    snakeRow = i;
                    snakeCol = j;
                    break;
                }
            }
        }
        int foodCount = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'f') {
                    foodCount++;
                }
            }
        }
        int snakeLength = 1;
        for (int i = 0; i < input.length; i++) {
            String command = input[i];
            switch (command) {
                case "up":
                    if (snakeRow - 1 < 0) {
                        snakeRow = matrix.length - 1;
                    } else {
                        snakeRow--;
                    }
                    break;
                case "down":
                    if (snakeRow + 1 >= matrix.length) {
                        snakeRow = 0;
                    } else {
                        snakeRow++;
                    }
                    break;
                case "left":
                    if (snakeCol - 1 < 0) {
                        snakeCol = matrix.length - 1;
                    } else {
                        snakeCol--;
                    }
                    break;
                case "right":
                    if (snakeCol + 1 >= matrix.length) {
                        snakeCol = 0;
                    } else {
                        snakeCol++;
                    }
                    break;
            }
            if (matrix[snakeRow][snakeCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                return;
            } else if (matrix[snakeRow][snakeCol] == 'f') {
                foodCount--;
                snakeLength++;
            }
            if (foodCount <= 0) {
                break;
            }
            matrix[snakeRow][snakeCol] = 's';
        }
//        int foodLeft = 0;
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if (matrix[i][j] == 'f') {
//                    foodLeft++;
//                    break;
//                }
//            }
//        }
        if (foodCount > 0) {
            System.out.printf("You lose! There is still %d food to be eaten.%n", foodCount);
        } else {
            System.out.printf("You win! Final snake length is %d%n", snakeLength);
        }
    }

    private static void fillMatrix(char[][] matrix, int size, Scanner scanner) {
        for (int i = 0; i < size; i++) {
            char[] currentRow = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = currentRow;
        }
    }
}
