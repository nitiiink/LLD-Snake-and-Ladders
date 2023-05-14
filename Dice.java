import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int diceCount;
    private int min = 1;
    private int max = 6;

     public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {

        int initialCount = 0;
        int totalMoves = 0;
        while(initialCount < diceCount) {
            totalMoves += ThreadLocalRandom.current().nextInt(min, max+1);
            initialCount++;
        }

        return totalMoves;
    }
}
