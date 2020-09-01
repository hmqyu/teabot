package minigames;

import org.junit.Test;
import static org.junit.Assert.*;

public class RockPaperScissorsTest {

    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";
    private static final String win = "Winner Winner Chicken Dinner!";
    private static final String draw = "Draw, worthy battle.";
    private static final String lose = "Shame.";
    private static final String error = "Error: Could not compute the outcome.";
    private String userChoice;
    private String botChoice;
    private RockPaperScissors game = new RockPaperScissors(userChoice);


    @Test
    public void testGetBotSelection() {
        botChoice = game.getBotSelection();
        assertTrue(botChoice.equals(ROCK) || botChoice.equals(PAPER) || botChoice.equals(SCISSORS));
    }


    @Test
    public void testRvR() {
        game.setUserSelection(ROCK);
        game.setBotSelection(ROCK);
        assertEquals(draw,game.getOutcome());
    }

    @Test
    public void testRvP() {
        game.setUserSelection(ROCK);
        game.setBotSelection(PAPER);
        assertEquals(lose,game.getOutcome());
    }

    @Test
    public void testRvS() {
        game.setUserSelection(ROCK);
        game.setBotSelection(SCISSORS);
        assertEquals(win,game.getOutcome());
    }

    @Test
    public void testPvR() {
        game.setUserSelection(PAPER);
        game.setBotSelection(ROCK);
        assertEquals(win,game.getOutcome());
    }

    @Test
    public void testPvP() {
        game.setUserSelection(PAPER);
        game.setBotSelection(PAPER);
        assertEquals(draw,game.getOutcome());
    }

    @Test
    public void testPvS() {
        game.setUserSelection(PAPER);
        game.setBotSelection(SCISSORS);
        assertEquals(lose,game.getOutcome());
    }

    @Test
    public void testSvR() {
        game.setUserSelection(SCISSORS);
        game.setBotSelection(ROCK);
        assertEquals(lose,game.getOutcome());
    }

    @Test
    public void testSvP() {
        game.setUserSelection(SCISSORS);
        game.setBotSelection(PAPER);
        assertEquals(win,game.getOutcome());
    }

    @Test
    public void testSvS() {
        game.setUserSelection(SCISSORS);
        game.setBotSelection(SCISSORS);
        assertEquals(draw,game.getOutcome());
    }

    @Test
    public void testError() {
        game.setUserSelection("test");
        game.setBotSelection(ROCK);
        assertEquals(error,game.getOutcome());
    }
}
