package EncapsulationExercises.P04PizzaCalories;

public class Dough {
    public enum DoughModifiers {
        White(1.5),
        Wholegrain(1.0),
        Crispy(0.9),
        Chewy(1.1),
        Homemade(1.0);
        private final double modifier;

        DoughModifiers(double modifier) {
            this.modifier = modifier;
        }

        public double getModifier() {
            return modifier;
        }

    }

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        DoughModifiers[] types = DoughModifiers.values();
        for (DoughModifiers type : types) {
            if (type.name().equals(flourType)) {
                this.flourType = flourType;
            } else {
                throw new IllegalArgumentException("Invalid type of dough.");
            }
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        DoughModifiers[] types = DoughModifiers.values();
        for (DoughModifiers type : types) {
            if (type.name().equals(flourType)) {
                this.bakingTechnique = bakingTechnique;
            } else {
                throw new IllegalArgumentException("Invalid type of dough.");
            }
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }
    public double calculateCalories(){
        throw new IllegalStateException("TODO");
    }

}
