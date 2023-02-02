package SetsAndMapsAdvancedExercises;

import java.util.*;

public class P13DragonArmy {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, int[]>> dragonsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            int[] stats = new int[3];
            int damage;
            int health;
            int armor;
            if (!input[2].equals("null")) {
                stats[0] = Integer.parseInt(input[2]);
            } else {
                stats[0] = 45;
            }
            if (!input[3].equals("null")) {
                stats[1] = Integer.parseInt(input[3]);
            } else {
                stats[1] = 250;
            }
            if (!input[4].equals("null")) {
                stats[2] = Integer.parseInt(input[4]);
            } else {
                stats[2] = 10;
            }


            dragonsMap.putIfAbsent(type, new TreeMap<>());
            dragonsMap.get(type).putIfAbsent(name, new int[3]);
            dragonsMap.get(type).put(name, stats);
        }
            dragonsMap.forEach((key1, value1) -> {
                List<Integer> sumDamage = new ArrayList<>();
                List<Integer> sumHealth = new ArrayList<>();
                List<Integer> sumArmor = new ArrayList<>();
                value1.forEach((key, value) -> {
                    sumDamage.add(value[0]);
                    sumHealth.add(value[1]);
                    sumArmor.add(value[2]);
                });
                double avgDamage = 1.0 * (sumDamage.stream().mapToInt(Integer::intValue).sum()) / sumDamage.size();
                double avgHealth = 1.0 * (sumHealth.stream().mapToInt(Integer::intValue).sum()) / sumHealth.size();
                double avgArmor = 1.0 * (sumArmor.stream().mapToInt(Integer::intValue).sum()) / sumArmor.size();
                System.out.printf("%s::(%.2f/%.2f/%.2f)\n", key1, avgDamage, avgHealth, avgArmor);
                value1.forEach((key, value) ->
                        System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", key, value[0], value[1], value[2]));
            });

    }
}
