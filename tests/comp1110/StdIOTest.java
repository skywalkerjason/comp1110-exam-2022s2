package comp1110;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StdIOTest {
    private PrintStream realStdOut = System.out;
    private PrintStream readStdErr = System.err;

    /* get rid of OS-specific whitespace gorp */
    public String cleanupCRLF(String input) {
        return cleanupCRLF(input, false);
    }

    public String cleanupCRLF(String input, boolean replace) {
        // '#' represents newline, '_' represents space
        input = input.replaceAll("\\n", "#");
        input = input.replaceAll("\\r", "");
        input = input.replaceAll("\\s*#", "#");
        if (replace) {
            input = input.replaceAll("\\s", "_");
            //  input = input.replaceAll("#", "#\n");
        } else {
            input = input.replaceAll("#", System.lineSeparator());
        }
        return input;
    }

    public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(realStdOut);
        System.setErr(readStdErr);
    }
}
