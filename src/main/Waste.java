package main;

import java.util.Random;

public class Waste extends StackCards {
    
    public Waste(int sizeWaste){
        for (int i = 0; i < sizeWaste; i++) {
            this.getCards().add(createRandomCard());
        }
    }
    
    public Card createRandomCard() {
        Random rn = new Random();
        return new Card(rn.nextInt(4), rn.nextInt(12));
    }

}
