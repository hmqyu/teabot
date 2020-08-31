package minigames;

import java.util.Random;

public class RockPaperScissors {
    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";
    private String userSelection;
    private String botSelection;
    Random number = new Random();


    public RockPaperScissors(String userInput) {
        this.userSelection = userInput;
    }

    public void setUserSelection(String userInput) {
        userSelection = userInput.toLowerCase();

    }

    public int generateBotSelection() {
        return number.nextInt(2);

    }

    public String getUserSelection() {
        return userSelection;
    }

    public String getBotSelection() {
        if (generateBotSelection() == 0) {
            botSelection = ROCK;
        } else if (generateBotSelection() == 1) {
            botSelection = PAPER;
        } else {
            botSelection = SCISSORS;
        }

        return botSelection;

    }

    // determine winner of the rock-paper-scissors game
    public String getOutcome() {

        if (getUserSelection().equals("rock")) {
            if (getBotSelection().equals("rock")) {
                return "Draw, worthy battle.";
            } else if (getBotSelection().equals("paper")) {
                return "Shame.";
            } else if (getBotSelection().equals("scissors")) {
                return "Winner Winner Chicken Dinner!";
            }
        } else if (getUserSelection().equals("paper")) {
            if (getBotSelection().equals("rock")) {
                return "Winner Winner Chicken Dinner!";
            } else if (getBotSelection().equals("paper")) {
                return "Draw, worthy battle.";
            } else if (getBotSelection().equals("scissors")) {
                return "Shame.";
            }
        } else if (getUserSelection().equals("scissors")) {
            if (getBotSelection().equals("rock")) {
                return "Shame.";
            } else if (getBotSelection().equals("paper")) {
                return "Winner Winner Chicken Dinner!";
            } else if (getBotSelection().equals("scissors")) {
                return "Draw, worthy battle.";
            }
        }
        return "Error: Could not compute the outcome.";
    }
 }
