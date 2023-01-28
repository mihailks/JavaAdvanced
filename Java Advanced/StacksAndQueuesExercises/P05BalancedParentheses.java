package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Deque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = false;
        for (char bracket : input.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if (bracket == ')' || bracket == ']' || bracket == '}') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                char lastOpenBracket = stack.pop();
                if (lastOpenBracket == '(' && bracket == ')') {
                    isBalanced = true;
                } else if (lastOpenBracket == '[' && bracket == ']') {
                    isBalanced = true;
                } else if (lastOpenBracket == '{' && bracket == '}') {
                    isBalanced = true;
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
