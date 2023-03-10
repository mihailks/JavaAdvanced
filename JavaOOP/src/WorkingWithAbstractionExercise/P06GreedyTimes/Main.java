
package WorkingWithAbstractionExercise.P06GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String GEM = "Gem";
    private static final String CASH = "Cash";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();

        for (int i = 0; i < safe.length; i += 2) {
            String itemAsString = safe[i];
            long itemAmount = Long.parseLong(safe[i + 1]);

            String typeOfItem = "";

            typeOfItem = getItemName(bagCapacity, bag, itemAsString, itemAmount, typeOfItem);
            if (typeOfItem == null) continue;

            switch (typeOfItem) {
                case GEM:
                    if (handgeGem(bag, itemAmount, typeOfItem)) continue;
                    break;
                case CASH:
                    if (handleCash(bag, itemAmount, typeOfItem)) continue;
                    break;
            }

            if (!bag.containsKey(typeOfItem)) {
                bag.put((typeOfItem), new LinkedHashMap<>());
            }

            if (!bag.get(typeOfItem).containsKey(itemAsString)) {
                bag.get(typeOfItem).put(itemAsString, 0L);
            }


            bag.get(typeOfItem).put(itemAsString, bag.get(typeOfItem).get(itemAsString) + itemAmount);

            if (typeOfItem.equals("Gold")) {
            } else if (typeOfItem.equals("Gem")) {
            } else if (typeOfItem.equals("Cash")) {
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue()
                    .values()
                    .stream()
                    .mapToLong(l -> l)
                    .sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue()
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static String getItemName(long bagCapacity, LinkedHashMap<String, LinkedHashMap<String, Long>> bag, String itemAsString, long itemAmount, String typeOfItem) {
        if (itemAsString.length() == 3) {
            typeOfItem = "Cash";
        } else if (itemAsString.toLowerCase().endsWith("gem")) {
            typeOfItem = "Gem";
        } else if (itemAsString.toLowerCase().equals("gold")) {
            typeOfItem = "Gold";
        }

        if (typeOfItem.equals("")) {
            return null;
        } else if (bagCapacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + itemAmount) {
            return null;
        }
        return typeOfItem;
    }

    private static boolean handleCash(LinkedHashMap<String, LinkedHashMap<String, Long>> bag, long itemAmount, String typeOfItem) {
        if (!bag.containsKey(typeOfItem)) {
            if (bag.containsKey("Gem")) {
                if (itemAmount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                    return true;
                }
            } else {
                return true;
            }
        } else if (bag.get(typeOfItem).values().stream().mapToLong(e -> e).sum() + itemAmount > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
            return true;
        }
        return false;
    }

    private static boolean handgeGem(LinkedHashMap<String, LinkedHashMap<String, Long>> bag, long itemAmount, String typeOfItem) {
        if (!bag.containsKey(typeOfItem)) {
            if (bag.containsKey("Gold")) {
                if (itemAmount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                    return true;
                }
            } else {
                return true;
            }
        } else if (bag.get(typeOfItem)
                .values()
                .stream()
                .mapToLong(e -> e)
                .sum() + itemAmount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
            return true;
        }
        return false;
    }
}