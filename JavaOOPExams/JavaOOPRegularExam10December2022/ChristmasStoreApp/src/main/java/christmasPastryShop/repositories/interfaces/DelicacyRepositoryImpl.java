package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.*;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {
    private Map<String, Delicacy> delicacies;

    public DelicacyRepositoryImpl() {
        this.delicacies = new HashMap<>();
    }

    @Override
    public Delicacy getByName(String name) {
        if (delicacies.containsKey(name)){
            return delicacies.get(name);
        } else {
            return null;
        }
    }

    @Override
    public Collection<Delicacy> getAll() {
        return Collections.unmodifiableCollection(delicacies.values());
    }

    @Override
    public void add(Delicacy delicacy) {
        delicacies.put(delicacy.getName(), delicacy);
    }
}
