package StacksAndQueuesLab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.SortedMap;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Deque<String> backStack = new ArrayDeque<>();
        Deque<String> forwardsStack = new ArrayDeque<>();

        while (!input.equals("Home")) {

            switch (input){
                case "back":
                    if (backStack.size()<2){
                        System.out.println("no previous URLs");
                    } else {
                        String currentBackURL = backStack.pop();
                        forwardsStack.push(currentBackURL);
                        System.out.println(backStack.peek());
                    }
                    break;

                case "forward":
                    if (forwardsStack.isEmpty()){
                        System.out.println("no next URLs");
                    } else {
                        String currentForwardURL = forwardsStack.pop();
                        backStack.push(currentForwardURL);
                        System.out.println(currentForwardURL);
                    }
                    break;

                default:
                    backStack.push(input);
                    System.out.println(input);
                    forwardsStack.clear();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
