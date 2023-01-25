package MultidimensionalArraysExercises;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];
        Integer[][] matrix = new Integer[size][size];
        if (pattern.equals("A")) {
            MatrixFillPatternA(matrix);
        } else {
            matrixFillPatternB(matrix);
        }

        matrixPrint(matrix);

    }

    private static void matrixFillPatternB(Integer[][] matrix) {
        int n = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = n;
                    n++;
                }
            } else {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    matrix[j][i] = n;
                    n++;
                }
            }
        }
    }

    private static void matrixPrint(Integer[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void MatrixFillPatternA(Integer[][] matrix) {
        int n = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = n;
                n++;
            }

        }

    }
}
