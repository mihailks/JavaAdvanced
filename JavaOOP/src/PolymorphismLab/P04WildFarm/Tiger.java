package PolymorphismLab.P04WildFarm;

public class Tiger extends Felime {
    private String livingRegion;

    public Tiger(String animalName, Double animalWeight, String livingRegion) {
        super(animalName, AnimalType.Tiger, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public boolean willEatFood(Food food) {
        return food instanceof Meat;
    }
}
