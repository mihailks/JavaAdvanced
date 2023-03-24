package PolymorphismExercises.P01Vehicles;

public class Car extends Vehicle {
    private static final double SUMMER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double consumptionPer100km) {
        super(fuelQuantity, consumptionPer100km);
    }
    public double getSummerFuelConsumption(){
        return 0.9;
    }
}
