package comp1110.exam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.Math.abs;
import java.util.StringJoiner;

// Note: Tests here check that the value returned by your method is within
// a specified tolerance (10^-6) of the average; this is to avoid spurious
// errors due to rounding errors in floating point calculations.

public class Q1AverageInRangeTest {

    final static double TOL = 1e-6;

    public void doTest(int[] in, int start, int end, double out) {
	double rv = Q1AverageInRange.averageInRange(in, start, end);
	StringJoiner j = new StringJoiner(", ");
	for (int n : in) j.add(Integer.toString(n));
	assertTrue(abs(out - rv) < TOL, "averageInRange({" + j.toString() + "}, " + start + ", " + end + ") within " + TOL + " of " + out);
    }

    @Test
    public void testAverageInRange() {
	doTest(new int[]{1, 2, 3, 4, 5}, 3, 5, 4);
	doTest(new int[]{3, 4, 5, 2, 1}, 2, 4, 3);
	doTest(new int[]{-4, -3, 2, 8, 10 }, -3, 9, 2.333333);
	doTest(new int[]{-2, -3, -4, -5, -7, -9}, 1, -2, -2.0);
	doTest(new int[]{-6, -3, -4, -5, -7, -9}, -6, 10, -4.5);
    }

}
