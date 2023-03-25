package PolymorphismExercises.P04Calculator;

public class ExtendedInputInterpreter extends InputInterpreter {
    Memory memory;

    public ExtendedInputInterpreter(CalculationEngine engine) {
        super(engine);
        this.memory = new Memory();
    }

    @Override
    public Operation getOperation(String operationName) {
        Operation operation = super.getOperation(operationName);
        if (operation!=null){
            return operation;
        }
        if (operationName.equals("/")){
            return new DivisionOperation();
        }
        if (operationName.equals("ms")){
            return new MemorySaveOperation(memory);
        }
        if (operationName.equals("mr")){
            return new MemoryRecallOperation(memory);
        }
        return null;
    }
}
