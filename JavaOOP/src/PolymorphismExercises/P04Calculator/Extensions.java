package PolymorphismExercises.P04Calculator;

public class Extensions {
    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        return new ExtendedInputInterpreter(engine);
    }
}
