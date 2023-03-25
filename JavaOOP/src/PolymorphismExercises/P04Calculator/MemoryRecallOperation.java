package PolymorphismExercises.P04Calculator;

public class MemoryRecallOperation implements Operation {
    private Memory memory;

    public MemoryRecallOperation(Memory memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
    }

    @Override
    public int getResult() {
        return memory.recall();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
