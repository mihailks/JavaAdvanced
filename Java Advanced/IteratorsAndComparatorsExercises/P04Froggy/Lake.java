package IteratorsAndComparatorsExercises.P04Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> {
    List<Integer> numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
    private class Frog implements Iterator<Integer> {
        int index = 0;
        boolean firsRoundFinished = false;

        @Override
        public boolean hasNext() {
            return index < numbers.size();
        }

        @Override
        public Integer next() {
            int element = numbers.get(index);
            index += 2;
            if (index >= numbers.size() && !firsRoundFinished) {
                index = 1;
                firsRoundFinished = true;
            }
            return element;
        }
    }
}