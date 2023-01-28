package StacksAndQueuesExercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        Deque<String> backUpStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");

            switch (input[0]){
                case "1":
                    backUpStack.push(String.valueOf(text));
                    text.append(input[1]);
                    break;
                case "2":
                    backUpStack.push(String.valueOf(text));
                    int startIndex = Integer.parseInt(input[1]);
                    text.delete(text.length()-startIndex,text.length());
                    break;
                case "3":
                    int printIndex = Integer.parseInt(input[1]);
                    System.out.println(text.charAt(printIndex-1));
                    break;
                case "4":
                    if (!backUpStack.isEmpty()){
                        String currentText = backUpStack.pop();
                        text= new StringBuilder(currentText);
                    }
                    break;

            }

        }

    }
}
