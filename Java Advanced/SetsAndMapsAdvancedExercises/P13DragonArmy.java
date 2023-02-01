package SetsAndMapsAdvancedExercises;

import java.util.*;

public class P13DragonArmy {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> typesMap = new LinkedHashMap<>();
        Map<String, String> namesMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            int damage;
            int health;
            int armor;
            if (!input[2].equals("null")) {
                damage = Integer.parseInt(input[2]);
            } else {
                damage = 45;
            }
            if (!input[3].equals("null")) {
                health = Integer.parseInt(input[3]);
            } else {
                health = 250;
            }
            if (!input[4].equals("null")) {
                armor = Integer.parseInt(input[4]);
            } else {
                armor = 10;
            }

//FIXME
//            typesMap.putIfAbsent(type, new ArrayList<>());
//            ArrayList<Integer> specs = new ArrayList<>();
//            specs.get(specs.get(0) + damage);
//            typesMap.put(type, specs.get())



        }

    }
}

