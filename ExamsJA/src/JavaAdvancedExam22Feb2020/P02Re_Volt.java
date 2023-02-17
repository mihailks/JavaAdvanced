package JavaAdvancedExam22Feb2020;

import java.io.StringBufferInputStream;
import java.util.Scanner;

public class P02Re_Volt {

    public static int playersRow;
    public static int playersCol;
    public static boolean hasWon = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int countCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][];
        fillMatrix(matrix, size, scanner);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'f') {
                    playersRow = i;
                    playersCol = j;
                    break;
                }
            }
        }
  //      int playersRowSave = playersRow;
  //      int playersColSave = playersCol;

        while (countCommands-- > 0 && !hasWon) {
            String input = scanner.nextLine();

            switch (input) {
                case "up":
                    movePlayer(matrix, -1, 0);
                    break;
                case "down":
                    movePlayer(matrix, 1, 0);
                    break;
                case "left":
                    movePlayer(matrix, 0, -1);
                    break;
                case "right":
                    movePlayer(matrix, 0, 1);
                    break;
            }
        }

        if (hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static void movePlayer(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = playersRow + rowMutator;
        int nextCol = playersCol + colMutator;

        if (isOutOfBounds(matrix, nextRow, nextCol)) {
            if (nextRow < 0 || nextRow >= matrix.length) {
                if (nextRow < 0) {
                    nextRow = matrix.length - 1;
                } else {
                    nextCol = 0;
                }
            } else {
                if (nextCol < 0) {
                    nextCol = matrix.length - 1;
                } else {
                    nextCol = 0;
                }
            }
        }

        if (matrix[nextRow][nextCol] == 'T') {
            return;
        } else if (matrix[nextRow][nextCol] == 'B') {
            matrix[playersRow][playersCol] = '-';
            playersRow = nextRow;
            playersCol = nextCol;

            movePlayer(matrix, rowMutator, colMutator); //!!!

            return;
        } else if (matrix[nextRow][nextCol] == 'F') {
            hasWon=true;
        }
        if (matrix[playersRow][playersCol] != 'B') {
            matrix[playersRow][playersCol] = '-';
        }
        matrix[nextRow][nextCol] = 'f';
        playersRow = nextRow;
        playersCol = nextCol;
    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }


//    public static boolean isFinished(char[][] matrix, int playersRow, int playersCol) {
//        if (matrix[playersRow][playersCol] == 'F') {
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean isBonus(char[][] matrix, int playersRow, int playersCol) {
//        if (matrix[playersRow][playersCol] == 'B') {
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean isTrap(char[][] matrix, int playersRow, int playersCol) {
//        if (matrix[playersRow][playersCol] == 'T') {
//            return true;
//        }
//        return false;
//    }

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
