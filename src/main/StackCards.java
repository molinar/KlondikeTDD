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
    
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        Random random = new Random();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public Card createRandomCard() {
        Random rn = new Random();
        return new Card(randomEnum(Suit.class), rn.nextInt(12));
    }
    
    public int getLastValue(){
        return this.getCards().peek().getValue();
    }
    
    public Suit getLastSuit(){
        return this.getCards().peek().getSuit();
    }
}
