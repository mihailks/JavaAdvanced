package PolymorphismExercises.P02VehiclesExtension;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double consumptionPer100km, double tankCapacity) {
        super(fuelQuantity, consumptionPer100km, tankCapacity);
    }

    protected double getSummerFuelConsumption(){
        return 0.9;
    }
}
