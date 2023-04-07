package restaurant.repositories.interfaces;

import restaurant.entities.healthyFoods.interfaces.HealthyFood;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class HealthFoodRepositoryImpl implements HealthFoodRepository<HealthyFood> {

    private Map<String, HealthyFood> foodsMap;

    public HealthFoodRepositoryImpl() {
        this.foodsMap  = new LinkedHashMap<>();
    }

    @Override
    public HealthyFood foodByName(String name) {
        return foodsMap.get(name);
    }

    @Override
    public Collection<HealthyFood> getAllEntities() {
        return Collections.unmodifiableCollection(foodsMap.values());
    }

    @Override
    public void add(HealthyFood entity) {
        foodsMap.put(entity.getName(), entity);
    }
}
