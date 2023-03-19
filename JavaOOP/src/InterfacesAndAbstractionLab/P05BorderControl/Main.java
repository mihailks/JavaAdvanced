package InterfacesAndAbstractionLab.P05BorderControl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Identifiable> inhabitants = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] parts = input.split(" ");

            Identifiable next;
            if (parts.length == 2) {
                next = new Robot(parts[0], parts[1]);
            } else {
                next = new Citizen(parts[0], Integer.parseInt(parts[1]), parts[2]);
            }

            inhabitants.add(next);

            input = scanner.nextLine();
        }

        String badIdSuffix = scanner.nextLine();


        inhabitants
                .stream()
                .map(Identifiable::getId)
                .filter(id -> id.endsWith(badIdSuffix))
                .forEach(System.out::println);
    }
}
