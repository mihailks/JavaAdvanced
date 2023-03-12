package EncapsulationExercises.P03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String END_COMMAND = "END";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people;
        List<Product> products;
        try {
            people = parsePeople(scanner.nextLine());
            products = parseProducts(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String command = scanner.nextLine();
        while (!command.equals(END_COMMAND)) {
            String[] personAndProduct = command.split("\\s+");

            Person person = people.stream().filter(p -> p.getName()
                            .equals(personAndProduct[0]))
                            .findFirst().get();
            Product product = products.stream().filter(p -> p.getName()
                            .equals(personAndProduct[1]))
                            .findFirst().get();

            try {
                person.buyProduct(product);
                System.out.println(person.getName() + " bought " + product.getName());
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine();
        }

        for (Person person : people) {
            List<Product> personsProducts = person.getProducts();
            System.out.print(person.getName() + " - ");
            if (personsProducts.isEmpty()) {
                System.out.println("Nothing bought");
            } else {
                List<String> productNames = new ArrayList<>();
                for (Product product : personsProducts) {
                    productNames.add(product.getName());
                }
                System.out.println(String.join(", ", productNames));

//                List<String> productNames = personsProducts.stream()
//                        .map(p -> p.getName())
//                        .collect(Collectors.toList());
            }
        }
    }

    private static List<Product> parseProducts(String productsAsString) {
        List<Product> products = new ArrayList<>();

        String[] productsList = productsAsString.split(";");
        for (String currentProduct : productsList) {
            String[] nameAndMoney = currentProduct.split("=");
            products.add(new Product(nameAndMoney[0], Double.parseDouble(nameAndMoney[1])));

        }
        return products;
    }

    private static List<Person> parsePeople(String peopleAsString) {
        List<Person> people = new ArrayList<>();

        String[] peopleList = peopleAsString.split(";");
        for (String currentPerson : peopleList) {
            String[] nameAndMoney = currentPerson.split("=");
            people.add(new Person(nameAndMoney[0], Double.parseDouble(nameAndMoney[1])));

        }
        return people;
    }
}
