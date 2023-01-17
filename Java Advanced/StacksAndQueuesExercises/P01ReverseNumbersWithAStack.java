package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            deque.push(input[i]);
        }
        for (int i = 0; i < deque.size(); i++) {
            i = -1;
            System.out.print(deque.pop() + " ");
        }
    }
}
