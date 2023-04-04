package magicGame.core;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.MagicianImpl;
import magicGame.models.magicians.Wizard;
import magicGame.models.magics.BlackMagic;
import magicGame.models.magics.Magic;
import magicGame.models.magics.RedMagic;
import magicGame.models.region.Region;
import magicGame.models.region.RegionImpl;
import magicGame.repositories.interfaces.MagicRepositoryImpl;
import magicGame.repositories.interfaces.MagicianRepositoryImpl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static magicGame.common.ExceptionMessages.*;
import static magicGame.common.OutputMessages.SUCCESSFULLY_ADDED_MAGIC;
import static magicGame.common.OutputMessages.SUCCESSFULLY_ADDED_MAGICIAN;

public class ControllerImpl implements Controller {

    private MagicRepositoryImpl magics;
    private MagicianRepositoryImpl magicians;
    private Region region;

    public ControllerImpl() {
        this.magics = new MagicRepositoryImpl();
        this.magicians = new MagicianRepositoryImpl();
        this.region = new RegionImpl();
    }

    @Override
    public String addMagic(String type, String name, int bulletsCount) {
        Magic currentMagic;
        if (type.equals("RedMagic")){
            currentMagic = new RedMagic(name,bulletsCount);
        }else if (type.equals("BlackMagic")){
            currentMagic = new BlackMagic(name,bulletsCount);
        } else {
            throw new IllegalArgumentException(INVALID_MAGIC_TYPE);
        }
        magics.addMagic(currentMagic);
        return String.format(SUCCESSFULLY_ADDED_MAGIC, name);
    }

    @Override
    public String addMagician(String type, String username, int health, int protection, String magicName) {
        Magician currentMagician;

        Magic currentMagic = magics.findByName(magicName);
        if (currentMagic==null){
            throw new NullPointerException(MAGIC_CANNOT_BE_FOUND);
        }

        if (type.equals("BlackWidow")){
            currentMagician = new BlackWidow(username,health,protection,currentMagic);
        } else if (type.equals("Wizard")){
            currentMagician = new Wizard(username,health,protection,currentMagic);
        } else {
            throw new IllegalArgumentException(INVALID_MAGICIAN_TYPE);
        }
        magicians.addMagician(currentMagician);
        return String.format(SUCCESSFULLY_ADDED_MAGICIAN, username);
    }

    @Override
    public String startGame() {
        return region.start(magicians.getData());
    }

    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        List<Magician> magicianList =
                magicians
                        .getData()
                        .stream()
                        .sorted(Comparator.comparing(Magician::getHealth)
                                .thenComparing(Magician::getUsername)
                                .thenComparing(m->m.getClass().getSimpleName()))
                        .collect(Collectors.toList());

        for (Magician magician : magicianList) {
            int health = magician.getHealth();
            if (magician.getHealth() < 0){
                health = 0;
            }
            int protection = magician.getProtection();
            if (magician.getProtection() < 0){
                protection = 0;
            }
            stringBuilder.append(String.format("%s: %s",magician.getClass().getSimpleName(), magician.getUsername())).append(System.lineSeparator())
                    .append(String.format("Health: %d", health)).append(System.lineSeparator())
                    .append(String.format("Protection: %d", protection)).append(System.lineSeparator())
                    .append(String.format("Magic: %s",magician.getMagic().getName())).append(System.lineSeparator());
        }


        return stringBuilder.toString().trim();




    }
}
