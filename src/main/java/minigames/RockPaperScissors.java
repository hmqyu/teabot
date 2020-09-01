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
        userSelection = userInput;

    }

    public int generateBotSelection() {
        return number.nextInt(2);

    }

    public void setBotSelection(String botChoice) {
        botSelection = botChoice;
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

        if (userSelection.equals(ROCK)) {
            if (botSelection.equals(ROCK)) {
                return "Draw, worthy battle.";
            } else if (botSelection.equals(PAPER)) {
                return "Shame.";
            } else if (botSelection.equals(SCISSORS)) {
                return "Winner Winner Chicken Dinner!";
            }
        } else if (userSelection.equals(PAPER)) {
            if (botSelection.equals(ROCK)) {
                return "Winner Winner Chicken Dinner!";
            } else if (botSelection.equals(PAPER)) {
                return "Draw, worthy battle.";
            } else if (botSelection.equals(SCISSORS)) {
                return "Shame.";
            }
        } else if (userSelection.equals(SCISSORS)) {
            if (botSelection.equals(ROCK)) {
                return "Shame.";
            } else if (botSelection.equals(PAPER)) {
                return "Winner Winner Chicken Dinner!";
            } else if (botSelection.equals(SCISSORS)) {
                return "Draw, worthy battle.";
            }
        }
        return "Error: Could not compute the outcome.";
    }
 }
