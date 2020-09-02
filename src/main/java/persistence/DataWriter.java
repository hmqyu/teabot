package persistence;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

// Represents a writer that writes a cat's data to a file
// Class is heavily inspired by the AccountNotRobust project (specifically the Writer class) given to us in CPSC 210
public class DataWriter {
    private PrintWriter writer;   // a general writer

    // EFFECTS: constructs a writer that can write a collection of cats and/or a cat's data to file
    public DataWriter(File file) throws FileNotFoundException, UnsupportedEncodingException {
        writer = new PrintWriter(file, "UTF-8");
    }

    // MODIFIES: this
    // EFFECTS: writes data to file
    public void write(Data data) {
        data.save(writer);
    }

    // MODIFIES: this
    // EFFECTS: closes the print writer
    public void close() {
        writer.close();
    }
}
