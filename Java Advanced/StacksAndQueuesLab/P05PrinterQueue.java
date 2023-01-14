package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Deque<String> printQueue = new ArrayDeque<>();
        while (!input.equals("print")) {
            if (!input.equals("cancel")) {
                printQueue.offer(input);
            }

            if (printQueue.size() == 0 && input.equals("cancel")) {
                System.out.println("Printer is on standby");
            } else if (input.equals("cancel")) {
                System.out.println("Canceled " + printQueue.poll());
            }

            input = scanner.nextLine();
        }
        while (printQueue.size()>0){
            System.out.println(printQueue.poll());
        }
    }
}
