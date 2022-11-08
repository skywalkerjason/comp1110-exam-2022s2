package comp1110.exam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Q2ThreeOddTest {

    public static void doTest(String in, int out) {
        assertEquals(out, Q2ThreeOdd.threeOdd(in), "threeOdd(" + in + ")");
    }

    @Test
    public void set1() {
        doTest("3333",0);
        doTest("96333", 6);
        doTest("33210",7);
        doTest("11133",9);
        doTest("66339", 12);
        doTest("6993",6);
        doTest("69",6);
    }

    @Test
    public void set2() {
        doTest("1",1);
        doTest("3", 0);
        doTest("0",0);
        doTest("4",0);
    }

    @Test
    public void set3() {
        doTest("",-1);
        doTest("-1", -1);
        doTest("-88",-1);
        doTest("abba",-1);
    }
}
