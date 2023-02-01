package SetsAndMapsAdvancedExercises;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;

public class P11LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> legendaryMap = new HashMap<>();
        Map<String, Integer> junkMap = new TreeMap<>();
        legendaryMap.put("shards", 0);
        legendaryMap.put("fragments", 0);
        legendaryMap.put("motes", 0);
        boolean hasFound = false;
        while (scanner.hasNext()) {
            String[] input = scanner.nextLine().split(" ");

            for (int i = 0; i < input.length - 1; i += 2) {
                String material = input[i + 1].toLowerCase();
                int count = Integer.parseInt(input[i]);

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    legendaryMap.put(material, legendaryMap.get(material) + count);

                    if (legendaryMap.get("shards") >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        legendaryMap.put("shards", legendaryMap.get("shards") - 250);
                        hasFound = true;
                    } else if (legendaryMap.get("fragments") >= 250) {
                        System.out.println("Valanyr obtained!");
                        legendaryMap.put("fragments", legendaryMap.get("fragments") - 250);
                        hasFound = true;
                    } else if (legendaryMap.get("motes") >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        legendaryMap.put("motes", legendaryMap.get("motes") - 250);
                        hasFound = true;
                    }

                } else {
                    junkMap.putIfAbsent(material, 0);
                    junkMap.put(material, junkMap.get(material) + count);
                }
                if (hasFound) {
                    break;
                }
            }
            if (hasFound) {
                break;
            }
        }

        legendaryMap.entrySet().stream().sorted((e1, e2) -> {
                    if (e2.getValue().compareTo(e1.getValue()) == 0) {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                    return e2.getValue().compareTo(e1.getValue());
                })
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        junkMap.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}
