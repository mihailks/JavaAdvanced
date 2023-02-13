package IteratorsAndComparatorsExercises.P06StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person first, Person second) {
        int result = Integer.compare(first.getName().length(), second.getName().length());
        if (result == 0) {
            result = Character.compare(first.getFirstLetterOfName(), second.getFirstLetterOfName());
        }
        return result;
    }
}