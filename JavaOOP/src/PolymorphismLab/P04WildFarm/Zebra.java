package PolymorphismLab.P04WildFarm;

public class Zebra extends Mammal {
    public Zebra(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, AnimalType.Zebra, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public boolean willEatFood(Food food) {
        return food instanceof Vegetable;
    }


}
