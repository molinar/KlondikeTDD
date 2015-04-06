package main;

import java.util.Stack;

public class Waste {

    private Stack<Card> cards = new Stack<Card>();

    public Waste() {
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }

}
