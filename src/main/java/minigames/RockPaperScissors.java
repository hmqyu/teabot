package minigames;

import java.util.Random;

public class RockPaperScissors {
    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";
    private String userSelection;
    private String botSelection;
    Random number = new Random();


    public RockPaperScissors() {

    }

    public void setUserSelection(String userInput) {

    }

    public int generateBotSelection() {
        return number.nextInt(2);

    }

    public void getUserSelection() {

    }

    public void getBotSelection() {

        if(generateBotSelection() == 0) {
            botSelection = ROCK;
        } else if (generateBotSelection() == 1) {
            botSelection = PAPER;
        } else {
            botSelection = SCISSORS;
        }

    }
}
