package player;

import minigames.cockfighting.Chicken;
import persistence.Data;
import persistence.DataReader;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Player implements Data {
    private String id;
    private Money money;
    private Chicken currentChicken;
    private ArrayList<Chicken> chickens;

    public Player(String id) {
        this.id = id;
        this.money = new Money();
        this.chickens = new ArrayList<>();
    }

    public Player(String id, ArrayList<Chicken> chickens, Money money) {
        this.id = id;
        this.money = money;
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
    public boolean removeMoney(int money) {
        return this.money.removeDollars(money);
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
        currentChicken = chicken;
    }

    public void removeChicken(Chicken chicken) {
        this.chickens.remove(chicken);
        if (currentChicken.equals(chicken)) {
            currentChicken = null;
        }
    }

    public Chicken getSingleChicken(int index) {
        return chickens.get(index - 1);
    }

    public ArrayList<Chicken> getChickens() {
        return chickens;
    }

    public void setChickens(ArrayList<Chicken> chickens) {
        this.chickens = chickens;
    }

    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(id);
        printWriter.print(DataReader.PLAYER_DELIMITER);
        saveChickens(printWriter);
        printWriter.print(DataReader.PLAYER_DELIMITER);
        printWriter.println(money.getDollars());
    }

    private void saveChickens(PrintWriter printWriter) {
        if (chickens.isEmpty()) {
            return;
        }
        int count;
        for (count = 0; count < chickens.size() - 1; count++) {
            saveSingleChicken(printWriter, chickens.get(count));
            printWriter.print(DataReader.CHICKEN_LIST_DELIMITER);
        }
        saveSingleChicken(printWriter, chickens.get(count));
    }

    private void saveSingleChicken(PrintWriter printWriter, Chicken chicken) {
        printWriter.print(chicken.getWinRate());
        printWriter.print(DataReader.CHICKEN_DELIMITER);
        printWriter.print(chicken.getWins());
    }
}
