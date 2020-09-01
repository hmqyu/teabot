package player;

import java.util.concurrent.ThreadLocalRandom;

public class Money {
    private int dollars;
    private int dailyFreebieAmount = 500;

    public Money() {
        this.dollars = 100;
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
        int dailyFreebie = ThreadLocalRandom.current().nextInt(200, dailyFreebieAmount);
        this.dollars += dailyFreebie;
        return dailyFreebie;
    }

    public int getDailyFreebieAmount() {
        return dailyFreebieAmount;
    }

    public void setDailyFreebieAmount(int dailyFreebieAmount) {
        this.dailyFreebieAmount = dailyFreebieAmount;
    }
}
