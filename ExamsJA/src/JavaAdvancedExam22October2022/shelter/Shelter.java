package shelter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shelter {
    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal){
        if (this.capacity > this.data.size())   {
            this.data.add(animal);
        }
    }
    public boolean remove(String name){
        return this.data.removeIf(animal -> animal.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker){
        return this.data.stream().filter(animal ->
                animal.getName().equals(name) && animal.getCaretaker().equals(caretaker)).findAny().orElse(null);
    }
    public Animal getOldestAnimal(){
        return this.data.stream().max(Comparator.comparing(Animal::getAge)).orElse(null);
    }
    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        String stringPrint = this.data.stream()
                .map(p -> p.print())
                .collect(Collectors.joining("\n"));
        return String.format("The shelter has the following animals:%n%s", stringPrint);
    }

}
