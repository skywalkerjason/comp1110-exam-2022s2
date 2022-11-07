package comp1110.exam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Q3ScheduleTest {

    static void doTest(String caseId,
		       int[] duration,
		       int max_schedule_time,
		       int[][] exclusions,
		       boolean[] exp) {
	System.out.println("test " + caseId);
	boolean[] ans = Q3Schedule.maximalSchedule(duration, max_schedule_time, exclusions);
	assertArrayEquals(exp, ans, caseId);
    }

    @Test
    public void simpleTests() {
	doTest("simple 1",
	       new int[]{40,45,55}, 90,
	       new int[][]{ {}, {}, {} },
	       new boolean[]{true, true, false});
	doTest("simple 2",
	       new int[]{55,45,40}, 90,
	       new int[][]{ {}, {}, {} },
	       new boolean[]{false, true, true});
	doTest("simple 3",
	       new int[]{4,2,6,3}, 10,
	       new int[][]{ {}, {}, {}, {} },
	       new boolean[]{true, true, false, true});
    }

    @Test
    public void smallTests() {
    	doTest("small 1",
    	       new int[]{2,3,4,6}, 9,
    	       new int[][]{ {1}, {}, {1,0}, {} },
    	       new boolean[]{false, true, false, true});
    	doTest("small 2",
    	       new int[]{2,3,4,6}, 9,
    	       new int[][]{ {2}, {0}, {1}, {0} },
    	       new boolean[]{false, true, false, true});
    	doTest("small 3",
    	       new int[]{2,3,4,6}, 9,
    	       new int[][]{ {2}, {0}, {1}, {1} },
    	       new boolean[]{true, false, false, true});
    	doTest("small 4",
    	       new int[]{2,3,4,6}, 9,
    	       new int[][]{ {2,1}, {3}, {1,0}, {0} },
    	       new boolean[]{false, false, false, true});
    }

    @Test
    public void mediumTests() {
    	doTest("medium 1",
    	       new int[]{10,10,15,25,30,35,45,55}, 90,
    	       new int[][]{ {}, {}, {}, {}, {}, {}, {}, {} },
    	       new boolean[]{true, true, true, true, true, false, false, false});
    	doTest("medium 2",
    	       new int[]{10,10,15,25,30,35,45,55}, 90,
    	       new int[][]{ {}, {4,5}, {}, {6}, {5}, {}, {1,3}, {3} },
    	       new boolean[]{true, true, true, false, false, false, false, true});
    	doTest("medium 3",
    	       new int[]{10,10,15,25,30,35,45,55}, 90,
    	       new int[][]{ {}, {4,5}, {}, {6}, {5}, {}, {1,3}, {2} },
    	       new boolean[]{true, false, true, true, false, true, false, false});
    }

    @Test
    public void largeTests() {
    	doTest("large 1",
    	       new int[]{10,11,14,15,24,25,32,33,45,46,65,66,80,81,90,91}, 360,
    	       new int[][]{ {1}, {0}, {3}, {2}, {5}, {4}, {7}, {6}, {9}, {8}, {11}, {10}, {13}, {12}, {15}, {14} },
    	       new boolean[]{true, false, true, false, true, false, true, false, true, false, true, false, true, false, true, false});
    	doTest("large 2",
    	       new int[]{10,11,14,15,24,25,32,33,45,46,65,66,80,81,90,91}, 380,
    	       new int[][]{ {1}, {0}, {3}, {2}, {5}, {4}, {7}, {6}, {9}, {8}, {11}, {10}, {13}, {12}, {15}, {14} },
    	       new boolean[]{false, true, false, true, false, true, false, true, false, true, false, true, false, true, false, true});
    	doTest("large 3",
    	       new int[]{10,11,14,15,24,25,32,33,45,46,65,66,80,81,90,91}, 360,
    	       new int[][]{ {1}, {0}, {3,0}, {2}, {5}, {4,2}, {7}, {6}, {9}, {8}, {11}, {10}, {13}, {12}, {15}, {14} },
    	       new boolean[]{false, false, false, true, false, true, false, true, false, true, false, true, false, true, false, true});
    }

}
