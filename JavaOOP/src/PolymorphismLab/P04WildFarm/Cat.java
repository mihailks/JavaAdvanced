package PolymorphismLab.P04WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {
    private String breed;

    public Cat(String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalName, AnimalType.Cat, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public boolean willEatFood(Food food) {
        return true;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("###.##");
        String formattedWeight = decimalFormat.format(this.getAnimalWeight());

        return String.format("%s[%s, %s, %s, %s, %d]"
                , this.getAnimalType(), this.getAnimalName() ,this.breed, formattedWeight, this.getLivingRegion(), this.getFoodEaten());
    }
}
