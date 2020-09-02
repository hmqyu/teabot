package persistence;

import exceptions.PersistenceException;
import minigames.cockfighting.Chicken;
import org.junit.Test;
import player.Player;
import player.PlayerList;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class DataReaderTest {

    @Test
    public void testParseSinglePlayer() {
        try {
            PlayerList playerList = DataReader.readPlayerList(
                    new File("./data/testDataReaderSinglePlayer.txt"));
            Player player = playerList.getPlayer(0);
            assertEquals("202967660491833345", player.getId());
            assertEquals(306, player.getMoney().getDollars());
            assertNull(player.getCurrentChicken());
            Chicken chicken = player.getChickens().get(0);
            assertEquals(45, chicken.getWinRate());
            assertEquals(0, chicken.getWins());
            chicken = player.getChickens().get(1);
            assertEquals(46, chicken.getWinRate());
            assertEquals(1, chicken.getWins());
        } catch (IOException | PersistenceException e) {
            fail("IOException and/or SaveDataException shouldn't be thrown.");
        }
    }

    @Test
    public void testParseMultiPlayer() {
        try {
            PlayerList playerList = DataReader.readPlayerList(
                    new File("./data/testDataReaderMultiPlayer.txt"));
            Player player = playerList.getPlayer(0);
            assertEquals("202980160491833345", player.getId());
            assertEquals(3, player.getMoney().getDollars());
            assertNull(player.getCurrentChicken());
            assertTrue(player.getChickens().isEmpty());

            player = playerList.getPlayer(1);
            assertEquals("202967957491833345", player.getId());
            assertEquals(1264829349, player.getMoney().getDollars());
            assertNull(player.getCurrentChicken());
            Chicken chicken = player.getChickens().get(0);
            assertEquals(50, chicken.getWinRate());
            assertEquals(5, chicken.getWins());
            chicken = player.getChickens().get(1);
            assertEquals(55, chicken.getWinRate());
            assertEquals(10, chicken.getWins());
            chicken = player.getChickens().get(2);
            assertEquals(55, chicken.getWinRate());
            assertEquals(10, chicken.getWins());
            chicken = player.getChickens().get(3);
            assertEquals(47, chicken.getWinRate());
            assertEquals(2, chicken.getWins());

            player = playerList.getPlayer(2);
            assertEquals("202967957415633345", player.getId());
            assertEquals(564, player.getMoney().getDollars());
            assertNull(player.getCurrentChicken());
            chicken = player.getChickens().get(0);
            assertEquals(45, chicken.getWinRate());
            assertEquals(0, chicken.getWins());
            chicken = player.getChickens().get(1);
            assertEquals(45, chicken.getWinRate());
            assertEquals(0, chicken.getWins());
        } catch (IOException e) {
            fail("IOException shouldn't be thrown.");
        } catch (PersistenceException e) {
            fail("PersistenceException shouldn't be thrown.");
        }
    }

    @Test
    public void testIOException() {
        try {
            DataReader.readPlayerList(new File("./no/path/here/testCollection.txt"));
        } catch (PersistenceException e) {
            fail("SaveDataException shouldn't be thrown.");
        } catch (IOException e) {
            // expected IOException
        }
    }

    @Test
    public void testPersistenceException() {
        try {
            DataReader.readPlayerList(new File("./data/testPersistenceException.txt"));
        } catch (PersistenceException e) {
            // expected PersistenceException
        } catch (IOException e) {
            fail("IOException shouldn't be thrown.");
        }
    }

}
