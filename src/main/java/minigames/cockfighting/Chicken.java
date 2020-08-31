package minigames.cockfighting;

public class Chicken {
    private String ownerID;
    private int winRate;
    private int wins;

    public Chicken(String ownerID) {
        this.ownerID = ownerID;
        this.winRate = 45;
        this.wins = 0;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public void increaseWinRate() {
        winRate++;
    }

    public int getWinRate() {
        return winRate;
    }

    public void setWinRate(int winRate) {
        this.winRate = winRate;
    }

    public void increaseWins() {
        winRate++;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
