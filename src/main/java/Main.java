import exceptions.PersistenceException;
import minigames.RockPaperScissors;
import minigames.cockfighting.Chicken;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import persistence.DataReader;
import persistence.DataWriter;
import player.Player;
import player.PlayerList;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import static minigames.cockfighting.CockFightBet.cockfight;

public class Main extends ListenerAdapter {
    private static PlayerList playerList;
    private static ArrayList<Player> players;
    private static final String PLAYER_DATA_FILE = "./data/PlayerData.txt";
    private MessageReceivedEvent event;
    private int ikuMessageCount = 0;
    private String RPSPlayerID = "";

    public static void main(String[] args) throws LoginException {
        loadPlayerData();
        JDABuilder builder = new JDABuilder(AccountType.BOT);
        String token = "NzQ5NzgwNzAzOTQ3OTE1Mzc1.X0w9sg.BAFEkccPJqPteLdJ3VDMkfWDfpM";
        builder.setToken(token);
        builder.addEventListener(new Main());
        builder.buildAsync();
    }

    private static void loadPlayerData() {
        try {
            playerList = DataReader.readPlayerList(new File(PLAYER_DATA_FILE));
            players = playerList.getPlayers();
            System.out.println("Data file successfully loaded.");
        } catch (IOException e) {
            System.out.println("No data file found. Creating new data file...");
            playerList = new PlayerList();
        } catch (PersistenceException e) {
            System.out.println("Corrupt data file found - new data file must be created. Creating new data file...");
            playerList = new PlayerList();
        }
    }

    // prints a message to the console on bot startup
    @Override
    public void onReady(ReadyEvent event) {
        System.out.println("HEEN IS SMEGA CUTE uwu");
    }

