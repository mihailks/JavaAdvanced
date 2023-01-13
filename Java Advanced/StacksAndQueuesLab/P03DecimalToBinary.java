package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

        if (input<0){
            return;
        }
        if (input==0){
            System.out.println(0);
            return;
        }
        while (input!=0){
            stack.push(input%2);
            input/=2;
        }

        while (stack.size()>0){
            System.out.print(stack.pop());
        }

    }
}
