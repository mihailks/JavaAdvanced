package GenericsExercises.P02GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int data = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(data);
            System.out.println(box.toString());
        }
    }
}
