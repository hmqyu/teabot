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

    public void removeDollars(int dollars) {
        this.dollars -= dollars;
    }

    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public void dailyFreebie() {
        this.dollars += ThreadLocalRandom.current().nextInt(200, dailyFreebieAmount);
    }

    public int getDailyFreebieAmount() {
        return dailyFreebieAmount;
    }

    public void setDailyFreebieAmount(int dailyFreebieAmount) {
        this.dailyFreebieAmount = dailyFreebieAmount;
    }
}
