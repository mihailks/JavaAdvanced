package Others;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liliesInfo = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> liliesStack = new ArrayDeque<>();

        for (int i = 0; i < liliesInfo.length; i++) {
            liliesStack.push(liliesInfo[i]);
        }

        int[] rosesInfo = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> rosesQueue = new ArrayDeque<>();

        for (int i = 0; i < rosesInfo.length; i++) {
            rosesQueue.offer(rosesInfo[i]);
        }
        int wreaths = 0;
        int sum = 0;
        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {
            int lilies = liliesStack.pop();
            int roses = rosesQueue.poll();

            if (lilies + roses > 15) {
                while (lilies + roses > 15) {
                    lilies -= 2;
                }
            }
            if (lilies + roses == 15) {
                wreaths++;
            } else {
                sum += lilies + roses;
            }
        }
//        for (int i = 0; i < liliesStack.size(); i++) {
//            sum += liliesStack.pop();
//            i--;
//        }
//        for (int i = 0; i < rosesQueue.size(); i++) {
//            sum += rosesQueue.pop();
//            i--;
//        }
        wreaths += sum / 15;

        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n", 5 - wreaths);
        }
    }
//    public static int decreaseByTwo(int lilies){
//        lilies-=2;
//        return lilies;
//    }
}
