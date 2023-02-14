package JavaAdvancedExam22October2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] caffeineInfo = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> caffeineStack = new ArrayDeque<>();
        for (int i = 0; i < caffeineInfo.length; i++) {
            caffeineStack.push(caffeineInfo[i]);
        }
        int[] drinksInfo = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> drinksQueue = new ArrayDeque<>();
        for (int i = 0; i < drinksInfo.length; i++) {
            drinksQueue.offer(drinksInfo[i]);
        }

        int caffeine = 0;
        while (!caffeineStack.isEmpty() && !drinksQueue.isEmpty()) {

            int currentCaffeine = caffeineStack.peek();
            int currentDrink = drinksQueue.peek();

            if (currentCaffeine * currentDrink + caffeine <= 300) {
                caffeineStack.pop();
                drinksQueue.poll();
                caffeine += currentCaffeine * currentDrink;
            } else {
                caffeineStack.pop();
                drinksQueue.offer(drinksQueue.poll());
                caffeine -= 30;
                if (caffeine < 0) {
                    caffeine = 0;
                }
            }
        }
        if (drinksQueue.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            String printMales = drinksQueue.toString().replaceAll("[\\[\\]]", "");
            System.out.println("Drinks left: " + printMales);
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", caffeine);


    }
}
