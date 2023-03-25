package PolymorphismExercises.P04Calculator;

import java.util.Stack;

public class Memory {
    private Stack<Integer> stack;

    public Memory() {
        this.stack = new Stack<>();
    }

    public void save(int operand) {
        this.stack.push(operand);
    }

    public int recall() {
        return this.stack.pop();
    }
}
