package ExercisesDefiningClasses.P01OpinionPoll.P03SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double consumption;
    private int distance;

    public Car(String model, double fuel, double consumption) {
        this.model = model;
        this.fuel = fuel;
        this.consumption = consumption;
        distance = 0;
    }

    public boolean drive(int kmToDrive) {
        if (kmToDrive * consumption <= fuel) {
            this.fuel -= kmToDrive * consumption;
            this.distance += kmToDrive;
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuel, this.distance);
    }
}
