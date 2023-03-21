package PolymorphismLab.P03Animals;

public abstract class Animal {

    private String name;
    private String favouriteFood;

    public abstract String explainSelf();

    public Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public String getName() {
        return name;
    }

    public String getFavoriteFood() {
        return favouriteFood;
    }
}
