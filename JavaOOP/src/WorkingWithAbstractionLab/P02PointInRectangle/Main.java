package WorkingWithAbstractionLab.P02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] recCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point recBottomLeft = new Point(recCoordinates[0], recCoordinates[1]);
        Point recTopRight = new Point(recCoordinates[2], recCoordinates[3]);
        Rectangle rectangle = new Rectangle(recBottomLeft,recTopRight);

        int numberOfPoints = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfPoints; i++) {
            String[] input = scanner.nextLine().split(" ");
            int pointX = Integer.parseInt(input[0]);
            int pointY = Integer.parseInt(input[1]);
            Point currentPoint = new Point(pointX,pointY);
            if (rectangle.Contains(currentPoint)){
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }

    }
}
