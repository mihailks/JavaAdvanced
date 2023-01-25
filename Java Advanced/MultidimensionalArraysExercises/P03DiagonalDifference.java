package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][];
        matrixRead(matrix, scanner);

        System.out.println(Math.abs(primaryDiagonal(matrix) - secondaryDiagonal(matrix)));
        
    }

    private static int secondaryDiagonal(int[][] matrix) {
        int sumSecondary = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j==matrix.length-i-1){
                    sumSecondary+=matrix[i][j];
                }
            }
        }
        return sumSecondary;
    }

    private static int primaryDiagonal(int[][] matrix) {
        int sumPrimary = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i==j){
                    sumPrimary+=matrix[i][j];
                }
            }
        }
        return sumPrimary;
    }

    private static void matrixRead(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i]=row;
        }
    }

}
