package JavaAdvancedExam26Oct2019.rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit){
        if (this.data.size() < capacity)
            data.add(rabbit);
    }

    public boolean removeRabbit(String name) {
        return this.data.removeIf(rabbit -> rabbit.getName().equals(name));
    }

    public void removeSpecies(String species){
        this.data.removeIf(r-> r.getSpecies().equals(species));
    }
    
    public int count() {
        return this.data.size();
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbitToReturn = null;

        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                rabbitToReturn = rabbit;
                rabbit.setAvailable();
                break;
            }
        }
        return rabbitToReturn;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {

        List<Rabbit> soldRabbits = this.data.stream()
                .filter(r -> r.getSpecies().equals(species))
                .collect(Collectors.toList());

        this.data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
        return soldRabbits;
    }

    //    public String report(){
//        String print = this.data.stream()
//                .map(r->r.toString())
//                .collect(Collectors.joining("\n"));
//
//        return String.format("Rabbits available at %s:%n%s",this.getName(),print);
//    }
//}
    public String report() {

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Rabbits available at %s:%n", this.getName()));

        for (Rabbit rabbit : data) {

            if (rabbit.isAvailable())
                sb.append(rabbit).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}