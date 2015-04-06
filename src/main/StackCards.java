package main;

import java.util.Random;
import java.util.Stack;

public class StackCards {

    private Stack<Card> cards = new Stack<Card>();

    public StackCards() {
    }
    
    public StackCards(int size) {
        for (int i = 0; i < size; i++) {
            this.getCards().add(createRandomCard());
        }
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }

    public Card createRandomCard() {
        Random rn = new Random();
        return new Card(rn.nextInt(4), rn.nextInt(12));
    }
}
