package JavaAdvancedExam26Oct2019;

import java.util.*;

public class P01DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] malesInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] femalesInput = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Deque<Integer> malesStack = new ArrayDeque<>();
        Deque<Integer> femalesQueue = new ArrayDeque<>();

        for (int i = 0; i < malesInput.length; i++) {
            malesStack.push(malesInput[i]);
        }

        for (int i = 0; i < femalesInput.length; i++) {
            femalesQueue.offer(femalesInput[i]);
        }
        int matches = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int currentMale = malesStack.peek();
            int currentFemale = femalesQueue.peek();

            if (currentMale <= 0) {
                malesStack.pop();
                continue;
            }
            if (currentFemale <= 0) {
                femalesQueue.poll();
                continue;
            }
            if (currentMale % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
                continue;
            }
            if (currentFemale % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                continue;
            }
            if (currentMale == currentFemale) {
                matches++;
                malesStack.pop();
                femalesQueue.poll();
            } else {
                femalesQueue.poll();
                malesStack.push(malesStack.pop() - 2);
            }
        }
        System.out.println("Matches: " + matches);
        if (malesStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            String printMales = malesStack.toString().replaceAll("[\\[\\]]", "");
            System.out.println("Males left: " + printMales);
        }
        if (femalesQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            String printFemales = femalesQueue.toString().replaceAll("[\\[\\]]", "");
            System.out.println("Females left: " + printFemales);
        }
    }
}
