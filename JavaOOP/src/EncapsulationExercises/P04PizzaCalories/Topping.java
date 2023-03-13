package EncapsulationExercises.P04PizzaCalories;

public class Topping {
    public enum ToppingsModifiers {
        Meat(1.2),
        Veggies(0.8),
        Cheese(1.1),
        Sauce(0.9);
        private final double modifier;

        ToppingsModifiers(double modifier) {
            this.modifier = modifier;
        }

        public double getModifier() {
            return modifier;
        }
    }

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public void setToppingType(String toppingType) {
        boolean isFound = false;

        ToppingsModifiers[] toppingsModifiers = ToppingsModifiers.values();
        for (ToppingsModifiers toppingsModifier : toppingsModifiers) {
            if (toppingsModifier.name().equals(toppingType)) {
                isFound = true;
                break;
            }
        }

        if (isFound) {
            this.toppingType = toppingType;
        } else {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
    }

    public void setWeight(double weight) {

        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException(toppingType + " weight should be in the range [1..50].");
        }
    }

    public double calculateCalories() {
        ToppingsModifiers currentToppingsModifier = ToppingsModifiers.valueOf(this.toppingType);
        double currentModifier = currentToppingsModifier.getModifier();

        return 2 * this.weight * currentModifier;
    }


}
