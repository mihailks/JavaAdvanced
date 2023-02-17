package Others;

import java.util.*;

public class P01SecondNature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] flowerInfo = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> flowersQueue = new ArrayDeque<>();

        for (int i = 0; i < flowerInfo.length; i++) {
            flowersQueue.offer(flowerInfo[i]);
        }

        int[] bucketsInfo = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> bucketsStack = new ArrayDeque<>();

        for (int i = 0; i < bucketsInfo.length; i++) {
            bucketsStack.push(bucketsInfo[i]);
        }
        List<Integer> secondNatureFlowersList = new ArrayList<>();
        while (!bucketsStack.isEmpty() && !flowersQueue.isEmpty()) {
            int flower = flowersQueue.poll();
            int bucket = bucketsStack.pop();

            if (bucket == flower) {
                secondNatureFlowersList.add(flower);

            } else if (flower < bucket) {
                int nextBucket = 0;
                if (!bucketsStack.isEmpty()) {
                    nextBucket = bucketsStack.pop();
                }
                bucketsStack.push(bucket - flower + nextBucket);

            } else {
                flower -= bucket;
                flowersQueue.addFirst(flower);

            }
        }
        for (int i = 0; i < bucketsStack.size(); i++) {
            System.out.print(bucketsStack.pop() + " ");
            i--;
        }
        for (int i = 0; i < flowersQueue.size(); i++) {
            System.out.print(flowersQueue.poll() + " ");
            i--;
        }
        System.out.println();
        if (secondNatureFlowersList.size() > 0) {
            for (Integer flower : secondNatureFlowersList) {
                System.out.print(flower + " ");
            }
        } else {
            System.out.println("None");
        }
    }
}