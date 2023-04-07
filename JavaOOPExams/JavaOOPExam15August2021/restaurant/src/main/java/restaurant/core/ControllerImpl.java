package restaurant.core;

import restaurant.core.interfaces.Controller;
import restaurant.entities.drinks.interfaces.Fresh;
import restaurant.entities.drinks.interfaces.Smoothie;
import restaurant.entities.healthyFoods.interfaces.HealthyFood;
import restaurant.entities.drinks.interfaces.Beverages;
import restaurant.entities.healthyFoods.interfaces.Salad;
import restaurant.entities.healthyFoods.interfaces.VeganBiscuits;
import restaurant.entities.tables.interfaces.InGarden;
import restaurant.entities.tables.interfaces.Indoors;
import restaurant.entities.tables.interfaces.Table;
import restaurant.repositories.interfaces.*;

import static restaurant.common.ExceptionMessages.*;
import static restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;
    private double totalMoney = 0;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository
            , BeverageRepository<Beverages> beverageRepository
            , TableRepository<Table> tableRepository) {
        this.healthFoodRepository = new HealthFoodRepositoryImpl();
        this.beverageRepository = new BeverageRepositoryImpl();
        this.tableRepository = new TableRepositoryImpl();
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {
        HealthyFood food;
        if (type.equals("Salad")) {
            food = new Salad(name, price);
        } else if (type.equals("VeganBiscuits")) {
            food = new VeganBiscuits(name, price);
        } else {
            throw new IllegalArgumentException("No such Food");
        }

        if (healthFoodRepository.foodByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
        }
        healthFoodRepository.add(food);
        return String.format(FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {
        Beverages beverage;
        if (type.equals("Smoothie")) {
            beverage = new Smoothie(name, counter, brand);
        } else if (type.equals("Fresh")) {
            beverage = new Fresh(name, counter, brand);
        } else {
            throw new IllegalArgumentException("No such beverage");
        }

        Beverages testBeverage = beverageRepository.beverageByName(name, brand);

        if (beverageRepository.beverageByName(name, brand) != null) {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }
        beverageRepository.add(beverage);
        return String.format(BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;
        if (type.equals("Indoors")) {
            table = new Indoors(tableNumber, capacity);
        } else if (type.equals("InGarden")) {
            table = new InGarden(tableNumber, capacity);
        }

        if (tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED, tableNumber));
        }

        tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {
        Table tableToReserve = tableRepository.getAllEntities().stream()
                .filter(t -> t.getSize() >= numberOfPeople)
                .filter(t -> !t.isReservedTable())
                .findFirst().orElse(null);
        if (tableToReserve == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }
        tableToReserve.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, tableToReserve.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        Table table = null;
        for (Table t : tableRepository.getAllEntities()) {
            if (t.getTableNumber() == tableNumber) {
                table = t;
            }
        }
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        HealthyFood food = healthFoodRepository.foodByName(healthyFoodName);
        if (food == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        } else {
            return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
        }
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        Table table = null;
        for (Table t : tableRepository.getAllEntities()) {
            if (t.getTableNumber() == tableNumber) {
                table = t;
            }
        }
        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }
        Beverages beverage = beverageRepository.beverageByName(name, brand);
        if (beverage == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        } else {
            return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
        }
    }

    @Override
    public String closedBill(int tableNumber) {
        Table table = tableRepository.byNumber(tableNumber);
        double currentBill = table.bill();
        table.clear();

        totalMoney += currentBill;
        return String.format(BILL, tableNumber, currentBill);
    }


    @Override
    public String totalMoney() {
        return String.format(TOTAL_MONEY, totalMoney);
    }
}
