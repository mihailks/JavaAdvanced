package EncapsulationExercises.P04PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppingList;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppingList(numberOfToppings);
    }

    public void setName(String name) {
        if (name.length() >= 15 || name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public void setToppingList(int numberOfToppings) {
        if (numberOfToppings >= 0 && numberOfToppings <= 10) {
            this.toppingList = new ArrayList<>();
        } else {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }
    public void addTopping(Topping topping){
        throw new IllegalStateException("TODO");
    }
    public double getOverallCalories(){
        throw new IllegalStateException("TODO");
    }
}
