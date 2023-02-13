package IteratorsAndComparatorsExercises.P02Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
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

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int iteratorIndex;

            @Override
            public boolean hasNext() {
                return this.iteratorIndex < elements.size();
            }

            @Override
            public String next() {
                return elements.get(this.iteratorIndex++);
            }
        };
    }
}