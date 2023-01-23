package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = currentRow;
        }
        String firstDiag = "";
        String secondDiag = "";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {

                if (i == j) {
                    firstDiag += matrix[i][j] + " ";
                }
            }
        }
        for (int i = n-1; i >= matrix.length; i--) {
            for (int j = 0; j < matrix.length; j++) {
                if (i + j == n - 1) {
                    secondDiag += matrix[i][j] + " ";
                }
            }
        }
        System.out.println(firstDiag);
        System.out.println(secondDiag);
    }
}
