package PolymorphismLab.P03Animals;

public class Dog extends Animal {


    public Dog(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my favourite food is %s\n" +
                "DJAAF", getName(), getFavoriteFood());
    }

}