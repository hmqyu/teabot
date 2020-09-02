package persistence;

import java.io.PrintWriter;

// Represents a cat that is saved to a file
// Class is heavily inspired by the AccountNotRobust project (specifically the Saveable class) given to us in CPSC 210
public interface Data {
    // MODIFIES: printWriter
    // EFFECTS: writes the save data (ie. a cat) to printWriter
    void save(PrintWriter printWriter);
}
