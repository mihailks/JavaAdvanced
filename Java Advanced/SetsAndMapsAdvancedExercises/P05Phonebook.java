package SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("-");
        Map<String,String> phoneBook = new HashMap<>();

        while (!input[0].equals("search")){

            String name = input[0];
            String number = input[1];

            phoneBook.put(name,number);

            input = scanner.nextLine().split("-");
        }

        String searchName = scanner.nextLine();
        while (!searchName.equals("stop")){


            if (phoneBook.containsKey(searchName)){
                System.out.printf("%s -> %s%n",searchName,phoneBook.get(searchName));
            } else {
                System.out.printf("Contact %s does not exist.%n",searchName);
            }
            searchName = scanner.nextLine();
        }

    }
}
