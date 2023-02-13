package IteratorsAndComparatorsExercises.P06StrategyPattern;


public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public char getFirstLetterOfName() {
        return this.name.toUpperCase().charAt(0);
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }
}