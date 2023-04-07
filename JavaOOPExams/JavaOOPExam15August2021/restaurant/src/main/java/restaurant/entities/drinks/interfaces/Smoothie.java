package restaurant.entities.drinks.interfaces;

public class Smoothie extends BaseBeverage{
    public Smoothie(String name, int counter, String brand) {
        super(name, counter, 4.50, brand);
    }
}
