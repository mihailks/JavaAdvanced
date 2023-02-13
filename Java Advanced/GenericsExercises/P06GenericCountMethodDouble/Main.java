package GenericsExercises.P06GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box<Double>> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Double data = Double.valueOf(scanner.nextLine());
            Box<Double> box = new Box<>(data);
            boxList.add(box);
        }

        Box<Double> boxToCompare = new Box<>(Double.parseDouble(scanner.nextLine()));

        int count = 0;
        for (Box box : boxList) {
            int res = box.compareTo(boxToCompare);
            if (res > 0 ){
                count ++;
            }
        }
        System.out.println(count);

    }

}
