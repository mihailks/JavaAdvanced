package PolymorphismExercises.P01Vehicles;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double consumptionPer100km) {
        super(fuelQuantity, consumptionPer100km);
    }

    public double getSummerFuelConsumption(){
        return 1.6;
    }

    @Override
    public double getTankCapacity(double liters) {
        return liters*0.95;
    }
}
