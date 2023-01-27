package MultidimensionalArraysExercises;

import java.util.Scanner;

public class P09ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        int matrixRow = Integer.parseInt(size[0]);
        int matrixCol = Integer.parseInt(size[1]);
        int[][] parking = new int[matrixRow][matrixCol];
        String input = scanner.nextLine();

        while (!input.equals("stop")){

            int entryRow = Integer.parseInt(input.split(" ")[0]);
            int parkingRow = Integer.parseInt(input.split(" ")[1]);
            int parkingCol = Integer.parseInt(input.split(" ")[2]);
            boolean haveFreeSpaces = false;
            for (int i = 1; i < parking[parkingRow].length; i++) {
                if (parking[parkingRow][i]==0){
                    haveFreeSpaces = true;
                    break;
                }
            }
            if (!haveFreeSpaces){
                System.out.printf("Row %d full%n",parkingRow);
                input = scanner.nextLine();
                continue;
            }

            if (parking[parkingRow][parkingCol] == 0){
                parking[parkingRow][parkingCol] = 1;
                printDistance(parking,entryRow,parkingRow,parkingCol);
            }
            printParking(parking);
            System.out.println();

            //find free space on left
            int freeSpaceLeftDistance = -1;
            for (int i = parkingCol; i >= 1; i--) {
                if (parking[parkingRow][parkingCol]==0){
                    freeSpaceLeftDistance=i;
                    break;
                }
            }
            //find free space on right
            int freeSpaceRightDistance = -1;
            for (int i = parkingCol; i < parking[parkingRow].length; i++) {
                if (parking[parkingRow][parkingCol]==0){
                    freeSpaceRightDistance=i;
                    break;
                }
            }
            //if there is only one free space on left or on right

            if (freeSpaceLeftDistance==-1){
                int index = Math.abs(freeSpaceRightDistance-parkingCol);
                parking[parkingRow][index]=1;
            } else if (freeSpaceRightDistance==-1){
                int index = Math.abs(parkingCol-freeSpaceLeftDistance);
                parking[parkingRow][index]=1;
            }

            //TODO - FINISH THE LOGIC...
            //if there are spaces on left and on right
            if (freeSpaceLeftDistance!=freeSpaceRightDistance){
                if(freeSpaceLeftDistance>freeSpaceRightDistance){
                    int index = Math.abs(freeSpaceRightDistance-parkingCol);
                    parking[parkingRow][index]=1;
                } else {
                    int index = parkingCol-freeSpaceLeftDistance;
                    parking[parkingRow][index]=1;
                }
            } else {
                int index = parkingCol-freeSpaceLeftDistance;
                parking[parkingRow][index]=1;
            }

            input = scanner.nextLine();
        }

    }

    private static void printDistance(int[][] parking, int entryRow, int parkingRow,int parkingCol) {
        int distance = Math.abs(entryRow-parkingRow)+parkingCol+1;
        System.out.println(distance);
    }
    private static void printParking(int[][] parking){
        for (int i = 0; i < parking.length; i++) {
            for (int j = 0; j < parking[i].length; j++) {
                System.out.print(parking[i][j] + " ");
            }
            System.out.println();
        }
    }
}
