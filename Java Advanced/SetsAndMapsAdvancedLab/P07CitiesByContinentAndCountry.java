package SetsAndMapsAdvancedLab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Map<String, List<String>>> citiesMap = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            citiesMap.putIfAbsent(continent, new LinkedHashMap<>());
            citiesMap.get(continent).putIfAbsent(country, new ArrayList<>());
            citiesMap.get(continent).get(country).add(city);
        }
        citiesMap.forEach((k, v) -> {
            System.out.println(k + ":");
            v.forEach((country, city) ->
                System.out.println("  " + country + " -> " + String.join(", ",city)));
        });
    }
}
