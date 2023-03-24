package PolymorphismExercises.P01Vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double consumptionPer100km;

    public Vehicle(double fuelQuantity, double consumptionPer100km) {
        this.fuelQuantity = fuelQuantity;
        this.consumptionPer100km = consumptionPer100km;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public abstract double getSummerFuelConsumption();

    public double getTankCapacity(double liters) {
        return liters;
    }

    public Double drive(double kilometers){
        double fuelNeeded = (this.consumptionPer100km + getSummerFuelConsumption()) * kilometers;
        if (fuelNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= fuelNeeded;
            return kilometers;
        } else {
            return null;
        }
    }
    public void refuel(double liters){
        fuelQuantity+=getTankCapacity(liters);
    }
}
