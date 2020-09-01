package persistence;

import org.junit.BeforeClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class DataWriterTest {
    private static final String FILE_TESTER = "./data/PlayerListTest.txt";
    private static DataWriter dataWriter;

    @BeforeClass
    public static void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        dataWriter = new DataWriter(new File(FILE_TESTER));
    }
}
