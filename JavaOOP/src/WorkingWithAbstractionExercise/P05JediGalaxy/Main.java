package WorkingWithAbstractionExercise.P05JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final String END_COMMAND = "Let the Force be with you";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] galaxyMatrix = readAndInitializeMatrix(scanner);

        String command = scanner.nextLine();
        long sum = 0;

        while (!command.equals(END_COMMAND)) {
            int[] jediCoords = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoords = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            moveEvilAndDestroyStars(galaxyMatrix, evilCoords);
            sum += moveJediAndAddStars(galaxyMatrix, jediCoords);

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static long moveJediAndAddStars(int[][] galaxyMatrix, int[] jediCoords) {
        int jediRow = jediCoords[0];
        int jediCol = jediCoords[1];

        long sum = 0;
        while (canJediStillMove(galaxyMatrix, jediRow, jediCol)) {
            if (isInMatrix(galaxyMatrix, jediRow, jediCol)) {
                sum += galaxyMatrix[jediRow][jediCol];
            }

            jediCol++;
            jediRow--;
        }
        return sum;
    }

    private static void moveEvilAndDestroyStars(int[][] galaxyMatrix, int[] evilCoords) {
        int evilRow = evilCoords[0];
        int evilCol = evilCoords[1];

        while (evilRow >= 0 && evilCol >= 0) {
            if (isInMatrix(galaxyMatrix, evilRow, evilCol)) {
                galaxyMatrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static boolean isInMatrix(int[][] galaxyMatrix, int jediRow, int jediCol) {
        int galaxyMatrixColumnsLength = galaxyMatrix[0].length;
        return jediRow >= 0 && jediRow < galaxyMatrix.length && jediCol >= 0 && jediCol < galaxyMatrixColumnsLength;
    }

    private static boolean canJediStillMove(int[][] galaxyMatrix, int jediRow, int jediCol) {
        return jediRow >= 0 && jediCol < galaxyMatrix[1].length;
    }

    static int[][] readAndInitializeMatrix(Scanner scanner) {
        int[] dimension = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = dimension[0];
        int y = dimension[1];

        int[][] matrix = new int[x][y];

        int value = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }

}
