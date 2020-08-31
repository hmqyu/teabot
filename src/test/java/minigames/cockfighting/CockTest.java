package minigames.cockfighting;

import org.junit.Test;
import static org.junit.Assert.*;

public class CockTest {
    private Cock cock = new Cock();

    @Test
    public void testHealth() {
        assertEquals(100, cock.getHealth());
        cock.loseHealth(25);
        assertEquals(75, cock.getHealth());
        cock.loseHealth(80);
        assertEquals(0, cock.getHealth());
        assertFalse(cock.isAlive());
        cock.restoreHealth();
        assertEquals(100, cock.getHealth());
        assertTrue(cock.isAlive());
        cock.loseHealth(100);
        assertEquals(0, cock.getHealth());
        assertFalse(cock.isAlive());
    }

    @Test
    public void testLevel() {
        int attack = cock.getAttack();
        int defense = cock.getDefense();
        int speed = cock.getSpeed();

        for (int i = 0; i < 4; i++) {
            cock.gainExp();
        }

        assertTrue(attack <= cock.getAttack());
        assertTrue(defense <= cock.getDefense());
        assertTrue(speed <= cock.getSpeed());

        assertTrue((cock.getAttack() - attack) <= 2);
        assertTrue((cock.getDefense() - defense) <= 2);
        assertTrue((cock.getSpeed() - speed) <= 2);
    }
}
