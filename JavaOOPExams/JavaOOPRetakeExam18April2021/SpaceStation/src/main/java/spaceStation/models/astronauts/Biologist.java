package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{

    public Biologist(String name) {
        super(name, 70);
    }

    @Override
    public void breath() {
        this.setOxygen(Math.max(getOxygen() - 5, 0));
    }
}
