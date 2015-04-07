package main;

import java.util.ArrayList;

public class StartController extends Klondike {

    protected ArrayList<Foundation> foundations;

    private ArrayList<StackCards> tableaus;
    
    public static final int NUM_TABLEAUS = 7;

    public static final int NUM_CARDS_DECK = 24;

    public StartController(){
        this.createTableaus();
        this.createFoundations();
        this.createDeck();
        this.createWaste();
    }

    public void createTableaus() {
        this.tableaus = new ArrayList<StackCards>();
        for (int i = 0; i < 7; i++) {
            StackCards tableau = new StackCards();
            for (int j = 0; j < i + 1; j++) {
                tableau.getCards().add(tableau.createRandomCard());
            }
            this.tableaus.add(tableau);            
        }
        this.uncoveredCardsStackTableaus();
    }
    
    public void createFoundations() {
        this.foundations = new ArrayList<Foundation>();
        for (Suit suit : Suit.values()) {
            foundations.add(new Foundation(suit));
        }
    }

    public void createDeck() {
        this.deck = new StackCards(NUM_CARDS_DECK);
    }

    public void createWaste() {
        this.waste = new StackCards(0);
    }

    public boolean emptyFoundations() {
        boolean empty = false;
        for (Foundation foundation : foundations) {
            if (foundation.getCards().empty()) {
                empty = true;
                break;
            }
        }
        return empty;
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
