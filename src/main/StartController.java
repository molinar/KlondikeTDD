package main;

import java.util.ArrayList;
import java.util.Random;

public class StartController {

    private ArrayList<StackCards> tableaus;

    private ArrayList<StackCards> foundations;

    private StackCards waste;

    private StackCards deck;

    public StartController() {
        this.tableaus = new ArrayList<StackCards>();
        for (int i = 0; i < 7; i++) {
            StackCards tableau = new StackCards();
            for (int j = 0; j < i + 1; j++) {
                tableau.getCards().add(createRandomCard());
            }
            tableaus.add(tableau);
        }
        uncoveredCardsStackTableaus();

        this.foundations = new ArrayList<StackCards>();
        for (int i = 0; i < 4; i++) {
            foundations.add(new StackCards());
        }

        this.deck = new StackCards();
        for (int i = 0; i < 24; i++) {
            deck.getCards().add(createRandomCard());
        }

        this.waste = new StackCards();
    }

    public Card createRandomCard() {
        Random rn = new Random();
        return new Card(rn.nextInt(4), rn.nextInt(12));
    }

    public boolean emptyFoundations() {
        int i = 0;
        for (StackCards foundation : foundations) {
            if (foundation.getCards().empty()) {
                i++;
            }
        }
        if (i == 4) {
            return true;
        }
        return false;
    }

    public boolean emptyWaste() {
        return waste.getCards().empty();
    }

    public int sizeCompleteDeck() {
        return deck.getCards().size();
    }

    public ArrayList<Integer> sizeCoveredCardsTableaus() {
        ArrayList<Integer> sizeTableaus = new ArrayList<Integer>();
        for (StackCards tableau : tableaus) {
            sizeTableaus.add(tableau.getCards().size());
        }
        return sizeTableaus;
    }

    public ArrayList<Card> uncoveredCardsStackTableaus() {
        ArrayList<Card> uncoveredCardsStackTableaus = new ArrayList<Card>();
        for (StackCards tableau : tableaus) {
            tableau.getCards().peek().setUncovered(true);
            uncoveredCardsStackTableaus.add(tableau.getCards().peek());
        }
        return uncoveredCardsStackTableaus;
    }
}
