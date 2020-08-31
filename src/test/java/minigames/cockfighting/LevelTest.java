package minigames.cockfighting;

import org.junit.Test;
import static org.junit.Assert.*;

public class LevelTest {
    Level level = new Level();

    @Test
    public void testLevelUp() {
        assertEquals(1, level.getLevel());
    }
}
