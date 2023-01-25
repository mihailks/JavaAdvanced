package MultidimensionalArraysExercises;

import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix);


    }

    private static void fillMatrix(int[][] matrix) {
        int secondN = 0;
        int thirdN = 0;
        for (int i = 0; i < matrix.length; i++) {
            int rowCounter = 0;
            rowCounter++;
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowCounter == 1) {
                    matrix[i][j]=j;
                } else if (rowCounter == 2) {
                    matrix[i][j]=j+1;
                } else if (rowCounter == 3) {
                    matrix[i][j]=2*j+1;
                }
            }
            if (rowCounter==3){
                rowCounter=0;
            }


        }

    }
}
