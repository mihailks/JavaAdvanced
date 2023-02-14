package JavaAdvancedRetakeExam14December2022;

import java.util.*;
import java.util.stream.Collectors;

public class P01ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] foodInfo = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] staminaInfo = Arrays
                .stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Deque<String> peaksName = new ArrayDeque<>();
        Deque<Integer> peaksHardness = new ArrayDeque<>();
        peaksName.offer("Vihren");
        peaksName.offer("Kutelo");
        peaksName.offer("Banski Suhodol");
        peaksName.offer("Polezhan");
        peaksName.offer("Kamenitza");

        peaksHardness.offer(80);
        peaksHardness.offer(90);
        peaksHardness.offer(100);
        peaksHardness.offer(60);
        peaksHardness.offer(70);

        List<String> peaksDone = new ArrayList<>();
        int daysCounter = 0;
        Deque<Integer> food = new ArrayDeque<>(); //stack
        for (int i = 0; i < foodInfo.length; i++) {
            food.push(foodInfo[i]);
        }
        Deque<Integer> stamina = new ArrayDeque<>(); //Queue
        for (int i = 0; i < staminaInfo.length; i++) {
            stamina.offer(staminaInfo[i]);
        }

        while (!peaksName.isEmpty() && !peaksHardness.isEmpty() && daysCounter < 7
                && !food.isEmpty() && !stamina.isEmpty()) {
            daysCounter++;
            int currentFood = food.pop();
            int currentStamina = stamina.poll();


            if (currentFood + currentStamina >= peaksHardness.peek()) {
                peaksDone.add(peaksName.poll());
                peaksHardness.poll();
            }

        }
        if (peaksDone.size() >= 5) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (!peaksDone.isEmpty()) {
            System.out.println("Conquered peaks:");
            for (String peak : peaksDone) {
                System.out.println(peak);
            }
        }
    }
}
