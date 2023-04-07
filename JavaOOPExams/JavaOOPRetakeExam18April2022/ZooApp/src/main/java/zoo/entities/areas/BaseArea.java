package zoo.entities.areas;

import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static zoo.common.ExceptionMessages.AREA_NAME_NULL_OR_EMPTY;
import static zoo.common.ExceptionMessages.NOT_ENOUGH_CAPACITY;

public abstract class BaseArea implements Area {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Animal> animals;

    protected BaseArea(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.animals = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Collection<Animal> getAnimals() {
        return Collections.unmodifiableCollection(animals);
    }

    @Override
    public Collection<Food> getFoods() {
        return Collections.unmodifiableCollection(foods);
    }

    @Override
    public int sumCalories() {
        return foods.stream().mapToInt(Food::getCalories).sum();
    }

    @Override
    public void addAnimal(Animal animal) {
        if (this.capacity > animals.size()) {
            this.animals.add(animal);
        } else {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        animals.stream().forEach(Animal::eat);
    }

    @Override
    public String getInfo() {
        String animalReport = animals.isEmpty() ? "none"
                : animals.stream().map(Animal::getName)
                .collect(Collectors.joining(" "));

        return String.format("%s (%s):%n"
                        + "Animals: %s%n" +
                        "Foods: %s%n" +
                        "Calories: %s"
                , this.name, this.getClass().getSimpleName()
                , animalReport
                , foods.size()
                , sumCalories());
    }
}
