package SetsAndMapsAdvancedLab;

import java.util.*;
import java.util.stream.Collectors;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
            studentsMap.putIfAbsent(name, new ArrayList<>());
            studentsMap.put(name, grades);
        }
        studentsMap.forEach((key, value) -> {
            double sumOfGrades = 0;
            for (Double grade : value) {
                sumOfGrades += grade;
            }
            System.out.printf("%s is graduated with %s%n", key, sumOfGrades / value.size());
        });
    }
}
