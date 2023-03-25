package PolymorphismExercises.P01Vehicles;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final String CAR_NAME = "Car";
    public static final String TRUCK_NAME = "Truck";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("###.##");

        String[] carInfo = scanner.nextLine().split(" ");
        String[] truckInfo = scanner.nextLine().split(" ");
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));

        Map<String, Vehicle> vehiclesByName = new LinkedHashMap<>();
        vehiclesByName.put(CAR_NAME, car);
        vehiclesByName.put(TRUCK_NAME, truck);


        for (int i = 0; i < numberOfCommands; i++) {
            String[] commands = scanner.nextLine().split(" ");
            String operation = commands[0];
            String vehicleName = commands[1];
            Vehicle vehicle = vehiclesByName.get(vehicleName);
            switch (operation) {
                case "Drive":
                    double consumption = Double.parseDouble(commands[2]);
                    Double traveledKM = vehicle.drive(consumption);
                    if (traveledKM != null) {
                        System.out.printf("%s travelled %s km%n", vehicleName, decimalFormat.format(traveledKM));
                    } else {
                        System.out.printf("%s needs refueling%n", vehicleName);
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(commands[2]);
                    vehicle.refuel(liters);
                    break;
                default:
                    throw new IllegalStateException("Unknown command " + commands[0]);
            }
        }
        System.out.println("Car: " + String.format("%.2f", vehiclesByName.get(CAR_NAME).getFuelQuantity()));
        System.out.println("Truck: " + String.format("%.2f", vehiclesByName.get(TRUCK_NAME).getFuelQuantity()));
    }
}

