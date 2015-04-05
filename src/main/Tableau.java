package main;

import java.util.Stack;

public class Tableau {
    
    private Stack<Card> cards; 
    
    public Tableau(){
    }
  
    public Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }
}
