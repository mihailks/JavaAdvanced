package JavaAdvancedExam26Oct2019;

import java.util.Scanner;

public class P02BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder snake = new StringBuilder(scanner.nextLine());

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][];

        fillMatrix(matrix, size, scanner);

        int snakeCol = 0;
        int snakeRow = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'P') {
                    snakeCol = i;
                    snakeRow = j;
                    break;
                }
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            boolean isOutOfGrid = false;
            switch (input) {
                case "up":
                    if (snakeRow - 1 >= 0) {
                        matrix[snakeRow][snakeCol] = '-';
                        snakeRow--;
                    } else {
                        isOutOfGrid = true;
                    }
                    break;
                case "down":
                    if (snakeRow + 1 < matrix.length) {
                        matrix[snakeRow][snakeCol] = '-';
                        snakeRow++;
                    } else {
                        isOutOfGrid = true;
                    }
                    break;
                case "left":
                    if (snakeCol-1>=0) {
                        matrix[snakeRow][snakeCol] = '-';
                        snakeCol--;
                    } else {
                        isOutOfGrid = true;
                    }
                    break;
                case "right":
                    if (snakeCol+1< matrix.length) {
                        matrix[snakeRow][snakeCol] = '-';
                        snakeCol++;

                    } else {
                        isOutOfGrid = true;
                    }
                    break;
            }
            if (isOutOfGrid) {
                if (snake.length() > 0) {
                    snake.deleteCharAt(snake.length() - 1);
                }
            } else {
                char current  = matrix[snakeRow][snakeCol];
                matrix[snakeRow][snakeCol] = 'P';
                if (current != '-') {
                    snake.append(current);
                }
            }

            input = scanner.nextLine();
        }
        System.out.println(snake);
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
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
