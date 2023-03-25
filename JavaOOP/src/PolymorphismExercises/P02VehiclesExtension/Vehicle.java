package PolymorphismExercises.P02VehiclesExtension;

public abstract class Vehicle {
    private double fuelQuantity;
    private double consumptionPer100km;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double consumptionPer100km, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.consumptionPer100km = consumptionPer100km;
        this.tankCapacity = tankCapacity;
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected abstract double getSummerFuelConsumption();

    protected double getTankCapacity(double liters) {
        return liters;
    }

    public Double drive(double kilometers) {
        double fuelNeeded = (this.consumptionPer100km + getSummerFuelConsumption()) * kilometers;
        if (fuelNeeded <= this.fuelQuantity) {
            this.fuelQuantity -= fuelNeeded;
            return kilometers;
        } else {
            return null;
        }
    }

    public void refuel(double liters) {
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.fuelQuantity + liters > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity += getTankCapacity(liters);
    }
}
