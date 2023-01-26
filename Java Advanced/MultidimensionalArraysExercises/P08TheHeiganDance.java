package MultidimensionalArraysExercises;

import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damage = Double.parseDouble(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[][] matrix = new int[15][15];
        int playerRow = 7;
        int playerCol = 7;
        double playerHP = 18500;
        double bossHP = 3000000;
        String lastUsedSpell = "";
        while (true) {
            bossHP-=damage;
            if (bossHP<=0){
                break;
            }
            if (lastUsedSpell.equals("Cloud")){
                playerHP-=3500;
            }
            if (playerHP<=0){
                break;
            }
            String spell = input[0];
            int spellRow = Integer.parseInt(input[1]);
            int spellCol = Integer.parseInt(input[2]);
            spellEffect(matrix, spellRow, spellCol);


            playerRow = playersMove(matrix,playerRow,playerCol)[0];
            playerCol = playersMove(matrix,playerRow,playerCol)[1];

            if (matrix[playerRow][playerCol]==-1){
               if (spell.equals("Cloud")){
                   playerHP-=3500;
               } else if (spell.equals("Eruption")){
                   playerHP-=6000;
               }
                lastUsedSpell=spell;
            }
            printMatrix(matrix);
            input = scanner.nextLine().split(" ");
        }

        if (bossHP<=0){
            System.out.println("Heigan: Defeated!");
            System.out.printf("Player: %.0f\n",playerHP);
            System.out.printf("Final position: %d %d",playerRow,playerCol);
        } else {
            System.out.printf("Heigan: %.2f\n",bossHP);
            System.out.printf("Player: Killed by %s\n",lastUsedSpell);
            System.out.printf("Final position: %d %d",playerRow,playerCol);
        }


       // printMatrix(matrix);
        //TODO fix the moves;
    }

    private static int[] playersMove(int[][] matrix, int playerRow, int playerCol) {

        if (matrix[playerRow][playerCol]==-1){
            if (playerRow-1>0 && matrix[playerRow-1][playerCol]!=-1){
                playerRow=playerRow-1;
            } else if (playerCol+1<15 && matrix[playerRow][playerCol+1]!=-1){
                playerCol=playerCol+1;
            } else if (playerRow+1<15 && matrix[playerRow+1][playerCol]!=-1){
                playerRow=playerRow+1;
            } else if (playerCol-1>0 && matrix[playerRow][playerCol-1]!=-1) {
                playerCol=playerCol-1;
            }
        }
        return new int[]{playerRow,playerCol};
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void spellEffect(int[][] matrix, int spellRow, int spellCol) {
        int startRow = spellRow - 1;
        if (startRow < 0) {
            startRow = 0;
        }
        int endRow = spellRow + 1;
        if (endRow >= 15) {
            endRow = 14;
        }
        int startCol = spellCol - 1;
        if (startCol < 0) {
            startCol = 0;
        }
        int endCol = spellCol + 1;
        if (endCol >= 15) {
            endCol = 14;
        }
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                matrix[i][j] = -1;
            }
        }
    }
}
