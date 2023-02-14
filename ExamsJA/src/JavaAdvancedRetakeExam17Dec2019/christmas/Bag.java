package christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    //bag.add(present);
    public void add(Present present) {
        if (this.count() >= this.capacity) {
            return;
        }
        this.data.add(present);
    }

    public boolean remove(String name) {
        return this.data.removeIf(present -> present.getName().equals(name));
        // remove present from the map in bag and returns true;
    }

    public Present heaviestPresent() {
        double heaviest = -1;
        int index = -1;
        int counter = 0;
        for (Present present : data) {
            counter++;
            if (present.getWeight() > heaviest) {
                index = counter-1;
            }
        }

        return this.data.get(index);
    }


    public Present getPresent(String name) {
        for (Present present : data) {
            if (present.getName().equals(name)) {
                return present;
            }
        }
        return null;
    }

    public String report() {
        String stringPrint = this.data.stream()
                .map(p -> p.toString())
                .collect(Collectors.joining("\n"));
        return String.format("%s bag contains:%n%s", this.getColor(), stringPrint);
    }
}
