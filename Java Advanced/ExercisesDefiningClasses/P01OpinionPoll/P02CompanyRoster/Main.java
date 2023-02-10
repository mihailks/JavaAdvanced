package ExercisesDefiningClasses.P01OpinionPoll.P02CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Department> departmentMap = new HashMap<>();

     //   List<Employee> employeeList = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            Employee employee = new Employee(name, salary, position, department);
            if (input.length == 5) {
                if (Character.isDigit(input[4].charAt(0))) {
                    int age = Integer.parseInt(input[4]);
                    employee.setAge(age);
                } else {
                    String email = input[4];
                    employee.setEmail(email);
                }
            }
            if (input.length == 6) {
                String email = input[4];
                employee.setEmail(email);
                int age = Integer.parseInt(input[5]);
                employee.setAge(age);
            }

            if(!departmentMap.containsKey(department)) {
                departmentMap.put(department, new Department(department));
            }
            departmentMap.get(department).getEmployees().add(employee);


//            departmentMap.putIfAbsent(department, new ArrayList());
//            departmentMap.get(department).add(salary);
//
//            employeeList.add(employee);
        }

        Department maxAverageSalaryDepartment = departmentMap.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));
    }
}
