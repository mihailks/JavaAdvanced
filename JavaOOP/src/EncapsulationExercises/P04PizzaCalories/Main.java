package EncapsulationExercises.P04PizzaCalories;

import java.util.Scanner;

public class Main {

    private static final String END_CONDITION = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        try {
            String[] pizzaInput = scanner.nextLine().split(" ");
            String[] doughInput = scanner.nextLine().split(" ");

            Pizza pizza = new Pizza(pizzaInput[1], Integer.parseInt(pizzaInput[2]));

            String flour = doughInput[1];
            String bakingTechnique = doughInput[2];
            int grams = Integer.parseInt(doughInput[doughInput.length - 1]);

            Dough dough = new Dough(flour, bakingTechnique, grams);

            pizza.setDough(dough);

            String[] toppingInput = scanner.nextLine().split(" ");

            while (!toppingInput[0].equals(END_CONDITION)) {
                String toppingType = toppingInput[1];
                int weightInGrams = Integer.parseInt(toppingInput[2]);

                Topping topping = new Topping(toppingType, weightInGrams);

                pizza.addTopping(topping);

                toppingInput = scanner.nextLine().split(" ");
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

