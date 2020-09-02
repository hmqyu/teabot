package minigames;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GuessTheNumberTest {

    private int value;
    private int guess;
    private int start;
    private int end;
    private int numberOfGuesses;
    GuessTheNumber game;

    void runBefore() {
        game = new GuessTheNumber(guess,start,end);
    }

    @Test
    void testGenerateValue() {
        game.generateValue(start,end);
        assertTrue(value >= start && value <= end);
    }

    @Test
    void testCheckGuessWithUpperBound() {
        game.setValue(6);
        game.setGuess(6);
        game.setBounds(0,6);
        game.setNumberOfGuesses(2);
        assertEquals("CHEATER!",game.checkGuess());
    }

    @Test
    void testCheckGuessWithLowerBound() {
        game.setValue(0);
        game.setGuess(0);
        game.setBounds(0,2);
        game.setNumberOfGuesses(2);
        assertEquals("CHEATER!",game.checkGuess());
    }

    @Test
    void testCheckGuessWrong() {
        game.setValue(1);
        game.setGuess(0);
        game.setBounds(0,3);
        game.setNumberOfGuesses(3);
        assertEquals("LOL u suck.",game.checkGuess());
    }

    @Test
    void testCheckGuessOutOfBounds() {
        game.setValue(1);
        game.setGuess(5);
        game.setBounds(0,3);
        game.setNumberOfGuesses(3);
        assertEquals("Your guess isn't within the bounds, monkey.",game.checkGuess());
    }

    @Test
    void testOutOfGuesses() {
        game.setValue(1);
        game.setGuess(0);
        game.setBounds(0,3);
        game.setNumberOfGuesses(1);
        game.checkGuess();
        assertEquals("No more guesses. Ur bad. :p", game.checkGuess());
    }


}

