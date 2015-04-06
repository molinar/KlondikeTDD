package main;

public class Card {

    private boolean uncovered = false;

    private int suit;

    private int value;

    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public boolean isUncovered() {
        return uncovered;
    }

    public void setUncovered(boolean uncovered) {
        this.uncovered = uncovered;
    }
}
