package PolymorphismLab.P04WildFarm;

public abstract class Animal {
    private String animalName;
    private AnimalType animalType;
    private Double animalWeight;
    private int foodEaten;

    public Animal(String animalName, AnimalType animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;

        this.foodEaten = 0;
    }

    protected String getAnimalName() {
        return animalName;
    }

    protected AnimalType getAnimalType() {
        return animalType;
    }

    protected Double getAnimalWeight() {
        return animalWeight;
    }

    protected int getFoodEaten() {
        return foodEaten;
    }

    public abstract void makeSound();

    public abstract boolean willEatFood(Food food);
    public void eat(Food food){
        if (!willEatFood(food)){
            System.out.printf("%ss are not eating that type of food!%n", this.animalType.name());
            return;
        }
        this.foodEaten=+food.getQuantity();
    }
}
