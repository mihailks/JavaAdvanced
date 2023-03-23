package PolymorphismLab.P04WildFarm;

public class Mouse extends Mammal{
    public Mouse(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, AnimalType.Mouse ,animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public boolean willEatFood(Food food) {
        return food instanceof Vegetable;
    }
}
