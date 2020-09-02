package minigames.cockfighting;

import java.util.Random;

public class CockFightBet {

    public CockFightBet() {
    }

    // user can buy a chicken for a certain price
    // if the user doesn't have enough money, returns an error
    public static String buyChicken() {
        return "";
    }

    // chicken fights against a random chicken
    public static boolean cockfight(Chicken chicken) {
        Random random = new Random();
        int chickenWinRate = chicken.getWinRate();
        if (chickenWinRate >= random.nextInt(100)) {
            chicken.increaseWinRate();
            chicken.increaseWins();
            return true;
        }
        return false;
    }
}
