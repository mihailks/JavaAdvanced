package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        Deque<String> namesDeque = new ArrayDeque<>();

        namesDeque.addAll(List.of(names));
        while (namesDeque.size()>1){
            for (int i = 1; i < n; i++) {
                String temp = namesDeque.poll();
                namesDeque.offer(temp);
            }
            System.out.println("Removed " + namesDeque.poll());
        }
        System.out.println("Last is " + namesDeque.peek());
    }
}
