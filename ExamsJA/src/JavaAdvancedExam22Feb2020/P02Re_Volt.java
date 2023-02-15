//package JavaAdvancedExam22Feb2020;
//
//import java.io.StringBufferInputStream;
//import java.util.Scanner;
//
//public class P02Re_Volt {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int size = Integer.parseInt(scanner.nextLine());
//
//        int countCommands = Integer.parseInt(scanner.nextLine());
//        char[][] matrix = new char[size][];
//        fillMatrix(matrix, size, scanner);
//
//        int playersRow = 0;
//        int playersCol = 0;
//
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                if (matrix[i][j] == 'f') {
//                    playersRow = i;
//                    playersCol = j;
//                    break;
//                }
//            }
//        }
//
//        for (int i = 0; i < countCommands; i++) {
//            String input = scanner.nextLine();
//            matrix[playersRow][playersCol] = '-';
//
//            int playersRowSave = playersRow;
//            int playersColSave = playersCol;
//
//            switch (input) {
//                case "up":
//                    if (playersRow - 1 < 0) {
//                        playersRow = matrix.length - 1;
//                    } else {
//                        playersRow--;
//                    }
//                    if (matrix[playersRow][playersCol] == 'T') {
//                        playersRow = playersRowSave;
//                        playersCol = playersColSave;
//                        continue;
//                    }
//                    if (matrix[playersRow][playersCol] != 'B') {
//                        if (!isTrap(matrix, playersRow, playersCol)) {
//                            if (isFinished(matrix, playersRow, playersCol)) {
//                                break;
//                            }
//                            matrix[playersRow][playersCol] = 'f';
//                        }
//                    }
//                    break;
//                case "down":
//                    if (playersRow + 1 > matrix.length) {
//                        playersRow = matrix.length - 1;
//                    } else {
//                        playersRow++;
//                    }
//                    if (matrix[playersRow][playersCol] == 'T') {
//                        playersRow = playersRowSave;
//                        playersCol = playersColSave;
//                        continue;
//                    }
//                    if (matrix[playersRow][playersCol] != 'B') {
//                        if (!isTrap(matrix, playersRow, playersCol)) {
//                            if (isFinished(matrix, playersRow, playersCol)) {
//                                break;
//                            }
//                            matrix[playersRow][playersCol] = 'f';
//                        }
//                    }
//                    break;
//                case "left":
//
//                    break;
//                case "right":
//
//                    break;
//            }
//            if (isFinished(matrix, playersRow, playersCol)) {
//                break;
//            }
//        }
//
//        if (isFinished(matrix, playersRow, playersCol)) {
//            System.out.println("Player won!");
//        } else {
//            System.out.println("Player lost!");
//        }
//        matrix[playersRow][playersCol] = 'f';
//        printMatrix(matrix);
//    }
//
//    public static boolean isFinished(char[][] matrix, int playersRow, int playersCol) {
//        if (matrix[playersRow][playersCol] == 'F') {
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean isBonus(char[][] matrix, int playersRow, int playersCol) {
//        if (matrix[playersRow][playersCol] == 'B') {
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean isTrap(char[][] matrix, int playersRow, int playersCol) {
//        if (matrix[playersRow][playersCol] == 'T') {
//            return true;
//        }
//        return false;
//    }
//
//    private static void printMatrix(char[][] matrix) {
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                System.out.print(matrix[row][col]);
//            }
//            System.out.println();
//        }
//    }
//
//    private static void fillMatrix(char[][] matrix, int size, Scanner scanner) {
//        for (int i = 0; i < size; i++) {
//            char[] currentRow = scanner.nextLine().toCharArray();
//            matrix[i] = currentRow;
//        }
//    }
//}
