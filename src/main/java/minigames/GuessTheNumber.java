package minigames;

import java.util.concurrent.ThreadLocalRandom;

public class GuessTheNumber {
    public int guess;
    public int value;
    public int start;
    public int end;
    public int numberOfGuesses;

    public GuessTheNumber(int start,int end) {
        this.start = start;
        this.end = end;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setBounds(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setNumberOfGuesses(int numberOfGuesses) {
        this.numberOfGuesses = numberOfGuesses;
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public void generateValue(int start, int end) {
        this.value = ThreadLocalRandom.current().nextInt(start,end);
    }

    public String checkGuess(int guess) {
        if (numberOfGuesses > 0) {
            if (guess == value) {
                return "CHEATER!";
            } else if (guess > end || guess < start) {
                return "Your guess isn't within the bounds, monkey.";
            } else {
                setNumberOfGuesses(getNumberOfGuesses() - 1);
                return "LOL u suck.";
            }
        }
        return "No more guesses. Ur bad. :p";
    }

}
