package softUni;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public String insert(Student student) {
        if (this.data.contains(student)) {
            return "Student is already in the hall.";
        } else if (capacity < data.size()) {
            return "The hall is full.";
        } else {
            this.data.add(student);
            return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
        }
    }
    public String remove(Student student){
        if (this.data.contains(student)){
            this.data.remove(student);
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }else {
            return "Student not found.";
        }
    }

    public Student getStudent(String firstName, String lastName){
        for (Student student : data) {
            if (student.getFirstName().equals(firstName)&&
            student.getLastName().equals(lastName)){
                return student;
            }
        }
        return null;
    }
    public String getStatistics(){
        String print = this.data.stream()
                .map(r->r.toString())
                .collect(Collectors.joining("\n"));

        return String.format("Hall size: %d%n%s",this.data.size(),print);
    }

}
