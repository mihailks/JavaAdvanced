package DefiningClassesLab.P01AndP02CarInfo;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCars; i++) {
            String[] carParts = scanner.nextLine().split(" ");

            Car car;
            if (carParts.length > 1) {
                int hp = Integer.parseInt(carParts[2]);

                car = new Car(carParts[0], carParts[1], hp);
            } else {
                car = new Car(carParts[0]);
            }

            System.out.println(car.carInfo());
        }
    }
}