package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.cocktails.interfaces.Cocktail;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CocktailRepositoryImpl implements CocktailRepository<Cocktail> {
    Map<String, Cocktail> cocktails;

    public CocktailRepositoryImpl() {
        this.cocktails = new HashMap<>();
    }

    @Override
    public Cocktail getByName(String name) {
        if (cocktails.containsKey(name)){
            return cocktails.get(name);
        } else {
            return null;
        }
    }

    @Override
    public Collection<Cocktail> getAll() {
        return Collections.unmodifiableCollection(cocktails.values());
    }

    @Override
    public void add(Cocktail cocktail) {
        this.cocktails.put(cocktail.getName(), cocktail);
    }
}
