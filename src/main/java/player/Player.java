package player;

import minigames.cockfighting.Chicken;

import java.util.ArrayList;

public class Player {
    private String id;
    private Money money;
    private Chicken currentChicken;
    private ArrayList<Chicken> chickens;

    public Player(String id) {
        this.id = id;
        this.money = new Money();
    }

    public Player(String id, Money money, ArrayList<Chicken> chickens) {
        this.id = id;
        this.money = new Money();
        this.currentChicken = null;
        this.chickens = chickens;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // gains a certain amount of money
    public void addMoney(int money) {
        this.money.addDollars(money);
    }

    // lose a certain amount of money
    public void removeMoney(int money) {
        this.money.removeDollars(money);
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public void selectCurrentChicken(int chickenNum) {
        currentChicken = chickens.get(chickenNum);
    }

    public Chicken getCurrentChicken() {
        return currentChicken;
    }

    public void setCurrentChicken(Chicken currentChicken) {
        this.currentChicken = currentChicken;
    }

    public void addChicken(Chicken chicken) {
        this.chickens.add(chicken);
    }

    public ArrayList<Chicken> getChickens() {
        return chickens;
    }

    public void setChickens(ArrayList<Chicken> chickens) {
        this.chickens = chickens;
    }
}
