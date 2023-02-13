package GenericsExercises.P07CustomList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> {
    private List<T> values;

    public CustomList() {
        this.values = new ArrayList<>();
    }

    public void add(T element) {
        this.values.add(element);
    }

    public void remove(int index) {
        this.values.remove(index);
    }

    public boolean contains(T element) {
        return this.values.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        checkIndex(firstIndex);
        checkIndex(secondIndex);
        T temp = this.values.get(firstIndex);
        this.values.set(firstIndex, this.values.get(secondIndex));
        this.values.set(secondIndex, temp);
    }

    public long countGreaterThan(T element) {
        return this.values
                .stream()
                .filter(value -> value.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return this.values.stream()
                .max(Comparable::compareTo)
                .get();
    }

    public T getMin() {
        return this.values.stream()
                .min(Comparable::compareTo)
                .get();
    }

    public void print() {
        values.forEach(element -> System.out.println(element.toString()));
    }

    @Override
    public String toString() {
        return values.stream()
                .map(Object::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.values.size() - 1) {
            throw new IndexOutOfBoundsException("Index Out of Bounds: for input " + index);
        }
    }


}