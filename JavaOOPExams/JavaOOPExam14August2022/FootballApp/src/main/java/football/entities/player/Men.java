package football.entities.player;

public class Men extends BasePlayer{

    //private String playOnlyOn = "NaturalGrass";

    public Men(String name, String nationality, int strength) {
        super(name, nationality, 85.50, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength()+145);
    }
}
