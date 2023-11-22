package TeamSolid.dice;

import java.util.Random;

public class DiceRoller {
    private int diceIndex = 1;

    public int diceRandom() {
        Random randDice = new Random();
        int randDiceIndex = randDice.nextInt(9) + 1;
        diceIndex = randDiceIndex;
        return randDiceIndex;
    }

    public int getDiceIndex() {
        return diceIndex;
    }

    public void setDiceIndex(int diceIndex) {
        this.diceIndex = diceIndex;
    }
}