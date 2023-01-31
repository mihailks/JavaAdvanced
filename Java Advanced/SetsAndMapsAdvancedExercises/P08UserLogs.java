package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        Map<String, Map<String, Integer>> userMap = new TreeMap<>();
        while (!input[0].startsWith("end")) {

            String IP = input[0].split("=")[1];
            String user = input[2].split("=")[1];

            userMap.putIfAbsent(user, new LinkedHashMap<>());

            userMap.get(user).putIfAbsent(IP, 0);
            userMap.get(user).put(IP, userMap.get(user).get(IP) + 1);
            input = scanner.nextLine().split(" ");
        }

       /* userMap.forEach((k, v) -> {
            System.out.println(k + ": ");

            v.forEach((IP, count) -> {
                if (counter == 1) {
                    System.out.println(IP + " => " + count + ".");
                } else {
                    System.out.println(IP + " => " + count + ",");
                }
                counter--;
            });
        });*/

        for (String user : userMap.keySet()) {
            System.out.println(user + ": ");
            Map<String, Integer> currentIp = userMap.get(user);
            int counter = currentIp.size();
            for (String IP : currentIp.keySet()) {
                if (counter == 1) {
                    System.out.println(IP + " => " + currentIp.get(IP) + ".");
                } else {
                    System.out.print(IP + " => " + currentIp.get(IP) + ", ");
                }
                counter--;
            }
        }
    }
}
