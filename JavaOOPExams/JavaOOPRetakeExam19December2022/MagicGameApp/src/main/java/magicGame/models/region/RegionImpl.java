package magicGame.models.region;

import magicGame.models.magicians.BlackWidow;
import magicGame.models.magicians.Magician;
import magicGame.models.magicians.Wizard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegionImpl implements Region {
    @Override
    public String start(Collection<Magician> magicians) {
        List<Magician> blackWidows = new ArrayList<>();
        List<Magician> wizards = new ArrayList<>();
        for (Magician magician : magicians) {
            if (magician.getClass().getSimpleName().equals("Wizard")) {
                wizards.add(magician);
            } else {
                blackWidows.add(magician);
            }
        }
        while (!blackWidows.isEmpty() && !wizards.isEmpty()) {
            Wizard wizard = (Wizard) wizards.get(0);
            BlackWidow blackWidow = (BlackWidow) blackWidows.get(0);

            blackWidow.takeDamage(wizard.getMagic().fire());
            if (!blackWidow.isAlive()){
                blackWidows.remove(blackWidow);
                continue;
            }

            wizard.takeDamage(blackWidow.getMagic().fire());
            if (!wizard.isAlive()){
                wizards.remove(wizard);
            }

        }

        if (blackWidows.isEmpty()) {
            return "Wizards win!";
        } else {
            return "Black widows win!";
        }
    }
}
