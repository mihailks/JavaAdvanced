package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.Collection;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {
    @Override
    public Delicacy getByName(String name) {
        return null;
    }

    @Override
    public Collection<Delicacy> getAll() {
        return null;
    }

    @Override
    public void add(Delicacy delicacy) {

    }
}
