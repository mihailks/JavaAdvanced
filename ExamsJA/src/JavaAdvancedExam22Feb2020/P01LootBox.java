package JavaAdvancedExam22Feb2020;

import java.lang.reflect.Array;
import java.util.*;

public class P01LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstInfo = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> firstBoxQueue = new ArrayDeque<>();

        for (int i = 0; i < firstInfo.length; i++) {
            firstBoxQueue.offer(firstInfo[i]);
        }

        int[] secondInfo = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> secondBoxStack = new ArrayDeque<>();

        for (int i = 0; i < secondInfo.length; i++) {
            secondBoxStack.push(secondInfo[i]);
        }

        List<Integer> lootList = new ArrayList<>();

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
            int firstLoot = firstBoxQueue.peek();
            int secondLoot = secondBoxStack.peek();

            if ((firstLoot + secondLoot) % 2 == 0) {
                lootList.add(firstLoot + secondLoot);
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                firstBoxQueue.addLast(secondBoxStack.pop());
            }
        }

        if (firstBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }
        if (secondBoxStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        int sum = 0;
        for (int i = 0; i < lootList.size(); i++) {
            sum += lootList.get(i);
        }
        if (sum >= 100) {
            System.out.println("Your loot was epic! Value: " + sum);
        } else {
            System.out.println("Your loot was poor... Value: " + sum);
        }
    }
}
