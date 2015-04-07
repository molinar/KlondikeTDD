package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Card;
import main.Foundation;
import main.MoveCardController;
import main.StackCards;
import main.StartController;
import main.Suit;

public class MoveCardControllerTest {

    StartController startController;

    MoveCardController moveCardController;

    @Before
    public void before() {
        startController = new StartController();
    }

    @Test
    public void moveFromDeckToWasteTest() {
        moveCardController = new MoveCardController(24, 0);
        moveCardController.moveFromDeckToWaste();
        assertEquals(23, moveCardController.getSizeDeck());
        assertEquals(1, moveCardController.getSizeWaste());

        moveCardController = new MoveCardController(0, 20);
        moveCardController.moveFromDeckToWaste();
        assertEquals(20, moveCardController.getSizeDeck());
        assertEquals(0, moveCardController.getSizeWaste());

        moveCardController = new MoveCardController(1, 0);
        moveCardController.moveFromDeckToWaste();
        assertEquals(0, moveCardController.getSizeDeck());
        assertEquals(1, moveCardController.getSizeWaste());

        moveCardController = new MoveCardController(2, 2);
        moveCardController.moveFromDeckToWaste();
        assertEquals(1, moveCardController.getSizeDeck());
        assertEquals(3, moveCardController.getSizeWaste());

        moveCardController = new MoveCardController(10, 2);
        moveCardController.moveFromDeckToWaste();
        assertEquals(9, moveCardController.getSizeDeck());
        assertEquals(3, moveCardController.getSizeWaste());

        moveCardController = new MoveCardController(0, 1);
        moveCardController.moveFromDeckToWaste();
        assertEquals(1, moveCardController.getSizeDeck());
        assertEquals(0, moveCardController.getSizeWaste());
    }

    @Test
    public void moveFromWasteToFoundationTest() {
        Foundation foundation;
        StackCards waste;

        foundation = new Foundation(Suit.CLUBS);
        foundation.getCards().push(new Card(Suit.CLUBS, 1));
        foundation.getCards().push(new Card(Suit.CLUBS, 2));
        foundation.getCards().push(new Card(Suit.CLUBS, 3));
        waste = new StackCards();
        waste.getCards().push(new Card(Suit.CLUBS, 4));
        moveCardController = new MoveCardController();
        moveCardController.setWaste(waste);
        moveCardController.moveFromWasteToFoundation(foundation);
        assertEquals(0, moveCardController.getSizeWaste());
        assertEquals(4, foundation.getCards().peek().getValue());
        assertEquals(Suit.CLUBS, foundation.getCards().peek().getSuit());

        foundation = new Foundation(Suit.CLUBS);
        foundation.getCards().push(new Card(Suit.CLUBS, 1));
        waste = new StackCards();
        waste.getCards().push(new Card(Suit.CLUBS, 4));
        moveCardController = new MoveCardController();
        moveCardController.setWaste(waste);
        moveCardController.moveFromWasteToFoundation(foundation);
        assertEquals(1, moveCardController.getSizeWaste());
        assertEquals(1, foundation.getCards().peek().getValue());
        assertEquals(Suit.CLUBS, foundation.getCards().peek().getSuit());

        foundation = new Foundation(Suit.CLUBS);
        foundation.getCards().push(new Card(Suit.CLUBS, 1));
        foundation.getCards().push(new Card(Suit.CLUBS, 2));
        foundation.getCards().push(new Card(Suit.CLUBS, 3));
        waste = new StackCards();
        waste.getCards().push(new Card(Suit.DIAMONDS, 4));
        MoveCardController moveCardController = new MoveCardController();
        moveCardController.setWaste(waste);
        moveCardController.moveFromWasteToFoundation(foundation);
        assertEquals(1, moveCardController.getSizeWaste());
        assertEquals(3, foundation.getCards().peek().getValue());
        assertEquals(Suit.CLUBS, foundation.getCards().peek().getSuit());

        foundation = new Foundation(Suit.CLUBS);
        foundation.getCards().push(new Card(Suit.CLUBS, 1));
        foundation.getCards().push(new Card(Suit.CLUBS, 2));
        foundation.getCards().push(new Card(Suit.CLUBS, 3));
        waste = new StackCards();
        waste.getCards().push(new Card(Suit.CLUBS, 2));
        moveCardController = new MoveCardController();
        moveCardController.setWaste(waste);
        moveCardController.moveFromWasteToFoundation(foundation);
        assertEquals(1, moveCardController.getSizeWaste());
        assertEquals(3, foundation.getCards().peek().getValue());
        assertEquals(Suit.CLUBS, foundation.getCards().peek().getSuit());

        foundation = new Foundation(Suit.CLUBS);
        waste = new StackCards();
        waste.getCards().push(new Card(Suit.CLUBS, 1));
        moveCardController = new MoveCardController();
        moveCardController.setWaste(waste);
        moveCardController.moveFromWasteToFoundation(foundation);
        assertEquals(0, moveCardController.getSizeWaste());
        assertEquals(1, foundation.getCards().peek().getValue());
        assertEquals(Suit.CLUBS, foundation.getCards().peek().getSuit());

        foundation = new Foundation(Suit.CLUBS);
        waste = new StackCards();
        waste.getCards().push(new Card(Suit.SPADES, 5));
        moveCardController = new MoveCardController();
        moveCardController.setWaste(waste);
        moveCardController.moveFromWasteToFoundation(foundation);
        assertEquals(1, moveCardController.getSizeWaste());
        assertTrue(foundation.getCards().empty());
        assertEquals(Suit.CLUBS, foundation.getSuit());
    }

