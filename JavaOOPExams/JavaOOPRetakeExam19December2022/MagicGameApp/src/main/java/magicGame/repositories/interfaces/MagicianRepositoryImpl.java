package magicGame.repositories.interfaces;

import magicGame.models.magicians.Magician;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static magicGame.common.ExceptionMessages.INVALID_MAGICIAN_REPOSITORY;

public class MagicianRepositoryImpl implements MagicianRepository<Magician>{
    private Collection<Magician> magicians;

    public MagicianRepositoryImpl() {
        this.magicians = new ArrayList<>();
    }

    @Override
    public Collection<Magician> getData() {
        return this.magicians;
    }

    @Override
    public void addMagician(Magician model) {
        if (model == null){
            throw new NullPointerException(INVALID_MAGICIAN_REPOSITORY);
        }
        magicians.add(model);
    }

    @Override
    public boolean removeMagician(Magician model) {
        return magicians.remove(model);
    }

    @Override
    public Magician findByUsername(String name) {
        for (Magician magician : magicians) {
            if (magician.getUsername().equals(name)){
                return magician;
            }
        }
        return null;
    }
}
