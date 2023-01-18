package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    stack.push(scanner.nextInt());
                    break;
                case 2:
                    if (stack.size()>0){
                        stack.pop();
                    }
                    break;
                case 3:
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
