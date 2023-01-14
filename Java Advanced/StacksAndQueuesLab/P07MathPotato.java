package StacksAndQueuesLab;

import java.util.*;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        PriorityQueue<String> namesDeque = new PriorityQueue<>();
        int counter = 1;
        Collections.addAll(namesDeque, names);

        while (namesDeque.size() > 1) {
            for (int i = 1; i < n; i++) {
                String temp = namesDeque.poll();
                namesDeque.offer(temp);
            }

            if (isPrime(counter)) {
                System.out.println("Prime " + namesDeque.peek());
            } else {
                System.out.println("Removed " + namesDeque.poll());
            }
            counter++;
        }
        System.out.println("Last is " + namesDeque.peek());
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
