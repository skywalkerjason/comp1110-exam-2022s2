package comp1110.mse;

import comp1110.StdIOTest;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

@Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
public class Q0HelloWorldTest extends StdIOTest {
    @Test
    void exactlyCorrect() {
        Q0HelloWorld.main(null);
        Assertions.assertEquals("Hello World" + System.lineSeparator(), outContent.toString());
    }
}
