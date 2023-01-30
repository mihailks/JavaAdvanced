package SetsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Map<String, String> emailMap = new LinkedHashMap<>();
        while (!name.equals("stop")) {

            String email = scanner.nextLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emailMap.put(name, email);
            }
            name = scanner.nextLine();
        }
        emailMap.forEach((k,v)->{
            System.out.printf("%s -> %s%n",k, v);
        });

    }
}
