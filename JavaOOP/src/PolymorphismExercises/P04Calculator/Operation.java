package PolymorphismExercises.P04Calculator;

public interface Operation {
    void addOperand(int operand);
    int getResult();
    boolean isCompleted();
}
