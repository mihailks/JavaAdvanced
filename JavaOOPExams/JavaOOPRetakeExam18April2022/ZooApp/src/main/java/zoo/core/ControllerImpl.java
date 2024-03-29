package zoo.core;

import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static zoo.common.ConstantMessages.*;
import static zoo.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private FoodRepository foodRepository;
    private Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        Area area;
        if (areaType.equals("WaterArea")) {
            area = new WaterArea(areaName);
        } else if (areaType.equals("LandArea")) {
            area = new LandArea(areaName);
        } else {
            throw new NullPointerException(INVALID_AREA_TYPE);
        }
        this.areas.add(area);
        return String.format(SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String foodType) {
        Food food;
        if (foodType.equals("Vegetable")) {
            food = new Vegetable();
        } else if (foodType.equals("Meat")) {
            food = new Meat();
        } else {
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        return String.format(SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Food currentFood = foodRepository.findByType(foodType);
        if (currentFood == null) {
            throw new IllegalArgumentException(String.format(NO_FOOD_FOUND, foodType));
        }
        for (Area area : areas) {
            if (area.getName().equals(areaName)){
                area.addFood(currentFood);
            }
        }
        foodRepository.remove(currentFood);
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Animal animal;

        if (animalType.equals("AquaticAnimal")) {
            animal = new AquaticAnimal(animalName, kind, price);
        } else if (animalType.equals("TerrestrialAnimal")) {
            animal = new TerrestrialAnimal(animalName, kind, price);
        } else {
            throw new IllegalArgumentException(INVALID_ANIMAL_TYPE);
        }
        Area currentArea = null;
        for (Area area : areas) {
            if (area.getName().equals(areaName)) {
                currentArea = area;
            }
        }
        String output;
        if (animal.getClass().getSimpleName().equals("AquaticAnimal")
                && currentArea.getClass().getSimpleName().equals("WaterArea")){
            currentArea.addAnimal(animal);
            output = String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        } else if (animal.getClass().getSimpleName().equals("TerrestrialAnimal")
                && currentArea.getClass().getSimpleName().equals("LandArea")){
            currentArea.addAnimal(animal);
            output = String.format(SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
        } else {
            output = AREA_NOT_SUITABLE;
        }
        return output;
    }

    @Override
    public String feedAnimal(String areaName) {
        int fedAnimals = -1;
        for (Area area : areas) {
            if (area.getName().equals(areaName)) {
                area.feed();
                fedAnimals = area.getAnimals().size();
            }
        }
        return String.format(ANIMALS_FED, fedAnimals);
    }

    @Override
    public String calculateKg(String areaName) {
        double totalWeight = -1;

        for (Area area : areas) {
            totalWeight = area.getAnimals().stream().mapToDouble(Animal::getKg).sum();
        }


        return String.format(KILOGRAMS_AREA, areaName, totalWeight);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Area field : areas) {
            sb.append(field.getInfo())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
