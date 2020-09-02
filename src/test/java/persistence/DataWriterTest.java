package persistence;

import exceptions.PersistenceException;
import minigames.cockfighting.Chicken;
import org.junit.BeforeClass;
import org.junit.Test;
import player.Player;
import player.PlayerList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import static org.junit.Assert.*;

public class DataWriterTest {
    private static final String FILE_TESTER = "./data/testDataWriter.txt";
    private static DataWriter dataWriter;

    @BeforeClass
    public static void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        dataWriter = new DataWriter(new File(FILE_TESTER));
    }

    @Test
    public void testDataWriter() {
        PlayerList players = new PlayerList();
        Player harvir = new Player("202967660491833345");
        harvir.addMoney(1523);
        harvir.addChicken(new Chicken(50, 5));
        harvir.addChicken(new Chicken());
        harvir.setCurrentChicken(new Chicken());
        players.addPlayer(harvir);
        Player helen = new Player("426967660491833345");
        helen.removeMoney(85);
        players.addPlayer(helen);

        dataWriter.write(players);
        dataWriter.close();

        try {
            players = DataReader.readPlayerList(new File(FILE_TESTER));

            Player player = players.getPlayer(0);
            assertEquals("202967660491833345", player.getId());
            assertEquals(1623, player.getMoney().getDollars());
            assertNull(player.getCurrentChicken());
            Chicken chicken = player.getChickens().get(0);
            assertEquals(50, chicken.getWinRate());
            assertEquals(5, chicken.getWins());
            chicken = player.getChickens().get(1);
            assertEquals(45, chicken.getWinRate());
            assertEquals(0, chicken.getWins());

            player = players.getPlayer(1);
            assertEquals("426967660491833345", player.getId());
            assertEquals(15, player.getMoney().getDollars());
            assertNull(player.getCurrentChicken());
            assertTrue(player.getChickens().isEmpty());

        } catch (IOException | PersistenceException e) {
            fail("IOException and/or PersistenceException shouldn't be thrown.");
        }
    }
}
