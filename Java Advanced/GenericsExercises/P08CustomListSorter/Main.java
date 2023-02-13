package GenericsExercises.P08CustomListSorter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> customList = new CustomList<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] commandLine = input.split(" ");
            String command = commandLine[0];
            String element;
            int index;
            switch (command) {
                case "Add":
                    element = commandLine[1];
                    customList.add(element);
                    break;
                case "Remove":
                    index = Integer.parseInt(commandLine[1]);
                    customList.remove(index);
                    break;
                case "Contains":
                    element = commandLine[1];
                    System.out.println(customList.contains(element));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(commandLine[1]);
                    int secondIndex = Integer.parseInt(commandLine[2]);
                    customList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    element = commandLine[1];
                    System.out.println(customList.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    System.out.println(customList);
                    break;
                case "Sort":
                    Sorter.sort(customList);
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }

            input = scanner.nextLine();
        }
    }
}