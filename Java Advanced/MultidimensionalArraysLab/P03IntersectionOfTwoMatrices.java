package MultidimensionalArraysLab;

import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] matrixOne = new String[rows][];
        String[][] matrixTwo = new String[rows][];

        for (int i = 0; i < matrixOne.length; i++) {
            String[] currentRow = scanner.nextLine().split(" ");
            matrixOne[i]=currentRow;
        }

        for (int i = 0; i < matrixTwo.length; i++) {
            String[] currentRow = scanner.nextLine().split(" ");
            matrixTwo[i]=currentRow;
        }

        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[i].length; j++) {
                if (matrixOne[i][j].equals(matrixTwo[i][j])) {
                    System.out.printf(matrixOne[i][j] + " ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
