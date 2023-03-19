package InterfacesAndAbstractionLab.P02CarShopExtended;

public class Audi extends CarImpl implements Rentable {

    private final Integer minRentDay;
    private final Double pricePerDay;

    public Audi(String model, String color, int horsePower
            , String countryProduced, int minRentDay, double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator() + String.format("Minimum rental period of %d days. Price per day %.6f",
                this.getMinRentDay(),
                this.getPricePerDay());
    }
}
