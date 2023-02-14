package JavaAdvancedRetakeExam17Dec2019;

import java.util.Scanner;

public class P02PresentDelivery {

    private static int presentsGave = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPresents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][];
        int santaRol = -1;
        int santaCol = -1;
        for (int i = 0; i < size; i++) {
            char[] currentRol = scanner.nextLine().replace(" ", "").toCharArray();
            matrix[i] = currentRol;
        }
        int niceKindsCounter = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] == 'S') {
                    santaRol = i;
                    santaCol = j;
                } else if (matrix[i][j] == 'V') {
                    niceKindsCounter++;
                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("Christmas morning")) {
            matrix[santaRol][santaCol] = '-';

            switch (command) {
                case "up":
                    santaRol--;
                    break;
                case "down":
                    santaRol++;
                    break;
                case "left":
                    santaCol--;
                    break;
                case "right":
                    santaCol++;
                    break;
            }
            numberOfPresents = move(santaRol, santaCol, matrix, numberOfPresents);
            matrix[santaRol][santaCol] = 'S';
            if (numberOfPresents <= 0) {
                break;
            }
            command = scanner.nextLine();
        }

        if (numberOfPresents == 0) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(matrix);
        if (presentsGave >= niceKindsCounter) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", niceKindsCounter);
        } else {
            System.out.printf("No presents for %d nice kid/s.", niceKindsCounter - presentsGave);
        }
    }

    private static int move(int santaRol, int santaCol, char[][] matrix, int numberOfPresents) {
        char currentPlace = matrix[santaRol][santaCol];
        if (inBounds(santaRol, santaCol, matrix)) {


            switch (currentPlace) {
                case 'V':
                    presentsGave++;
                    numberOfPresents--;
                    break;
                case 'C':
                    //UP
                    if (matrix[santaRol - 1][santaCol] == 'V' || matrix[santaRol - 1][santaCol] == 'X') {
                        numberOfPresents--;
                        if (matrix[santaRol - 1][santaCol] == 'V') {
                            presentsGave++;
                        }
                        matrix[santaRol - 1][santaCol] = '-';
                    }
                    //DOWN
                    if (matrix[santaRol + 1][santaCol] == 'V' || matrix[santaRol + 1][santaCol] == 'X') {
                        numberOfPresents--;
                        if (matrix[santaRol + 1][santaCol] == 'V') {
                            presentsGave++;
                        }
                        matrix[santaRol + 1][santaCol] = '-';
                    }
                    //LEFT
                    if (matrix[santaRol][santaCol - 1] == 'V' || matrix[santaRol][santaCol - 1] == 'X') {
                        numberOfPresents--;
                        if (matrix[santaRol][santaCol - 1] == 'V') {
                            presentsGave++;
                        }
                        matrix[santaRol][santaCol - 1] = '-';
                    }
                    //RIGHT
                    if (matrix[santaRol][santaCol + 1] == 'V' || matrix[santaRol][santaCol + 1] == 'X') {
                        numberOfPresents--;
                        if (matrix[santaRol][santaCol + 1] == 'V') {
                            presentsGave++;
                        }
                        matrix[santaRol][santaCol + 1] = '-';
                    }

                    break;
            }
        }
        return numberOfPresents;
    }



    private static boolean inBounds(int santaRol, int santaCol, char[][] matrix) {
        return (santaRol >= 0) && (santaRol < matrix.length) &&
                (santaCol >= 0) && (santaCol < matrix[santaRol].length);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
