package ExercisesDefiningClasses.P01OpinionPoll.P05CarSalesman;

public class Car {
    private String carModel;
    private Engine carEngine;
    private int weight;
    private String color;


    public Car(String carModel, Engine carEngine, int weight, String color) {
        this.carModel = carModel;
        this.carEngine = carEngine;
        this.weight = weight;
        this.color = color;

    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarModel(){
        return carModel;
    }

    public void setCarEngine(Engine engine){
        this.carEngine = engine;
    }

    public Engine getCarEngine() {
        return carEngine;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(); //""

        sb.append(this.carModel).append(":").append(System.lineSeparator()); //модел на колата
        sb.append(this.carEngine.getModel()).append(":").append(System.lineSeparator()); //модел на двигателя на колата
        sb.append("Power: ").append(this.carEngine.getPower()).append(System.lineSeparator());

        //Displacement: {EngineDisplacement}
        sb.append("Displacement: ");
        //нямаме = 0; имаме = цяло число
        if (this.carEngine.getDisplacement() == 0) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.carEngine.getDisplacement()).append(System.lineSeparator());
        }

        //Efficiency: {EngineEfficiency}
        sb.append("Efficiency: ");
        //нямаме = null; имаме = текст
        if (this.carEngine.getEfficiency() == null) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.carEngine.getEfficiency()).append(System.lineSeparator());
        }

        //Weight: {CarWeight}
        sb.append("Weight: ");
        //нямаме = 0; имаме = цяло число
        if (this.weight == 0) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.weight).append(System.lineSeparator());
        }

        //Color: {CarColor}"
        sb.append("Color: ");
        //нямаме = null; имаме = текст
        if (this.color == null) {
            sb.append("n/a").append(System.lineSeparator());
        } else {
            sb.append(this.color).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
