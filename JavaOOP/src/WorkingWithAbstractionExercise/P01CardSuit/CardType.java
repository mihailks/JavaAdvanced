package WorkingWithAbstractionExercise.P01CardSuit;

public enum CardType {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    private final int value;

    CardType(int value) {
        this.value=value;
    }
    public int getValue(){
        return value;
    }
}
