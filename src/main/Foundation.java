package main;

import java.util.Stack;

public class Foundation {

    private Stack<Card> cards = new Stack<Card>();

    public Foundation() {
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }
}
