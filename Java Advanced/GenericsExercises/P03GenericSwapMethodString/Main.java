package GenericsExercises.P03GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box> boxList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String data = scanner.nextLine();
            Box<String> box = new Box<>(data);
            boxList.add(box);
        }
        String[] input = scanner.nextLine().split(" ");
        int firstIndex = Integer.parseInt(input[0]);
        int secondIndex = Integer.parseInt(input[1]);
        swapBoxes (boxList,firstIndex, secondIndex);

        for (Box box : boxList) {
            System.out.println(box);
        }

    }

    private static <T> void swapBoxes(List<T> data, int firstIndex, int secondIndex) {
        T firstElement = data.get(firstIndex);
        T secondElement = data.get(secondIndex);
        data.set(firstIndex,secondElement);
        data.set(secondIndex, firstElement);

    }
}
