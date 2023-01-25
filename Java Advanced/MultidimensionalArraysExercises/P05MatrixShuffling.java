package MultidimensionalArraysExercises;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        String[][] matrix = new String[rows][];
        matrixRead(matrix, scanner);

        String[] input = scanner.nextLine().split(" ");

        while (!input[0].equals("END")) {

            if (validateInput(input, rows, cols)) {
                int row1 = Integer.parseInt(input[1]);
                int col1 = Integer.parseInt(input[2]);
                int row2 = Integer.parseInt(input[3]);
                int col2 = Integer.parseInt(input[4]);
                String first = matrix[row1][col1];
                String second = matrix[row2][col2];

                matrix[row1][col1] = second;
                matrix[row2][col2] = first;

                matrixPrint(matrix);

            } else {
                System.out.println("Invalid input!");
            }

            input = scanner.nextLine().split(" ");
        }

    }

    private static void matrixRead(String[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            String[] currentRow = scanner.nextLine().split(" ");
            matrix[i] = currentRow;
        }
    }

    public static boolean validateInput(String[] input, int rows, int cols) {

        if (!input[0].equals("swap")) {
            return false;
        }
        if (input.length != 5) {
            return false;
        }
        int row1 = Integer.parseInt(input[1]);
        int col1 = Integer.parseInt(input[2]);
        int row2 = Integer.parseInt(input[3]);
        int col2 = Integer.parseInt(input[4]);
        if (row1 < 0 || row1 > rows || row2 < 0 || row2 > rows || col1 < 0 || col1 > cols || col2 < 0 || col2 > cols) {
            return false;
        }
        return true;
    }

    private static void matrixPrint(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
