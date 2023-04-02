package org.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedList {

    List<Integer> elements = new ArrayList<>();

    public void add(Integer element) {

        if (element == null) {
            throw new IllegalArgumentException();
        }

        int indexToAddAt = -1;
        for (int i = 0; i < this.elements.size(); i++) {
            if (element < this.elements.get(i)) {
                indexToAddAt = i;
                break;
            }
        }

        if (indexToAddAt==-1) {
            this.elements.add(element);
        } else {
            this.elements.add(indexToAddAt, element);
        }

    }

    public List<Integer> getAll() {
        return Collections.unmodifiableList(this.elements);
    }

    public int getSize() {
        return this.elements.size();
    }

    public static SortedList merge(SortedList a, SortedList b) {
        SortedList merged = new SortedList();

        for (Integer element : a.getAll()) {
            merged.add(element);
        }
        for (Integer element : b.getAll()) {
            merged.add(element);
        }
        return merged;
    }

}
