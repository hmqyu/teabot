package minigames.cockfighting;

import org.junit.Test;
import static org.junit.Assert.*;

public class LevelTest {
    Level level = new Level();

    @Test
    public void testLevelUp() {
        assertEquals(1, level.getLevel());
        assertEquals(25, level.getExpPerWin());
        level.levelUp();
        assertEquals(2, level.getLevel());
        assertEquals(24, level.getExpPerWin());
        level.setExpPerWin(1);
        level.levelUp();
        assertEquals(3, level.getLevel());
        assertEquals(1, level.getExpPerWin());
    }

    @Test
    public void testGainExp() {
        assertEquals(1, level.getLevel());
        assertEquals(25, level.getExpPerWin());
        assertEquals(0, level.getExp());
        assertFalse(level.gainExp());
        assertEquals(1, level.getLevel());
        assertEquals(25, level.getExpPerWin());
        assertEquals(25, level.getExp());
        level.setExp(99);
        assertTrue(level.gainExp());
        assertEquals(2, level.getLevel());
        assertEquals(24, level.getExpPerWin());
        assertEquals(24, level.getExp());
        level.setExp(76);
        assertTrue(level.gainExp());
        assertEquals(3, level.getLevel());
        assertEquals(23, level.getExpPerWin());
        assertEquals(0, level.getExp());
    }
}
