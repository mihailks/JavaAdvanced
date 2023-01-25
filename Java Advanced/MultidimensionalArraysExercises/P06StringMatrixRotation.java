package MultidimensionalArraysExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int degree = Integer.parseInt(input.substring(7, input.length() - 1)) % 360;

        List<String> words = new ArrayList<>();
        String inputWord = scanner.nextLine();
        while (!inputWord.equals("END")) {
            words.add(inputWord);
            inputWord = scanner.nextLine();
        }

        int maxLength = getMaxLength(words);

        int rows = words.size();
        int cols = maxLength;

        fillWithSpaces(words, maxLength);
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            char[] currentWord = words.get(i).toCharArray();
            matrix[i] = currentWord;
        }

        switch (degree) {
            case 0:
                printMatrix0(matrix);
                break;
            case 90:
                printMatrix90(matrix, rows, cols);
                break;
            case 180:
                printMatrix180(matrix, rows, cols);
                break;
            case 270:
                printMatrix270(matrix, rows, cols);
                break;
        }
    }

    private static void printMatrix270(char[][] matrix, int rows, int cols) {
        for (int i = cols - 1; i >= 0 ; i--) {
            for (int j = 0; j < rows ; j++) {
                System.out.print(matrix[j][i]);

            }
            System.out.println();
        }
    }

    private static void printMatrix180(char[][] matrix, int rows, int cols) {
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void printMatrix90(char[][] matrix, int rows, int cols) {
        for (int i = 0; i < cols; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                System.out.print(matrix[j][i]);
            }
            System.out.println();
        }
    }

    private static void printMatrix0(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillWithSpaces(List<String> words, int maxLength) {
        for (int i = 0; i < words.size(); i++) {
            StringBuilder addSpaces = new StringBuilder(words.get(i));
            while (addSpaces.length() < maxLength) {
                addSpaces.append(' ');
            }
            words.set(i, String.valueOf(addSpaces));
        }
    }


    private static int getMaxLength(List<String> words) {
        int maxLength = -1;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() > maxLength) {
                maxLength = words.get(i).length();
            }
        }
        return maxLength;
    }
}
