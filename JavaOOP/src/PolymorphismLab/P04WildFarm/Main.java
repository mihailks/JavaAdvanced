package PolymorphismLab.P04WildFarm;

import java.util.Scanner;

public class Main {
    // not compatible with judges tests
    private static final String END_COMMAND = "End";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] animalInput = scanner.nextLine().split(" ");

        while (!animalInput[0].equals(END_COMMAND)) {
            String[] foodInput = scanner.nextLine().split(" ");

            Animal animal = createAnimal(animalInput);
            Food food = createFood(foodInput);

            animal.makeSound();
            animal.eat(food);
            System.out.println(animal);


            animalInput = scanner.nextLine().split(" ");
        }


    }

    private static Food createFood(String[] foodInput) {
        FoodType foodType = FoodType.valueOf(foodInput[0]);
        if (foodType == FoodType.Meat) {
            return new Meat(Integer.parseInt(foodInput[1]));
        } else if (foodType == FoodType.Vegetable) {
            return new Vegetable(Integer.parseInt(foodInput[1]));
        }
        return null;
    }

    private static Animal createAnimal(String[] animalInput) {
        AnimalType animalType = AnimalType.valueOf(animalInput[0]);
        if (animalType == AnimalType.Cat) {
            return new Cat(animalInput[1], Double.parseDouble(animalInput[2]), animalInput[3], animalInput[4]);
        } else if (animalType == AnimalType.Tiger) {
            return new Tiger(animalInput[1], Double.parseDouble(animalInput[2]), animalInput[3]);
        } else if (animalType == AnimalType.Zebra) {
            return new Zebra(animalInput[1], Double.parseDouble(animalInput[2]), animalInput[3]);
        } else if (animalType == AnimalType.Mouse){
            return new Mouse(animalInput[1], Double.parseDouble(animalInput[2]), animalInput[3]);
        }
        return null;
    }
}
