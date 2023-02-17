//package Others;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class P02NaturesProphet {
// FIXME - everything
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String[] input = scanner.nextLine().split(" ");
//        int rows = Integer.parseInt(input[0]);
//        int cols = Integer.parseInt(input[1]);
//
//        int[][] matrix = new int[rows][cols];
//
//        fillMatrix(matrix);
//
//        String[] commands = scanner.nextLine().split(" ");
//
//        while (!commands[0].equals("Bloom")) {
//            int flowerRow = Integer.parseInt(commands[0]);
//            int flowerCol = Integer.parseInt(commands[1]);
//
//            for (int i = 0; i < matrix.length; i++) {
//                matrix[i][flowerRow]++;
//            }
//            for (int i = 0; i < matrix.length; i++) {
//                if (i != flowerCol) {
//                    matrix[flowerRow][i]++;
//                }
//            }
//            commands = scanner.nextLine().split(" ");
//        }
//        printMatrix(matrix);
//    }
//
//    private static void fillMatrix(int[][] matrix) {
//        for (int[] ints : matrix) {
//            Arrays.fill(ints, 0);
//        }
//    }
//
//    private static void printMatrix(int[][] matrix) {
//        for (int[] ints : matrix) {
//            for (int col = 0; col < matrix[0].length; col++) {
//                System.out.print(ints[col] + " ");
//            }
//            System.out.println();
//        }
//    }
//}