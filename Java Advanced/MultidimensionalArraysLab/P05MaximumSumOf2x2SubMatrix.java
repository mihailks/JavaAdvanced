package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {

        int[][] matrix = readMatrix();

        int maxSum = Integer.MIN_VALUE;
        int iPrint = -1;
        int jPrint = -1;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                int currentSum = matrix[i][j] + matrix[i + 1][j] + matrix[i][j + 1] + matrix[i + 1][j + 1];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    iPrint = i;
                    jPrint = j;
                }
            }
        }
        System.out.println(matrix[iPrint][jPrint] + " " + matrix[iPrint][jPrint + 1]);
        System.out.println(matrix[iPrint + 1][jPrint] + " " + matrix[iPrint + 1][jPrint + 1]);
        System.out.println(maxSum);

    }

    private static int[][] readMatrix() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][];
        for (int i = 0; i < matrix.length; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = currentRow;
        }
        return matrix;
    }
}
