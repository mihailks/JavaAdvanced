package ExercisesDefiningClasses.P01OpinionPoll.P04RawData;

public class Engine {
    private int engineSpeed;
    private int enginePower;

    public Engine(int enginePower){
        this.enginePower=enginePower;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }
}
