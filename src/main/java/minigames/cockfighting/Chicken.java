package minigames.cockfighting;

public class Chicken {
    private int winRate;
    private int wins;

    public Chicken() {
        this.winRate = 55;
        this.wins = 0;
    }

    public Chicken(int winRate, int wins) {
        this.winRate = winRate;
        this.wins = wins;
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
        wins++;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
