package SetsAndMapsAdvancedExercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class P09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|");


        Map<String, Map<String, Long>> countryMap = new LinkedHashMap<>();

        while (!input[0].equals("report")) {

            String country = input[1];
            String city = input[0];
            Long population = Long.valueOf(input[2]);

            countryMap.putIfAbsent(country, new LinkedHashMap<>());
            countryMap.get(country).put(city, population);

            input = scanner.nextLine().split("\\|");
        }

        //zaebi...
        countryMap.entrySet().stream().sorted((e1, e2) -> {
            Long totalPopulationFirst = countryMap.get(e1.getKey()).entrySet().stream().mapToLong(Map.Entry::getValue).sum();
            Long totalPopulationSecond = countryMap.get(e2.getKey()).entrySet().stream().mapToLong(Map.Entry::getValue).sum();
            return Long.compare(totalPopulationSecond, totalPopulationFirst);
        }).forEach(entry -> {
            System.out.print(entry.getKey() + " ");
            StringBuilder builder = new StringBuilder();
            AtomicReference<Long> totalPopulation = new AtomicReference<>((long) 0);
            countryMap.get(entry.getKey()).entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(e -> {
                        builder.append(String.format("=>%s: %d%n", e.getKey(), e.getValue()));
                        totalPopulation.updateAndGet(v -> v + e.getValue());
                    });
            System.out.println(String.format("(total population: %s)", totalPopulation.toString()));
            System.out.print(builder.toString());
        });

    }
}
