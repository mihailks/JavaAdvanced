package SetsAndMapsAdvancedExercises;

import java.util.*;

public class P10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> usersMapDuration = new TreeMap<>();
        Map<String, TreeSet<String>> usersMapIP = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split(" ");
            String user = input[1];
            String IP = input[0];
            int duration = Integer.parseInt(input[2]);

            usersMapDuration.putIfAbsent(user, 0);
            usersMapDuration.put(user, usersMapDuration.get(user) + duration);

            usersMapIP.putIfAbsent(user, new TreeSet<>());
            usersMapIP.get(user).add(IP);
        }
        usersMapDuration.forEach((k, v) -> {
            System.out.print(k + ": " + v + " ");
            System.out.println(usersMapIP.get(k).toString());
        });
    }
}
