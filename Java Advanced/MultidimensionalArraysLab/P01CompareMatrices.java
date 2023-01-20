package MultidimensionalArraysLab;

import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");
        int firstRows = Integer.parseInt(size[0]);
        int firstCols = Integer.parseInt(size[1]);
        int[][] matrixOne = new int[firstRows][firstCols];

        for (int i = 0; i < matrixOne.length; i++) {
            String[] cells = scanner.nextLine().split(" ");

            for (int j = 0; j < matrixOne[i].length; j++) {
                matrixOne[i][j] = Integer.parseInt(cells[j]);
            }
        }

        String[] sizeTwo = scanner.nextLine().split(" ");
        int secondRows = Integer.parseInt(sizeTwo[0]);
        int secondCols = Integer.parseInt(sizeTwo[1]);
        int[][] matrixTwo = new int[secondRows][secondCols];
        boolean isEqual = true;
        if (firstRows != secondRows || firstCols != secondCols) {
            isEqual = false;

        } else {
            for (int i = 0; i < matrixTwo.length; i++) {
                String[] cellsTwo = scanner.nextLine().split(" ");

                for (int j = 0; j < matrixTwo[i].length; j++) {
                    matrixTwo[i][j] = Integer.parseInt(cellsTwo[j]);
                }
            }
            for (int i = 0; i < matrixOne.length; i++) {
                for (int j = 0; j < matrixOne[i].length; j++) {
                    if (matrixOne[i][j] != matrixTwo[i][j]) {
                        isEqual = false;
                        break;
                    }
                }
                if (!isEqual) {
                    break;
                }
            }
        }
        if (isEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }
}
