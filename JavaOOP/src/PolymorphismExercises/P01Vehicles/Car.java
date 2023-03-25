package PolymorphismExercises.P01Vehicles;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double consumptionPer100km) {
        super(fuelQuantity, consumptionPer100km);
    }
    protected double getSummerFuelConsumption(){
        return 0.9;
    }
}
