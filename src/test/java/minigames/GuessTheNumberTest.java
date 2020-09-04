package minigames;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GuessTheNumberTest {

    GuessTheNumber game;

    @Test
    public void testGenerateValue() {
        game =  new GuessTheNumber(0,6);
        game.generateValue(0,6);
        assertTrue(game.getValue() >= 0 && game.getValue() <= 6);
    }

    @Test
    public void testCheckGuessWithUpperBound() {
        game =  new GuessTheNumber(0,6);
        game.setValue(6);
        game.setNumberOfGuesses(2);
        assertEquals("CHEATER!",game.checkGuess(6));
    }

    @Test
    public void testCheckGuessWithLowerBound() {
        game =  new GuessTheNumber(0,2);
        game.setValue(0);
        game.setNumberOfGuesses(2);
        assertEquals("CHEATER!",game.checkGuess(0));
    }

    @Test
    public void testCheckGuessWrong() {
        game =  new GuessTheNumber(0,3);
        game.setValue(1);
        game.setNumberOfGuesses(3);
        assertEquals("LOL u suck.",game.checkGuess(0));
    }

    @Test
    public void testCheckGuessOutOfBounds() {
        game =  new GuessTheNumber(0,3);
        game.setValue(1);
        game.setNumberOfGuesses(3);
        assertEquals("Your guess isn't within the bounds, monkey.",game.checkGuess(5));
    }

    @Test
    public void testOutOfGuesses() {
        game =  new GuessTheNumber(0,3);
        game.setValue(1);
        game.setNumberOfGuesses(1);
        game.checkGuess(0);
        assertEquals("No more guesses. Ur bad. :p", game.checkGuess(0));
    }


}

