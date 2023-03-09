package WorkingWithAbstractionExercise.P03CardsWithPower;

public enum CardRank_03 {
    ACE(14),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private final int cardRank;

    CardRank_03(int cardRank){
        this.cardRank = cardRank;
    }

    public int getCardRank() {
        return cardRank;
    }

    public int getValue() {
        return cardRank;
    }
}
