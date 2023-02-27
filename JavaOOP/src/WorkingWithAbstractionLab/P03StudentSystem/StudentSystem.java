package WorkingWithAbstractionLab.P03StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> studentMap;

    public StudentSystem() {
        this.studentMap = new HashMap<>();
    }

    public void createStudent(String name, int age, double grade) {
        if (this.studentMap.containsKey(name)) {
            return;
        }
        Student student = new Student(name, age, grade);
        this.studentMap.put(name, student);
    }

    public String showStudent(String name) {
        Student student = this.studentMap.get(name);

        if (student == null) {
            return null;
        }
        return student.toString();
    }
}

