package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P12TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] inputArray = scanner.nextLine().split("\\s+");
            for (int column = 0; column < inputArray.length; column++) {
                char currentChar = inputArray[column].charAt(0);
                matrix[row][column] = currentChar;
            }
        }

        char fillChar = scanner.nextLine().charAt(0);
        String[] startPositions = scanner.nextLine().split("\\s+");
        int startRow = Integer.parseInt(startPositions[0]);
        int startCol = Integer.parseInt(startPositions[1]);

        char startChar = matrix[startRow][startCol];

        matrixFillNewChar(startRow, startCol, fillChar, startChar, matrix);

        printMatrix(matrix);
    }

    private static void matrixFillNewChar(int startRow, int startColumn, char fillChar, char startChar, char[][] matrix) {
        if (matrix[startRow][startColumn] != startChar) {
            return;
        }

        matrix[startRow][startColumn] = fillChar;
        if (startRow - 1 >= 0) {
            matrixFillNewChar(startRow - 1, startColumn, fillChar, startChar, matrix);
        }

        if (startRow + 1 < matrix.length) {
            matrixFillNewChar(startRow + 1, startColumn, fillChar, startChar, matrix);
        }

        if (startColumn - 1 >= 0) {
            matrixFillNewChar(startRow, startColumn - 1, fillChar, startChar, matrix);
        }

        if (startColumn + 1 < matrix[startRow].length) {
            matrixFillNewChar(startRow, startColumn + 1, fillChar, startChar, matrix);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column]);
            }
            System.out.println();
        }
    }
}
