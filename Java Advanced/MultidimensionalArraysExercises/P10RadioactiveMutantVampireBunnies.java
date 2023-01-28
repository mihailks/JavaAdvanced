package MultidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P10RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];
        char[][] bord = new char[rows][cols];
        int playerRow = -1;
        int playerCol = -1;
        boolean playerWin = false;
        boolean isDead = false;

        for (int i = 0; i < rows; i++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            for (int j = 0; j < cols; j++) {
                bord[i][j] = currentRow[j];
                if (bord[i][j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        char[] moves = scanner.next().toCharArray();

        for (int i = 0; i < moves.length; i++) {
            char currentMove = moves[i];

            if (currentMove == 'L') {
                if (playerCol - 1 < 0) {
                    playerWin = true;
                    bord[playerRow][playerCol] = '.';
                } else {
                    if (bord[playerRow][playerCol - 1] == 'B') {
                        bord[playerRow][playerCol] = '.';
                        isDead = true;
                        playerCol--;
                    } else {
                        bord[playerRow][playerCol - 1] = 'P';
                        bord[playerRow][playerCol] = '.';
                        playerCol--;
                    }
                }
            } else if (currentMove == 'R') {
                if (playerCol + 1 >= bord[playerRow].length) {
                    playerWin = true;
                    bord[playerRow][playerCol] = '.';
                } else {
                    if (bord[playerRow][playerCol + 1] == 'B') {
                        bord[playerRow][playerCol] = '.';
                        playerCol++;
                        isDead = true;
                    } else {
                        bord[playerRow][playerCol + 1] = 'P';
                        bord[playerRow][playerCol] = '.';
                        playerCol++;
                    }
                }
            } else if (currentMove == 'U') {
                if (playerRow - 1 < 0) {
                    playerWin = true;
                    bord[playerRow][playerCol] = '.';
                } else {
                    if (bord[playerRow - 1][playerCol] == 'B') {
                        bord[playerRow][playerCol] = '.';
                        playerRow--;
                        isDead = true;
                    } else {
                        bord[playerRow - 1][playerCol] = 'P';
                        bord[playerRow][playerCol] = '.';
                        playerRow--;
                    }
                }
            } else if (currentMove == 'D') {
                if (playerRow + 1 >= bord.length) {
                    playerWin = true;
                    bord[playerRow][playerCol] = '.';
                } else {
                    if (bord[playerRow + 1][playerCol] == 'B') {
                        bord[playerRow][playerCol] = '.';
                        isDead = true;
                    } else {
                        bord[playerRow + 1][playerCol] = 'P';
                        bord[playerRow][playerCol] = '.';
                        playerRow++;
                    }
                }
            }

            //bunnies

            for (int row = 0; row < bord.length; row++) {
                for (int col = 0; col < bord[row].length; col++) {
                    if (bord[row][col] == 'B') {
                        if (col - 1 >= 0) {
                            if (bord[row][col - 1] == 'P') {
                                isDead = true;
                                bord[row][col - 1] = 'N';
                            } else if (bord[row][col - 1] == '.') {
                                bord[row][col - 1] = 'N';
                            }
                        }
                        if (col + 1 < bord[row].length) {
                            if (bord[row][col + 1] == 'P') {
                                isDead = true;
                                bord[row][col + 1] = 'N';
                            } else if (bord[row][col + 1] == '.') {
                                bord[row][col + 1] = 'N';
                            }
                        }
                        if (row - 1 >= 0) {
                            if (bord[row - 1][col] == 'P') {
                                isDead = true;
                                bord[row - 1][col] = 'N';
                            } else if (bord[row - 1][col] == '.') {
                                bord[row - 1][col] = 'N';
                            }
                        }
                        if (row + 1 < bord.length) {
                            if (bord[row + 1][col] == 'P') {
                                isDead = true;
                                bord[row + 1][col] = 'N';
                            } else if (bord[row + 1][col] == '.') {
                                bord[row + 1][col] = 'N';
                            }
                        }
                    }


                }
            }

            bord = growBunnies(bord);
            if (playerWin) {
                printBoard(bord);
                System.out.printf("won: %d %d%n", playerRow, playerCol);
                break;
            } else if (isDead) {
                printBoard(bord);
                System.out.printf("dead: %d %d%n", playerRow, playerCol);
                break;
            }
        }


    }


    private static void printBoard(char[][] bord) {
        for (int i = 0; i < bord.length; i++) {
            for (int j = 0; j < bord[i].length; j++) {
                System.out.print(bord[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] growBunnies(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'N') {
                    board[i][j] = 'B';
                }
            }
        }
        return board;
    }
}
