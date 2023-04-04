package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.*;

public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = new DelicacyRepositoryImpl();
        this.cocktailRepository = new CocktailRepositoryImpl();
        this.boothRepository = new BoothRepositoryImpl();
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        if (type.equals("Gingerbread")) {
            Delicacy delicacy = new Gingerbread(name, price);
        } else if (type.equals("Stolen")) {
            Delicacy delicacy = new Stolen(name, price);
        }

        return null;
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        //TODO
        return null;
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        //TODO
        return null;
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        //TODO
        return null;
    }

    @Override
    public String leaveBooth(int boothNumber) {
        //TODO
        return null;
    }

    @Override
    public String getIncome() {
        //TODO
        return null;
    }
}
