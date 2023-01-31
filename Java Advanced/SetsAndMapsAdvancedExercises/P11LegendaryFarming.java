package SetsAndMapsAdvancedExercises;

import java.util.*;

public class P11LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> legendaryMap = new HashMap<>();
        Map<String, Integer> junkMap = new TreeMap<>();
        while (scanner.hasNext()) {
            String[] input = scanner.nextLine().split(" ");

            for (int i = 0; i < input.length - 1; i += 2) {
                String material = input[i + 1].toLowerCase();
                int count = Integer.parseInt(input[i]);
                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    legendaryMap.putIfAbsent(material, 0);
                    legendaryMap.put(material, legendaryMap.get(material) + count);
                    if (legendaryMap.containsKey("shards") && legendaryMap.get("shards") >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        legendaryMap.put("shards", legendaryMap.get("shards") - 250);
                    } else if (legendaryMap.containsKey("fragments") && legendaryMap.get("fragments") >= 250) {
                        System.out.println("Valanyr  obtained!");
                        legendaryMap.put("fragments", legendaryMap.get("fragments") - 250);
                    } else if (legendaryMap.containsKey("motes") && legendaryMap.get("motes") >= 250) {
                        System.out.println("Dragonwrath  obtained!");
                        legendaryMap.put("motes", legendaryMap.get("motes") - 250);
                    }

                } else {
                    junkMap.putIfAbsent(material, 0);
                    junkMap.put(material, junkMap.get(material) + count);
                }
            }
        }




    }
}
