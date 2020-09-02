package player;

import persistence.Data;

import java.io.PrintWriter;
import java.util.ArrayList;

public class PlayerList implements Data {
    ArrayList<Player> players;

    public PlayerList() {
        players = new ArrayList<>();
    }

    public PlayerList(ArrayList<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayer(int position) {
        return players.get(position);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    @Override
    public void save(PrintWriter printWriter) {
        for (Player player : players) {
            player.save(printWriter);
        }
    }
}
