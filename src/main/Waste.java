package main;

public class Waste extends StackCards {

    public Waste(int sizeWaste) {
        for (int i = 0; i < sizeWaste; i++) {
            this.getCards().add(createRandomCard());
        }
    }
}