    // where the bot reacts to various events that occur, ie. messages
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) {
            return;
        }

        System.out.println("Message received from " +
                event.getAuthor().getName() + " " +
                event.getAuthor().getId() + ": " +
                event.getMessage().getContentDisplay());

        this.event = event;

        help();
        save();
        botResponseMessages();
        specificUserMessages();
        games();
    }

    public void help() {
        if (event.getMessage().getContentRaw().equals("!help")) {
            event.getChannel().sendMessage("**!daily**: gives you a daily amount of money. [disabled]\n" +
                    "**!bank**: checks how much money you have.\n" +
                    "**!cockfight #**: bet the given amount of money on your chicken against a random chicken. " +
                    "if you win, you gain your money back x2. if you lose, you lose your money and your chicken.\n" +
                    "**!buy chicken**: buys a chicken for $100, and assigns it as your current chicken.\n" +
                    "**!assign chicken #**: assigns chicken # as your current chicken, " +
                    "which will fight for you in cockfights.\n" +
                    "**!display chickens**: displays the chickens that you currently own.\n" +
                    "**!rps**: play a game of rock-paper-scissors against the bot.\n" +
                    "**!save**: saves all user information.").queue();
        }
    }

    public void save() {
        if (event.getMessage().getContentRaw().equals("!save")) {
            try {
                DataWriter writer = new DataWriter(new File(PLAYER_DATA_FILE));
                writer.write(playerList);
                writer.close();
                event.getChannel().sendMessage("Data saved!").queue();
            } catch (FileNotFoundException e) {
                event.getChannel().sendMessage("Save file corrupted - unable to save data.").queue();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    // the bot responds to certain phrases sent in the channel, if possible
    public void botResponseMessages() {
        goodBot();
        painMessage();
        angryAtBot();
        botAcceptsApologies();
        botGreetings();
    }

    // send the pain image after a user types "pain."
    public void painMessage() {
        if (event.getMessage().getContentRaw().equals("pain.")) {
            event.getChannel()
                    .sendMessage("https://i.kym-cdn.com/photos/images/newsfeed/001/856/089/47d.png").queue();
        }
    }

    // bot thanks someone when they say "good bot"
    public void goodBot() {
        if (event.getMessage().getContentRaw().equalsIgnoreCase("good bot")) {
            event.getChannel().sendMessage("thank you!").queue();
        }
    }

    // bot swears back if a user curses the bot
    public void angryAtBot() {
        String userMessage = event.getMessage().getContentRaw().toLowerCase();
        if (userMessage.equals("fuck you bot") ||
                userMessage.equals("fuck the bot") ||
                userMessage.equals("fuck this bot") ||
                userMessage.equals("i hate this bot") ||
                userMessage.equals("i hate the bot") ||
                userMessage.equals("the bot sucks") ||
                userMessage.equals("this bot sucks") ||
                userMessage.equals("bad bot")) {
            event.getChannel().sendMessage("<@" +
                    event.getMessage().getAuthor().getId() +
                    "> fuck you too").queue();
        }
    }

    // bot accepts the apology of the user
    public void botAcceptsApologies() {
        String userMessage = event.getMessage().getContentRaw().toLowerCase();
        if (userMessage.equals("sorry bot") ||
                userMessage.equals("im sorry bot") ||
                userMessage.equals("i'm sorry bot")) {
            event.getChannel().sendMessage("<@" +
                    event.getMessage().getAuthor().getId() +
                    "> it's okay").queue();
        }
    }

    // send the pain image after a user types "pain."
    public void botGreetings() {
        String userMessage = event.getMessage().getContentRaw().toLowerCase();
        if (userMessage.equals("hi bot") ||
                userMessage.equals("hello bot") ||
                userMessage.equals("hey bot") ||
                userMessage.equals("hi") ||
                userMessage.equals("hello") ||
                userMessage.equals("hey")) {
            event.getChannel().sendMessage("<@" +
                    event.getMessage().getAuthor().getId() +
                    "> hi! :-)").queue();
        }
    }

    // the bot does various things depending if a certain user sends a message
    public void specificUserMessages() {
        ikuNeedsAGirlfriend();
        spellAshleysNameWrong();
    }

    // tells iku that he needs a girlfriend every time he types
    // tells him on his first message, and then waits 5 messages before telling him again
    public void ikuNeedsAGirlfriend() {
        if (event.getAuthor().getId().equals("263815694380957697")) {
            ikuMessageCount++;
            if (ikuMessageCount == 5) {
                ikuMessageCount = 0;
            } else if (ikuMessageCount == 1) {
                event.getChannel().sendMessage("get a queen, king :crown:").queue();
            }
        }
    }

    // corrects whoever said ashley's name to ahley
    public void spellAshleysNameWrong() {
        if (event.getMessage().getContentRaw().toLowerCase().contains("ashley")) {
            event.getChannel().sendMessage("*ahley").queue();
        }
    }

    // sets the properties of the embedded image (in this case pain.)
//    public void sendEmbeddedImage() {
//        EmbedBuilder image = new EmbedBuilder();
//        image.setThumbnail("https://i.kym-cdn.com/photos/images/newsfeed/001/856/089/47d.png");
//        event.getChannel().sendMessage(image.build()).queue();
//    }

    // used to run all the games
    public void games() {
        moneyTransactions();
        rockPaperScissors();
        cockFighting();
    }

    public void moneyTransactions() {
        daily();
        giveMoney();
        bank();
//        leaderboard();
    }

    public void leaderboard() {
        if (event.getMessage().getContentRaw().equals("!leaderboard")) {
            String leaderboard = "";
            for (int pos = 0; pos < players.size(); pos++) {
                leaderboard += (pos + 1)  + ". ";

            }
        }
    }

    public void daily() {
        if (event.getMessage().getContentRaw().equals("!daily")) {
           int dailyFreebie = findPlayer(event.getMessage().getAuthor().getId()).getMoney().dailyFreebie();
            event.getChannel().sendMessage("You received $" + dailyFreebie + " today!").queue();
       }
   }

    public void giveMoney() {
        if (event.getMessage().getContentRaw().contains("!give") &&
        event.getMessage().getAuthor().getId().equals("202967660491833345")) {
            try {
                int money = Integer.parseInt(event.getMessage().getContentRaw().substring(6, 12));
                String playerID = event.getMessage().getContentRaw().substring(17);
                Player chosenPlayer = findPlayer(playerID.substring(0, playerID.length() - 1));
                chosenPlayer.addMoney(money);
                event.getChannel().sendMessage("$" + money + " was successfully sent to <@" +
                        playerID + "!").queue();
            } catch (NumberFormatException e) {
                event.getChannel().sendMessage("Invalid amount of money entered.").queue();
            } catch (StringIndexOutOfBoundsException e) {
                event.getChannel().sendMessage("Please include the amount of money to give, " +
                        "and a player ID.").queue();
            }
        }
    }

    public void bank() {
        if (event.getMessage().getContentRaw().equals("!bank")) {
            Player currentPlayer = findPlayer(event.getMessage().getAuthor().getId());
            event.getChannel().sendMessage("You have $" + currentPlayer.getMoney().getDollars() + ".").queue();
        }
    }

    // runs the rock-paper scissors game
    public void rockPaperScissors() {
        if (event.getMessage().getAuthor().getId().equals(RPSPlayerID)) {
            finishRockPaperScissors();
            return;
        }
        startRockPaperScissors();
    }

    // ask the user for their selection
    public void startRockPaperScissors() {
        if (event.getMessage().getContentRaw().equals("!rps")) {
            event.getChannel().sendMessage("Choose thy weapon:").queue();
            RPSPlayerID = event.getMessage().getAuthor().getId();
        }
    }

    // determines the outcome of the rock paper scissors game
    public void finishRockPaperScissors() {
        RockPaperScissors RPS = new RockPaperScissors(event.getMessage().getContentRaw());
        event.getChannel().sendMessage("teabot has prepped his " + RPS.getBotSelection() + ".").queue();
        String result = RPS.getOutcome();
        event.getChannel().sendMessage(result).queue();
        RPSPlayerID = "";
    }

    public void cockFighting() {
        buyChicken();
        assignChicken();
        displayChickens();
        cockFightBet();
    }

    public void buyChicken() {
        if (event.getMessage().getContentRaw().equals("!buy chicken")) {
            Player currentPlayer = findPlayer(event.getMessage().getAuthor().getId());
            if (currentPlayer.removeMoney(25)) {
                currentPlayer.addChicken(new Chicken());
                event.getChannel().sendMessage("You bought a chicken for $25! :rooster:").queue();
            } else {
                event.getChannel().sendMessage("You don't have enough for a chicken...").queue();
            }
        }
    }

    public void assignChicken() {
        if (event.getMessage().getContentRaw().contains("!assign chicken")) {
            Player currentPlayer = findPlayer(event.getMessage().getAuthor().getId());
            try {
                int chickenPos = Integer.parseInt(event.getMessage().getContentRaw().substring(16));
                Chicken chicken = currentPlayer.getSingleChicken(chickenPos);
                currentPlayer.setCurrentChicken(chicken);
                event.getChannel().sendMessage("Successfully assigned chicken " + chickenPos +
                        " as your current chicken! :rooster:").queue();
            } catch (StringIndexOutOfBoundsException e) {
                event.getChannel().sendMessage("Please include the chicken's number when assigning a chicken.")
                        .queue();
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                event.getChannel().sendMessage("No chicken exists at that position.").queue();
            }
        }
    }

    public void displayChickens() {
        if (event.getMessage().getContentRaw().contains("!display chickens")) {
            Player currentPlayer = findPlayer(event.getMessage().getAuthor().getId());
            ArrayList<Chicken> chickens = currentPlayer.getChickens();
            if (chickens.isEmpty()) {
                event.getChannel().sendMessage("You have no chickens. " +
                        "You can buy a chicken with \"!buy chicken\".").queue();
                return;
            }
            StringBuilder message = new StringBuilder();
            for (int pos = 0; pos < chickens.size(); pos++) {
                Chicken chicken = chickens.get(pos);
                message.append("Chicken ").append(pos + 1).append(": ")
                        .append(chicken.getWins()).append(" wins, ")
                        .append(chicken.getWinRate()).append("% win rate.\n");
            }
            event.getChannel().sendMessage(message.toString()).queue();
        }
    }

    public void cockFightBet() {
        if (event.getMessage().getContentRaw().contains("!cockfight")) {
            Player player = findPlayer(event.getMessage().getAuthor().getId());
            try {
                int bettings = Integer.parseInt(event.getMessage().getContentRaw().substring(11));
                if (bettings <= player.getMoney().getDollars()) {
                    Chicken chicken = player.getCurrentChicken();
                    if (chicken != null) {
                        boolean isAlive = cockfight(
                                findPlayer(event.getMessage().getAuthor().getId()).getCurrentChicken());
                        if (isAlive) {
                            event.getChannel().sendMessage("Your lil chicken won the fight, " +
                                    "and made you $" + bettings + " richer! :rooster:").queue();
                        } else {
                            player.removeChicken(chicken);
                            event.getChannel().sendMessage(
                                    ":skull_crossbones: Your chicken died... :skull_crossbones:").queue();
                        }
                        processMoney(player, bettings, isAlive);
                    } else {
                        event.getChannel().sendMessage("You have no chicken ready to fight. " +
                                "Assign a chicken with \"!assign chicken\", " +
                                "or buy one with \"!buy chicken\".").queue();
                    }
                } else {
                    event.getChannel().sendMessage("You don't have enough money to bet that amount!").queue();
                }
            } catch (StringIndexOutOfBoundsException e) {
                event.getChannel().sendMessage("Please include an amount of money to bet with.").queue();
            } catch (NumberFormatException e) {
                event.getChannel().sendMessage("Invalid amount of money entered.").queue();
            }
        }
    }

    private void processMoney(Player player, int money, boolean isWon) {
        if (isWon) {
            player.addMoney(money);
        } else {
            player.removeMoney(money);
        }
    }

    private Player findPlayer(String id) {
        for (Player player : players) {
            if (player.getId().equals(id)) {
                return player;
            }
        }

        Player newPlayer = new Player(id);
        players.add(newPlayer);
        return newPlayer;
    }
}