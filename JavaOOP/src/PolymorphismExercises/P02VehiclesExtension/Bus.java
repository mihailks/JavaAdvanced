package PolymorphismExercises.P02VehiclesExtension;

public class Bus extends Vehicle {
    boolean nextDriveIsEmpty;


    public Bus(double fuelQuantity, double consumptionPer100km, double tankCapacity) {
        super(fuelQuantity, consumptionPer100km, tankCapacity);
    }

    @Override
    protected double getSummerFuelConsumption() {
        if (nextDriveIsEmpty) {
            return 0;
        }
        return 1.4;
    }

    @Override
    public Double drive(double kilometers) {
        nextDriveIsEmpty = false;
        return super.drive(kilometers);

    }

    public void setUpEmptyDrive() {
        nextDriveIsEmpty = true;
    }
}
