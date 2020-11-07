package poker.hands;

public class Card {
    Card(char value, char suit) {
        this.suit = suit;
        this.value = value;
    }

    char suit;
    char value;

    public char getSuit() {
        return suit;
    }

    public char getValue() {
        return value;
    }
}
