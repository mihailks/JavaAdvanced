package ExercisesDefiningClasses.P01OpinionPoll.P05CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfEngines = Integer.parseInt(scanner.nextLine());

        List<Engine> enginesList = new ArrayList<>();
        List<Car> carsList = new ArrayList<>();

        for (int i = 0; i < numberOfEngines; i++) {
            String[] input = scanner.nextLine().split(" ");

            String model = input[0];
            int power = Integer.parseInt(input[1]);

            Engine engine = new Engine(model, power);

            if (input.length == 4) {
                int displacement = Integer.parseInt(input[2]);
                String efficiency = input[3];
                engine.setDisplacement(displacement);
                engine.setEfficiency(efficiency);
            }

            if (input.length == 3) {
                if (Character.isDigit(input[2].charAt(0))) {
                    int displacement = Integer.parseInt(input[2]);
                    engine.setDisplacement(displacement);
                } else {
                    String efficiency = input[2];
                    engine.setEfficiency(efficiency);
                }
            }

            enginesList.add(engine);
        }

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] input = scanner.nextLine().split(" ");
            String model = input[0];
            String currentEngine = input[1];
            int weight = 0;
            String color = null;

            if (input.length==4){
                weight = Integer.parseInt(input[2]);
                color = input[3];
            }
            if (input.length==3){
                if (Character.isDigit(input[2].charAt(0))){
                    weight = Integer.parseInt(input[2]);
                } else {
                    color = input[2];
                }
            }
            Engine carEngine = null;
            for (Engine engine : enginesList) {
                if (currentEngine.equals(engine.getModel())){
                    carEngine=engine;
                }
            }

            Car car = new Car(model,carEngine,weight,color);
            carsList.add(car);
        }

        for (Car car : carsList) {
            System.out.print(car.toString());
        }
    }
}
