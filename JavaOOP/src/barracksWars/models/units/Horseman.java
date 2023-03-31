package barracksWars.models.units;

public class Horseman extends AbstractUnit {

    private static final int HorseMan_HEALTH = 50;
    private static final int HorseMan_DAMAGE = 10;

    public Horseman() {
        super(HorseMan_HEALTH, HorseMan_DAMAGE);
    }
}
