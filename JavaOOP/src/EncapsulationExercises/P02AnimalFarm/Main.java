package EncapsulationExercises.P02AnimalFarm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        Chicken chicken = null;

        try {
            chicken = new Chicken(name,age);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


        if (chicken!=null){
            System.out.println(chicken.toString());
        }

    }
}
