package ExercisesDefiningClasses.P01OpinionPoll.P03SpeedRacing;


import java.util.*;

public class Main {
    private static final String END_CONDITION = "End";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Car> carsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String model = input[0];
            double fuel = Double.parseDouble(input[1]);
            double cost = Double.parseDouble(input[2]);

            Car car = new Car(model, fuel, cost);
            carsMap.put(model, car);
        }
        String[] input = scanner.nextLine().split(" ");
        while (!input[0].equals(END_CONDITION)) {
            String modelToDrive = input[1];
            int kmToDrive = Integer.parseInt(input[2]);

                Car currentCar = carsMap.get(modelToDrive);
                    if (!currentCar.drive(kmToDrive)) {
                        System.out.println("Insufficient fuel for the drive");
                    }
            input = scanner.nextLine().split(" ");
        }

        for(Car car : carsMap.values()){
            System.out.println(car.toString());
        }
    }
}