    @Test
    public void moveFromTableauToFoundationTest() {
        Foundation foundation;
        StackCards tableau;

        foundation = new Foundation(Suit.CLUBS);
        foundation.getCards().push(new Card(Suit.CLUBS, 1));
        foundation.getCards().push(new Card(Suit.CLUBS, 2));
        foundation.getCards().push(new Card(Suit.CLUBS, 3));
        tableau = new StackCards();
        tableau.getCards().push(new Card(Suit.CLUBS, 4));
        moveCardController = new MoveCardController();
        moveCardController.setTableau(tableau);
        moveCardController.moveFromTableauToFoundation(foundation);
        assertEquals(0, moveCardController.getSizeTableau());
        assertEquals(4, foundation.getCards().peek().getValue());
        assertEquals(Suit.CLUBS, foundation.getCards().peek().getSuit());

        foundation = new Foundation(Suit.CLUBS);
        foundation.getCards().push(new Card(Suit.CLUBS, 1));
        tableau = new StackCards();
        tableau.getCards().push(new Card(Suit.CLUBS, 4));
        moveCardController = new MoveCardController();
        moveCardController.setTableau(tableau);
        moveCardController.moveFromTableauToFoundation(foundation);
        assertEquals(1, moveCardController.getSizeTableau());
        assertEquals(1, foundation.getCards().peek().getValue());
        assertEquals(Suit.CLUBS, foundation.getCards().peek().getSuit());

        foundation = new Foundation(Suit.CLUBS);
        foundation.getCards().push(new Card(Suit.CLUBS, 1));
        foundation.getCards().push(new Card(Suit.CLUBS, 2));
        foundation.getCards().push(new Card(Suit.CLUBS, 3));
        tableau = new StackCards();
        tableau.getCards().push(new Card(Suit.DIAMONDS, 4));
        MoveCardController moveCardController = new MoveCardController();
        moveCardController.setTableau(tableau);
        moveCardController.moveFromTableauToFoundation(foundation);
        assertEquals(1, moveCardController.getSizeTableau());
        assertEquals(3, foundation.getCards().peek().getValue());
        assertEquals(Suit.CLUBS, foundation.getCards().peek().getSuit());

        foundation = new Foundation(Suit.CLUBS);
        foundation.getCards().push(new Card(Suit.CLUBS, 1));
        foundation.getCards().push(new Card(Suit.CLUBS, 2));
        foundation.getCards().push(new Card(Suit.CLUBS, 3));
        tableau = new StackCards();
        tableau.getCards().push(new Card(Suit.CLUBS, 2));
        moveCardController = new MoveCardController();
        moveCardController.setTableau(tableau);
        moveCardController.moveFromTableauToFoundation(foundation);
        assertEquals(1, moveCardController.getSizeTableau());
        assertEquals(3, foundation.getCards().peek().getValue());
        assertEquals(Suit.CLUBS, foundation.getCards().peek().getSuit());

        foundation = new Foundation(Suit.CLUBS);
        tableau = new StackCards();
        tableau.getCards().push(new Card(Suit.CLUBS, 1));
        moveCardController = new MoveCardController();
        moveCardController.setTableau(tableau);
        moveCardController.moveFromTableauToFoundation(foundation);
        assertEquals(0, moveCardController.getSizeTableau());
        assertEquals(1, foundation.getCards().peek().getValue());
        assertEquals(Suit.CLUBS, foundation.getCards().peek().getSuit());

        foundation = new Foundation(Suit.CLUBS);
        tableau = new StackCards();
        tableau.getCards().push(new Card(Suit.SPADES, 5));
        moveCardController = new MoveCardController();
        moveCardController.setTableau(tableau);
        moveCardController.moveFromTableauToFoundation(foundation);
        assertEquals(1, moveCardController.getSizeTableau());
        assertTrue(foundation.getCards().empty());
        assertEquals(Suit.CLUBS, foundation.getSuit());
    }
}
