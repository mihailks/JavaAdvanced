package WorkingWithAbstractionExercise.P03CardsWithPower;

public class Card {
    private CardRank_03 cardRank;
    private CardSuit cardSuit;

    private int cardPower;

    public Card(CardRank_03 cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    public int calculatePower() {
        return cardRank.getValue() + cardSuit.getValue();
    }
    public String getRank(){
        return cardRank.name();
    }
    public String getSuit(){
        return cardSuit.name();
    }
}
