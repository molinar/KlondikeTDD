package main;

public class Deck extends StackCards {

    public Deck(int sizeDeck) {
        for (int i = 0; i < sizeDeck; i++) {
            this.getCards().add(createRandomCard());
        }
    }
}
