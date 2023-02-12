package ExercisesDefiningClasses.P01OpinionPoll.P01OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person();
            person.setName(name);
            person.setAge(age);
            personsList.add(person);
        }
        personsList = personsList.stream()
                .filter(person -> person.getAge() > 30)
                .collect(Collectors.toList());

        personsList.sort(Comparator.comparing(person -> person.getName()));

        personsList.forEach(person -> System.out.println(person));
    }
}
