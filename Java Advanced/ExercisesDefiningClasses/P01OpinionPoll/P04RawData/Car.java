package ExercisesDefiningClasses.P01OpinionPoll.P04RawData;

public class Car {
    private String model;

    public Car(String model){
        this.model = model;
    }

    @Override
    public String toString() {
        return model;
    }
}
