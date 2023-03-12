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
    }

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public void setToppingType(String toppingType) {

        ToppingsModifiers[] toppingsModifiers = ToppingsModifiers.values();
        for (ToppingsModifiers toppingsModifier : toppingsModifiers) {
            if (toppingsModifier.equals(toppingsModifier)){
                this.toppingType = toppingType;
                break;
            }
        }



    }

    public void setWeight(double weight) {

        ToppingsModifiers[] toppingsModifiers = ToppingsModifiers.values();
        for (ToppingsModifiers toppingsModifier : toppingsModifiers) {
            if (toppingsModifier.equals())
        }


        this.weight = weight;
    }
    public double calculateCalories(){
        throw new IllegalStateException("TODO");
    }

}
