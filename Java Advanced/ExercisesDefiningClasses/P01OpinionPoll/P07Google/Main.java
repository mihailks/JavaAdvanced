package ExercisesDefiningClasses.P01OpinionPoll.P07Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Person> peopleData = new HashMap<>();

        while (!input.equals("End")){
            String[] commands = input.split(" ");
            String personsName = commands[0];

            if (!peopleData.containsKey(personsName)){
                peopleData.put(personsName, new Person());
            }

            String command = commands[1];

            switch (command){
                case "company":
                    String companyName = commands[2];
                    String department = commands[3];
                    double salary = Double.parseDouble(commands[4]);
                    Company company = new Company(companyName,department,salary);
                    peopleData.get(personsName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = commands[2];
                    String pokemonType = commands[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    //peopleData.get(personsName).getPokemon().add(pokemon);
                    break;
                case "parents":
                    String parentName = commands[2];
                    String parentBirthday = commands[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    peopleData.get(personsName).getParents().add(parent);
                    break;
                case "children":
                    String childName = commands[2];
                    String childBirthday = commands[3];
                    Child child = new Child(childName, childBirthday);
                    peopleData.get(personsName).getChildren().add(child);
                    break;
                case "car":
                    String carModel = commands[2];
                    int carSpeed = Integer.parseInt(commands[3]);
                    Car car = new Car(carModel, carSpeed);
                    peopleData.get(personsName).setCar(car);
                    break;
            }
            input = scanner.nextLine();
        }

        String searchedPerson = scanner.nextLine();
        System.out.println(searchedPerson);

        Person personalData = peopleData.get(searchedPerson);
        System.out.print(personalData);

    }
}