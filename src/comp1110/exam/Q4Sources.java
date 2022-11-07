package comp1110.exam;

// static methods used by scaling test
import static java.lang.Math.pow;
import static java.lang.Math.min;
import static java.lang.Math.max;
import static java.lang.Math.abs;
import static comp1110.exam.Q4SourcesTest.intPow;
import static comp1110.exam.Q4SourcesTest.testCounts1;

/**
 * This class represents a network of connnected pipes.
 *
 * Each pipe has a unique id (an integer), which is defined by the order
 * in which pipes were added to the network; that is, the first pipe added
 * has id 0, the next has id 1, and so on. Removing pipes does not change
 * the id of the next pipe to be added.
 *
 * Connections are directional: each pipe can have between 0 and 3 incoming
 * connections, and between 0 and 3 outgoing connections.
 *
 * New pipes are added to the network with either an incoming or outgoing
 * connections. This is the only way that connections are added to the
 * network. (Note that because of this, the network will never contain a
 * cycle.)
 * 
 * Level 1: Complete all class methods below. You must complete your
 * implementation in this java file. However, you are allowed to (and
 * indeed encouraged to) define nested classes within this class if that
 * is useful for your solution.
 *
 * Level 2: Implement the addFrom, addTo, remove, and nSources methods
 * so that they all run in _(amortised) constant time_.
 *
 * The main method provided in this class will run tests to measure the
 * scaling behaviour of your implementation. If all operations are constant
 * time, then performing (2 * K) * N operations on a network of size N will
 * take approximately the same amount of time as performing K * (2 * N)
 * operations on a network of size (2 * N), i.e., the time is not dependent
 * on the size of the network. This is the relationship that the scaling
 * test measures. Because there is some randomness in runtime measurements,
 * we recommend you run the tests a few times to check that the results are
 * consistent.
 *
 * There is no requirement on the absolute running time of your implementation.
 * However, the scaling tests will use networks with up to over a million
 * pipes, so if your implementation is too slow, you will not be able to run
 * this test in a reasonable time. You can still run the functionality tests
 * (provided in the test class).
 */
public class Q4Sources {

    public Q4Sources() {
    }
  
    /**
     * Add a pipe to the network. The new pipe does not have any connections.
     * The method should return the id of the new pipe.
     */
    public int add() {
	// FIXME
	return -1;
    }
    
    /**
     * Add a pipe to the network with an incoming connection from an
     * already existing pipe in the network, if this does not break any
     * of the network rules:
     * - pipe fromPipeId must be one that exists in the network (previously
     * added and not removed); and
     * - pipe fromPipeId must have at most 2 already existing outgoing
     * connections.
     *
     * If adding the new pipe would break these rules, the method should
     * not add the pipe, and return -1. Otherwise, the method should update
     * the network and return the id of the new pipe.
     */
    public int addFrom(int fromPipeId) {
	// FIXME
	return -1;
    }

    /**
     * Add a pipe to the network with an outgoing connection to an
     * already existing pipe in the network, if this does not break any
     * of the network rules:
     * - pipe toPipeId must be one that exists in the network (previously
     * added and not removed); and
     * - pipe toPipeId must have at most 2 already existing incoming
     * connections.
     *
     * If adding the new pipe would break these rules, the method should
     * not add the pipe, and return -1. Otherwise, the method should update
     * the network and return the id of the new pipe.
     */
    public int addTo(int toPipeId) {
	// FIXME
	return -1;
    }

    /**
     * Remove a pipe from the network. This also removes all connections to
     * and from the pipe (but not the pipes it is connected to).
     *
     * If the pipeId does not exist in the network (has not been added or
     * has already been removed) then the method should not do anything.
     */
    public void remove(int pipeId) {
	// FIXME
    }

    /**
     * Return the number of sources in the network.
     *
     * A source is a pipe that has no incoming connections.
     */
    public int nSources() {
	// FIXME
	return 0;
    }

    /**
     * Test scaling behaviour: if all operations are (amortised) constant
     * time, the total time for each size (2^B .. 2^(B + M - 1)) should be
     * roughly equal.
     */
    static void testScaling() {
	final int M = 8;
	final int B = 10;
	int R = intPow(2, M) * 100;
	long[] times = new long[M];
	// primer
	for (int i = 0; i < 100; i++) {
	    testCounts1(B + M - 1);
	}
	for (int s = 0; s < M; s++) {
	    long t0 = System.nanoTime();
	    for (int i = 0; i < R; i++) {
		testCounts1(B + s);
	    }
	    long t1 = System.nanoTime();
	    times[s] = t1 - t0;
	    R = R / 2;
	}
	for (int s = 0; s < M; s++)
	    System.out.println("size " + intPow(2, B + s) + ": time = " + times[s]);
	long tmax = times[0];
	long tmin = times[0];
	double sum = times[0];
	int nInc = 0;
	for (int s = 1; s < M; s++) {
	    tmax = max(tmax, times[s]);
	    tmin = min(tmin, times[s]);
	    sum += times[s];
	    if (times[s] > times[s - 1])
		nInc += 1;
	}
	double avg = sum/M;
	double rd1 = ((double)abs(tmax - avg))/avg;
	double rd2 = ((double)abs(tmax - avg))/avg;
	System.out.println("max relative difference: " +
			   (max(rd1, rd2) * 100) + "%");
	System.out.println("# increasing: " +
			   nInc + " / " + (M - 1));
    }

    public static void main(String[] args) {
	testScaling();
    }
    
};
