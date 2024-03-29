package PolymorphismExercises.P01Vehicles;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double consumptionPer100km) {
        super(fuelQuantity, consumptionPer100km);
    }

    protected double getSummerFuelConsumption(){
        return 1.6;
    }

    @Override
    protected double getTankCapacity(double liters) {
        return liters*0.95;
    }
}
