package InheritanceExercises.P06Animals;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animalType = scanner.nextLine();

        while (!animalType.equals("Beast!")) {
            String[] animalParameters = scanner.nextLine().split("\\s+");
            Animal animal = null;
            try {
                animal = parseAnimal(animalType, animalParameters);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }

            if (animal != null) {
                System.out.println(animal.toString());
            }

            animalType = scanner.nextLine();
        }
    }

    private static Animal parseAnimal(String animalType, String[] animalParameters) {
        switch (animalType) {
            case "Cat":
                return new Cat(animalParameters[0], Integer.parseInt(animalParameters[1]), animalParameters[2]);
            case "Dog":
                return new Dog(animalParameters[0], Integer.parseInt(animalParameters[1]), animalParameters[2]);
            case "Frog":
                return new Frog(animalParameters[0], Integer.parseInt(animalParameters[1]), animalParameters[2]);
            case "Kitten":
                return new Kitten(animalParameters[0], Integer.parseInt(animalParameters[1]));
            case "Tomcat":
                return new Tomcat(animalParameters[0], Integer.parseInt(animalParameters[1]));
            default:
                throw new IllegalStateException("Unknown animal: " + animalType);
        }
    }
}