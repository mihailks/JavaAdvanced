package SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        Map<String, Map<String, Double>> shopMap = new TreeMap<>();


        while (!input[0].equals("Revision")) {

            String shop = input[0];
            String product = input[1];
            double price = Double.parseDouble(input[2]);

            shopMap.putIfAbsent(shop, new LinkedHashMap<>());
            shopMap.get(shop).put(product, price);

            input = scanner.nextLine().split(", ");
        }

        shopMap.forEach((k, v) -> {
                    System.out.println(k + "->");
                    v.forEach((product, price) ->
                            System.out.println("Product: " + product + ", Price: " + String.format("%.1f", price)));
                }
        );
    }
}

