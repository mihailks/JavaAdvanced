package IteratorsAndComparatorsExercises.P01ListyIterator;


import java.util.List;

public class ListyIterator {
    private List<String> elements;
    int index;

    public ListyIterator(String... elements) {
        this.elements = List.of(elements);
        this.index = 0;
    }

    public boolean hasNext() {
        return index < this.elements.size() - 1;
    }

    public boolean move() {
        if (hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    public void print() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(this.elements.get(index));


    }

}