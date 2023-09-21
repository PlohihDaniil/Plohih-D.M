package Essence;

public class Cards {
    private final String values;
    private final String suit;

    public Cards(String values, String suit) {
        this.values = values;
        this.suit = suit;
    }

    public String getValues() {
        return values;
    }

    public String getSuit() {
        return suit;
    }
}
