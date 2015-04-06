package main;

import java.util.Stack;

public class Deck {
    
    private Stack<Card> cards = new Stack<Card>();
    
    public Deck(){
    }
  
    public Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }

}
