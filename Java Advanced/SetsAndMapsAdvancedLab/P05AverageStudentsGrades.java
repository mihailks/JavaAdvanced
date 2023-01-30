package SetsAndMapsAdvancedLab;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, ArrayList<Double>> student = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double grade = Double.parseDouble(input[1]);
            student.putIfAbsent(name, new ArrayList<>());
            student.get(name).add(grade);
        }

        for (Map.Entry<String, ArrayList<Double>> entry : student.entrySet()) {
            List<Double> grades = entry.getValue();
            double sum = 0;
            for (int i = 0; i < grades.size(); i++) {
                sum += grades.get(i);
            }
            System.out.print(entry.getKey() + " -> ");
            entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)%n", sum/grades.size());
        }

    }
}
