package PolymorphismLab.P04WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, AnimalType animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        String formattedWeight = decimalFormat.format(this.getAnimalWeight());
        return String.format("%s[%s, %s, %s, %s]"
                , this.getAnimalType(), this.getAnimalName(), formattedWeight, this.getLivingRegion(), this.getFoodEaten());
    }
}
