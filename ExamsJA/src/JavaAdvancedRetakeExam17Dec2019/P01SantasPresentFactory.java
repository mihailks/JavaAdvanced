package JavaAdvancedRetakeExam17Dec2019;

import java.util.*;

public class P01SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> materialsStack = new ArrayDeque<>();
        Deque<Integer> magicLevelQueue = new ArrayDeque<>();
        Map<String, Integer> productsMap = new HashMap<>();
        Map<String, Integer> finishedToysMap = new TreeMap<>();

        productsMap.put("Doll", 150);
        productsMap.put("Wooden train", 250);
        productsMap.put("Teddy bear", 300);
        productsMap.put("Bicycle", 400);

        finishedToysMap.put("Doll", 0);
        finishedToysMap.put("Wooden train", 0);
        finishedToysMap.put("Teddy bear", 0);
        finishedToysMap.put("Bicycle", 0);

        int[] inputMaterials = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] inputMagicItems = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < inputMaterials.length; i++) {
            materialsStack.push(inputMaterials[i]);
        }

        for (int i = 0; i < inputMagicItems.length; i++) {
            magicLevelQueue.offer(inputMagicItems[i]);
        }

        while (!materialsStack.isEmpty() && !magicLevelQueue.isEmpty()) {
            int currentMaterial = materialsStack.peek();
            int currentMagicLevel = magicLevelQueue.peek();
            int multiply = currentMaterial * currentMagicLevel;

            if (multiply == 0) {
                if (currentMaterial == 0) {
                    materialsStack.pop();
                }
                if (currentMagicLevel == 0) {
                    magicLevelQueue.poll();
                }
            } else if (productsMap.containsValue(multiply)) {
                for (Map.Entry<String, Integer> entry : productsMap.entrySet()) {
                    if (multiply == entry.getValue()) {
                        finishedToysMap.put(entry.getKey(), finishedToysMap.get(entry.getKey()) + 1);
                        break;
                    }
                }
                materialsStack.pop();
                magicLevelQueue.poll();
            } else if (multiply > 0) {
                magicLevelQueue.poll();
                materialsStack.push(materialsStack.pop() + 15);
            } else if (multiply < 0) {
                materialsStack.pop();
                magicLevelQueue.poll();
                materialsStack.push(currentMaterial + currentMagicLevel);
            }
        }

        if (finishedToysMap.get("Doll") > 0 && finishedToysMap.get("Wooden train") > 0 ||
                finishedToysMap.get("Teddy bear") > 0 && finishedToysMap.get("Bicycle") > 0) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()) {
            String printMats = materialsStack.toString().replaceAll("[\\[\\]]", "");
            System.out.println("Materials left: " + printMats);
        }
        if (!magicLevelQueue.isEmpty()) {
            String printMagic = magicLevelQueue.toString().replaceAll("[\\[\\]]", "");
            System.out.println("Magic left: " + printMagic);
        }

        finishedToysMap.entrySet().forEach(entry -> {
            if (entry.getValue() > 0) {
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }
        });
    }
}
