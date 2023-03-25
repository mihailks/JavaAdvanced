package PolymorphismExercises.P02VehiclesExtension;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double consumptionPer100km, double tankCapacity) {
        super(fuelQuantity, consumptionPer100km, tankCapacity);
    }

    protected double getSummerFuelConsumption(){
        return 1.6;
    }

    @Override
    protected double getTankCapacity(double liters) {
        return liters*0.95;
    }
}
