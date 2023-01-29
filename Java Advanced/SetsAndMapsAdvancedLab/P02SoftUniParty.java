package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guests = scanner.nextLine();
        Set<String> guestsList = new TreeSet<>();
        while (!guests.equals("PARTY")){
            guestsList.add(guests);
            guests = scanner.nextLine();
        }
        guests = scanner.nextLine();

        while (!guests.equals("END")){
            guestsList.remove(guests);
            guests = scanner.nextLine();
        }
        System.out.println(guestsList.size());
        for (String guest : guestsList) {
            System.out.println(guest);
        }

    }
}
