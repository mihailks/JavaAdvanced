package JavaAdvancedRetakeExam18August2022;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] platesInfo = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        Deque<Integer> platesQueue = new ArrayDeque<>();
        for (int i = 0; i < platesInfo.length; i++) {
            platesQueue.offer(platesInfo[i]);
        }

        int[] carsInfo = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        Deque<Integer> carsStack = new ArrayDeque<>();
        for (int i = 0; i < carsInfo.length; i++) {
            carsStack.push(carsInfo[i]);
        }

        int registeredCars = 0;
        int days = 0;

        while (!platesQueue.isEmpty() && !carsStack.isEmpty()) {

            days++;

            int currentPlate = platesQueue.peek();
            int currentCar = carsStack.peek();

            if (currentPlate > currentCar * 2) {
                carsStack.pop();
                registeredCars += currentCar;
                platesQueue.offer(platesQueue.poll() - currentCar * 2);

            } else if (currentPlate < currentCar * 2) {
                platesQueue.poll();
                registeredCars += currentPlate / 2;
                carsStack.addLast(carsStack.pop() - currentPlate / 2);

            } else {
                platesQueue.poll();
                carsStack.pop();
                registeredCars += currentCar;
            }

        }
        boolean isEmpty = false;
        if (carsStack.isEmpty() && platesQueue.isEmpty()) {
            isEmpty = true;
        }

        int unRegisteredCars = 0;
        for (int i = 0; i < carsStack.size(); i++) {
            unRegisteredCars += carsStack.pop();
            i--;
        }

        int unUsedPlates = 0;
        for (int i = 0; i < platesQueue.size(); i++) {
            unUsedPlates += platesQueue.poll();
            i--;
        }
        System.out.printf("%s cars were registered for %d days!%n", registeredCars, days);
        if (unUsedPlates > 0) {
            System.out.printf("%d license plates remain!%n", unUsedPlates);
        }
        if (unRegisteredCars > 0) {
            System.out.printf("%d cars remain without license plates!%n", unRegisteredCars);
        }
        if (isEmpty) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }

    }
}
