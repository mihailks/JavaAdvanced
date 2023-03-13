package EncapsulationExercises.P04PizzaCalories;

public class Dough {
    public enum FlourType {
        White(1.5),
        Wholegrain(1.0);
        private final double modifier;

        FlourType(double modifier) {
            this.modifier = modifier;
        }

        public double getModifier() {
            return modifier;
        }
    }

    public enum BakingTechnique {
        Crispy(0.9),
        Chewy(1.1),
        Homemade(1.0);
        private final double modifier;

        BakingTechnique(double modifier) {
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
        boolean isFound = false;
        FlourType[] types = FlourType.values();
        for (FlourType type : types) {
            if (type.name().equals(flourType)) {
                isFound = true;
                break;
            }
        }
        if (isFound) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        boolean isFound = false;
        BakingTechnique[] types = BakingTechnique.values();
        for (BakingTechnique type : types) {
            if (type.name().equals(bakingTechnique)) {
                isFound = true;
                break;
            }
        }
        if (isFound) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories() {
        FlourType currentFlourType = FlourType.valueOf(this.flourType);
        double flourCalories = currentFlourType.getModifier();

        BakingTechnique currentBakingTechnique = BakingTechnique.valueOf(this.bakingTechnique);
        double bakingTechniqueCalories = currentBakingTechnique.getModifier();

        return 2 * weight * flourCalories * bakingTechniqueCalories;
    }

}
