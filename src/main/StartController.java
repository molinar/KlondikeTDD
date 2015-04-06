package main;

import java.util.ArrayList;
import java.util.Random;

public class StartController {

    private ArrayList<Tableau> tableaus;

    private ArrayList<Foundation> foundations;

    private Waste waste;

    private Deck deck;

    public StartController() {
        this.tableaus = new ArrayList<Tableau>();
        for (int i = 0; i < 7; i++) {
            Tableau tableau = new Tableau();
            for (int j = 0; j < i + 1; j++) {
                Random rn = new Random();
                Card card = new Card(rn.nextInt(4), rn.nextInt(12));
                tableau.getCards().add(card);
            }
            tableaus.add(tableau);
        }
        uncoveredCardsStackTableaus();

        this.foundations = new ArrayList<Foundation>();
        for (int i = 0; i < 4; i++) {
            Foundation foundation = new Foundation();
            foundations.add(foundation);
        }

        this.deck = new Deck();
        for (int i = 0; i < 24; i++) {
            Random rn = new Random();
            Card card = new Card(rn.nextInt(4), rn.nextInt(12));
            deck.getCards().add(card);
        }

        this.waste = new Waste();

    }

    public boolean emptyFoundations() {
        int i=0;
        for (Foundation foundation: foundations){
            if(foundation.getCards().empty()){
                i++;
            }
        }
        if(i==4){
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
        for (Tableau tableau : tableaus) {
            sizeTableaus.add(tableau.getCards().size());
        }
        return sizeTableaus;
    }

    public ArrayList<Card> uncoveredCardsStackTableaus() {
        ArrayList<Card> uncoveredCardsStackTableaus = new ArrayList<Card>();
        for (Tableau tableau : tableaus) {
            tableau.getCards().peek().setUncovered(true);
            uncoveredCardsStackTableaus.add(tableau.getCards().peek());
        }
        return uncoveredCardsStackTableaus;
    }
}
