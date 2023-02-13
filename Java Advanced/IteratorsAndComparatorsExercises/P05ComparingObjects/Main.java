package IteratorsAndComparatorsExercises.P05ComparingObjects;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> peopleList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] personData = input.split("\\s+");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            String town = personData[2];
            Person person = new Person(name, age, town);
            peopleList.add(person);

            input = scanner.nextLine();
        }

        int index = Integer.parseInt(scanner.nextLine()) - 1;
        Person personToCompare = peopleList.get(index);

        int totalPeople = peopleList.size();
        long samePeople = 0;
        long differentPeople = 0;

        samePeople = peopleList.stream()
                .filter(p -> p.compareTo(personToCompare) == 0)
                .count();

        differentPeople = peopleList.stream()
                .filter(p -> p.compareTo(personToCompare) != 0)
                .count();

        if (samePeople < 2) {
            System.out.println("No matches");
        } else {
            System.out.println(samePeople + " " + differentPeople + " " + totalPeople);
        }
    }
}