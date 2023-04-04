package christmasPastryShop.entities.cocktails.interfaces;

public class MulledWine extends BaseCocktail {
    private static final double hibernationPrice = 4.50;

    protected MulledWine(String name, int size, String brand) {
        super(name, size, hibernationPrice, brand);
    }
}

