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

    public String getUserSelection() {
        return userSelection;
    }

    public String getBotSelection() {

        if(generateBotSelection() == 0) {
            botSelection = ROCK;
        } else if (generateBotSelection() == 1) {
            botSelection = PAPER;
        } else {
            botSelection = SCISSORS;
        }

        return botSelection;

    }

    // determine winner of the rock-paper-scissors game (0 = win, 1 = tie, 2 = lose)
    public int getOutcome() {

        if (getUserSelection() == "rock") {
            if (getBotSelection() == "rock") {
                return 1;
            } else if (getBotSelection() == "paper") {
                return 2;
            } else {
                return 0;
            }
        } else if(getUserSelection() == "paper") {
            if(getBotSelection() == "rock") {
                return 0;
            } else if(getBotSelection() == "paper") {
                return 1;
            } else {
                return 2;
            }
        } else {
            if(getBotSelection() == "rock") {
                return 2;
            } else if(getBotSelection() == "paper") {
                return 0;
            } else {
                return 1;
            }
        }

    }
 }
