package JavaAdvancedRetakeExam18August2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);
        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            char[] currentRow = scanner.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = currentRow;
        }
        int playersRow = 0, playersCol = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 'Y') {
                    playersRow = i;
                    playersCol = j;
                }

            }
        }
        boolean isFound = false;
        List<String> directions = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("Finish")) {

            //matrix[playersRow][playersCol]='-';

            switch (input) {
                case "up":
                    if (playersRow - 1 >= 0 && matrix[playersRow - 1][playersCol] != 'T') {
                        playersRow--;
                        directions.add(input);
                    }
                    break;
                case "down":
                    if (playersRow + 1 < matrix.length && matrix[playersRow + 1][playersCol] != 'T') {
                        playersRow++;
                        directions.add(input);
                    }
                    break;
                case "left":
                    if (playersCol - 1 >= 0 && matrix[playersRow][playersCol - 1] != 'T') {
                        playersCol--;
                        directions.add(input);
                    }
                    break;
                case "right":
                    if (playersCol + 1 < matrix[playersRow].length && matrix[playersRow][playersCol + 1] != 'T') {
                        playersCol++;
                        directions.add(input);
                    }
                    break;
            }
            // matrix[playersRow][playersCol]='Y';
            // printMatrix(matrix);
            input = scanner.nextLine();

            if (input.equals("Finish") && matrix[playersRow][playersCol] == 'X') {
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("The map is fake!");
        } else {
            System.out.println("I've found the treasure!");
            String printMsg = String.join(", ", directions);
            System.out.printf("The right path is %s%n", printMsg);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
