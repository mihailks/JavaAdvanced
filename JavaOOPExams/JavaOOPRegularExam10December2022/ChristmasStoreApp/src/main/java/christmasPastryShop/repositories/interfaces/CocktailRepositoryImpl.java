package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import java.util.Collection;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {
    @Override
    public Cocktail getByName(String name) {
        return null;
    }

    @Override
    public Collection<Cocktail> getAll() {
        return null;
    }

    @Override
    public void add(Cocktail cocktail) {

    }
}
