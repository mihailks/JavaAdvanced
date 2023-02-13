package IteratorsAndComparatorsExercises.P05ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }



    @Override
    public int compareTo(Person otherPerson) {
        int result = this.getName().compareTo(otherPerson.getName());
        if (result == 0) {
            result = Integer.compare(this.getAge(),otherPerson.getAge());
            if (result == 0) {
                result = this.getTown().compareTo(otherPerson.getTown());
            }
        }

        return result;
    }
}