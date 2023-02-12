package ExercisesDefiningClasses.P01OpinionPoll.P01OpinionPoll;

public class Person {
    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.age);
    }

}
