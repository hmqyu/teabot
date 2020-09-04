package player;

import java.util.concurrent.ThreadLocalRandom;

public class Money {
    private int dollars;
    private static final int DAILY_FREEBIE_MIN = 1000;
    private static final int DAILY_FREEBIE_MAX = 2500;

    public Money() {
        this.dollars = 1000;
    }

    public Money(int dollars) {
        this.dollars = dollars;
    }

    public void addDollars(int dollars) {
        this.dollars += dollars;
    }

    public boolean removeDollars(int dollars) {
        if (this.dollars < dollars) {
            return false;
        }
        this.dollars -= dollars;
        return true;
    }

    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public int dailyFreebie() {
        int dailyFreebie = ThreadLocalRandom.current().nextInt(DAILY_FREEBIE_MIN, DAILY_FREEBIE_MAX);
        this.dollars += dailyFreebie;
        return dailyFreebie;
    }
}
