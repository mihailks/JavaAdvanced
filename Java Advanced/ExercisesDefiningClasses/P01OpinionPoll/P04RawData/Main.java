package ExercisesDefiningClasses.P01OpinionPoll.P04RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> fragileList = new ArrayList<>();
        List<String> flamableList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int Tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int Tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int Tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int Tire4Age = Integer.parseInt(input[12]);

            if (cargoType.equals("fragile") && tire1Pressure < 1 || tire2Pressure < 1 || tire3Pressure < 1 || tire4Pressure < 1) {
                fragileList.add(model);
            } else if (cargoType.equals("flamable") && enginePower>250){
                flamableList.add(model);
            }


        }


        if (scanner.nextLine().equals("fragile")) {
            for (String car : fragileList) {
                System.out.println(car);
            }
        } else {
            for (String car : flamableList) {
                System.out.println(car);
            }
        }

    }
}
