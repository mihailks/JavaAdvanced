package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GunRepository implements Repository<Gun>{

    private List<Gun> models;

    public GunRepository() {
        models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        //return Collections.unmodifiableCollection(models);
        return models;
    }

    @Override
    public void add(Gun model) {
        if (!models.contains(model)){
            models.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return models.remove(model);
    }

    @Override
    public Gun find(String name) {
        for (Gun model : models) {
            if (model.getName().equals(name)){
                return model;
            }
        }
        return null;
    }
}
