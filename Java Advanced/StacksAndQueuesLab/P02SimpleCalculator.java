package StacksAndQueuesLab;

import java.util.*;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split(" ");
        List<String> inputList = Arrays.asList(input);
        Collections.reverse(inputList);

        for (String part : inputList) {
            stack.push(part);
        }

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int second = Integer.parseInt(stack.pop());

            int result = 0;

            switch (op) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
            }
            stack.push("" + result);
        }
        System.out.println(stack.peek());

    }
}
