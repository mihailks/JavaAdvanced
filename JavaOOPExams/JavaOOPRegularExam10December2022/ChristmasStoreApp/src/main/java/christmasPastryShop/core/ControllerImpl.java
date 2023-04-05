package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.*;

import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;

import static christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = new DelicacyRepositoryImpl();
        this.cocktailRepository = new CocktailRepositoryImpl();
        this.boothRepository = new BoothRepositoryImpl();
        this.totalIncome = 0;
    }


    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy;
        if (type.equals("Gingerbread")) {
            delicacy = new Gingerbread(name, price);
        } else if (type.equals("Stolen")) {
            delicacy = new Stolen(name, price);
        } else {
            throw new IllegalArgumentException("no such delicacy");
        }

        if (delicacyRepository.getByName(name) != null) {
            String msg = String.format(FOOD_OR_DRINK_EXIST, type, name);
            throw new IllegalArgumentException(msg);
        }
        delicacyRepository.add(delicacy);
        return String.format(DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail;
        if (type.equals("Hibernation")) {
            cocktail = new Hibernation(name, size, brand);
        } else if (type.equals("MulledWine")) {
            cocktail = new MulledWine(name, size, brand);
        } else {
            throw new IllegalArgumentException("no such cocktail");
        }

        if (cocktailRepository.getByName(name) != null) {
            String msg = String.format(FOOD_OR_DRINK_EXIST, type, name);
            throw new IllegalArgumentException(msg);
        }
        cocktailRepository.add(cocktail);
        return String.format(COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth;
        if (type.equals("OpenBooth")) {
            booth = new OpenBooth(boothNumber, capacity);
        } else if (type.equals("PrivateBooth")) {
            booth = new PrivateBooth(boothNumber, capacity);
        } else {
            throw new IllegalArgumentException("No such booth");
        }
        if (boothRepository.getByNumber(boothNumber) != null) {
            String msg = String.format(BOOTH_EXIST, boothNumber);
            throw new IllegalArgumentException(msg);
        }
        boothRepository.add(booth);

        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {

        Booth boothToReserve = boothRepository.getAll().stream()
                .filter(b -> b.getCapacity() >= numberOfPeople)
                .filter(Predicate.not(Booth::isReserved))
                .findFirst()
                .orElse(null);
        if (boothToReserve == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        boothToReserve.reserve(numberOfPeople);
        return String.format(BOOTH_RESERVED, boothToReserve.getBoothNumber(), numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        double incomeOfTheBooth = booth.getBill();
        totalIncome += incomeOfTheBooth;
        booth.clear();
        return String.format(BILL, boothNumber, incomeOfTheBooth);

    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME, totalIncome);
    }
}
