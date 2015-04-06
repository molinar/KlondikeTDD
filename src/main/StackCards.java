package main;

import java.util.Stack;

public class StackCards {
    
    private Stack<Card> cards = new Stack<Card>(); 
    
    public StackCards(){
    }
  
    public Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }
}