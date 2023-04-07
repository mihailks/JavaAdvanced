package restaurant.repositories.interfaces;

import restaurant.entities.drinks.interfaces.Beverages;

import java.util.*;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private List<Beverages> beverages;

    public BeverageRepositoryImpl() {
        this.beverages = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        Beverages currentBeverage = null;

        for (Beverages beverage : beverages) {
            if (beverage.getName().equals(drinkName) && beverage.getBrand().equals(drinkBrand)) {
                currentBeverage = beverage;
            }
        }

        return currentBeverage;
//        return beverages.stream().filter(b -> b.getName().equals(drinkName)
//                                           && b.getBrand().equals(drinkBrand))
//                .findFirst().orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(beverages);
    }

    @Override
    public void add(Beverages entity) {
        beverages.add(entity);
    }
}
