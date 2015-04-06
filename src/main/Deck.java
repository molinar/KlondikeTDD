package main;

import java.util.Random;

public class Deck extends StackCards{
    
    public Deck(int sizeDeck){
        for (int i = 0; i < sizeDeck; i++) {
            this.getCards().add(createRandomCard());
        }
    }
    
    public Card createRandomCard() {
        Random rn = new Random();
        return new Card(rn.nextInt(4), rn.nextInt(12));
    }

}
