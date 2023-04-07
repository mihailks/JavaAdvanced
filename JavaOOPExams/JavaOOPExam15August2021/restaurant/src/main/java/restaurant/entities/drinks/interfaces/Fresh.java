package restaurant.entities.drinks.interfaces;

public class Fresh extends BaseBeverage{
    public Fresh(String name, int counter, String brand) {
        super(name, counter, 3.50, brand);
    }
}
