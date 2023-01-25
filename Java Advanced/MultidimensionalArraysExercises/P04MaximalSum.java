package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        int[][] matrix = new int[rows][cols];
        matrixRead(matrix, scanner);
        int maxSum = Integer.MIN_VALUE;
        int maxRow = -1;
        int maxCol = -1;

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1] + matrix[i + 1][j + 2] +
                        matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        System.out.printf("%d %d %d\n", matrix[maxRow][maxCol], matrix[maxRow][maxCol + 1], matrix[maxRow][maxCol + 2]);
        System.out.printf("%d %d %d\n", matrix[maxRow + 1][maxCol], matrix[maxRow + 1][maxCol + 1], matrix[maxRow + 1][maxCol + 2]);
        System.out.printf("%d %d %d\n", matrix[maxRow + 2][maxCol], matrix[maxRow + 2][maxCol + 1], matrix[maxRow + 2][maxCol + 2]);


    }

    private static void matrixRead(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = currentRow;
        }
    }
}
