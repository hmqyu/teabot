package persistence;

import exceptions.PersistenceException;
import minigames.cockfighting.Chicken;
import player.Money;
import player.Player;
import player.PlayerList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Represents a reader that can read a collection and its cats from a file
public class DataReader {
    public static final String PLAYER_DELIMITER = ",";             // represents a delimiter to separate cat fields
    public static final String CHICKEN_LIST_DELIMITER = "&";       // represents a delimiter to separate accessories
    public static final String CHICKEN_DELIMITER = "_";            // represents a delimiter to separate accessories

    // EFFECTS: returns an array list of players parsed from file
    //          IOException is thrown if an exception occurs when opening/reading file
    public static PlayerList readPlayerList(File file) throws IOException, PersistenceException {
        List<String> playerListFile = readFile(file);
        return new PlayerList(parseData(playerListFile));
    }

    // EFFECTS: returns data from file as a list of String
    //          each String represents the data of a row in file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // returns a list of players parsed from a list of strings
    // each string represents the data for a single player
    private static ArrayList<Player> parseData(List<String> file) throws PersistenceException {
        ArrayList<Player> players = new ArrayList<>();

        for (String line : file) {
            ArrayList<String> lineFields = splitter(line, PLAYER_DELIMITER);
            players.add(parsePlayer(lineFields));
        }

        return players;
    }

    // returns list of strings retrieved by splitting row apart at delimiter
    public static ArrayList<String> splitter(String row, String delimiter) {
        String[] lineSplit = row.split(delimiter);
        return new ArrayList<>(Arrays.asList(lineSplit));
    }

    // parses data for a single player
    private static Player parsePlayer(List<String> fields) throws PersistenceException {
        try {
            String id = fields.get(0);
            ArrayList<Chicken> chickens = parseListOfChickens(fields.get(1));
            Money money = new Money(Integer.parseInt(fields.get(2)));
            return new Player(id, chickens, money);
        } catch (IndexOutOfBoundsException e) {
            throw new PersistenceException();
        }
    }

    // parses data for the player's list of owned chickens
    private static ArrayList<Chicken> parseListOfChickens(String data) throws PersistenceException {
        ArrayList<Chicken> chickens = new ArrayList<>();
        ArrayList<String> lineFields = splitter(data, CHICKEN_LIST_DELIMITER);
        if (!lineFields.get(0).equals("")) {
            for (String line : lineFields) {
                ArrayList<String> chickenDetails = splitter(line, CHICKEN_DELIMITER);
                chickens.add(parseChicken(chickenDetails));
            }
        }
        return chickens;
    }

    // parses data for a single chicken owned by a player
    private static Chicken parseChicken(ArrayList<String> data) throws PersistenceException {
        try {
            int winRate = Integer.parseInt(data.get(0));
            int wins = Integer.parseInt(data.get(1));
            return new Chicken(winRate, wins);
        } catch (IndexOutOfBoundsException e) {
            throw new PersistenceException();
        }
    }
}
