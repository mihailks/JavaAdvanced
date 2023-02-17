package Others;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P01Internship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int problemsInfo = Integer.parseInt(scanner.nextLine());
        int studentInfo = Integer.parseInt(scanner.nextLine());
        Deque<String> problemsStack = new ArrayDeque<>();
        for (int i = 0; i < problemsInfo; i++) {
            problemsStack.push(scanner.nextLine());
        }
        Deque<String> studentsQueue = new ArrayDeque<>();

        for (int i = 0; i < studentInfo; i++) {
            String candidate = scanner.nextLine();
            if (candidate.matches("[A-Z][a-z]+ [A-Z][a-z]+")) {
                studentsQueue.offer(candidate);
            }
        }

        while (!problemsStack.isEmpty() && studentsQueue.size() > 1) {
            String currentProblem = problemsStack.peek();
            String currentStudent = studentsQueue.peek();

            int sumCharProblem = 0;
            int sumCharStudent = 0;

            for (char currentChar : currentProblem.toCharArray()) {
                sumCharProblem += currentChar;
            }

            for (char currentChar : currentStudent.toCharArray()) {
                sumCharStudent += currentChar;
            }

            if (sumCharStudent > sumCharProblem) {
                problemsStack.pop();
                studentsQueue.offer(studentsQueue.pop());
                System.out.println(currentStudent + " solved " + currentProblem + ".");
            } else {
                studentsQueue.poll();
                problemsStack.addLast(problemsStack.pop());
                System.out.println(currentStudent + " failed " + currentProblem + ".");
            }
        }
        if (problemsStack.isEmpty()) {
            String printStudents = studentsQueue.toString().replaceAll("[\\[\\]]", "");
            System.out.println(printStudents);
        } else {
            String lastCandidate = studentsQueue.poll();
            System.out.println(lastCandidate + " gets the job!");
        }
    }

    private static boolean nameValidator(String[] checkName) {
        //TODO use regex

        for (String name : checkName) {

            if (!Character.isUpperCase(name.charAt(0))) {
                return false;
            }
            for (int i = 1; i < name.length(); i++) {
                if (Character.isUpperCase(name.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
