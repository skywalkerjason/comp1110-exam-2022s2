package comp1110.exam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Q4SourcesTest {

    @Test
    public void testAdd1() {
	Q4Sources n = new Q4Sources();
	int id = n.add();
	assertEquals(0, id, "testAdd: id of first pipe added != 0");
	id = n.addFrom(0);
	assertEquals(1, id, "testAdd: id of second pipe added != 1");
	id = n.addTo(0);
	assertEquals(2, id, "testAdd: id of third pipe added != 2");
    }

    @Test
    public void testAddFrom() {
	Q4Sources n = new Q4Sources();
	int id = n.add();
	assertEquals(0, id, "testAdd: id of first pipe added != 0");
	id = n.addFrom(0);
	assertEquals(1, id, "testAdd: id of second pipe added != 1");
	id = n.addFrom(0);
	assertEquals(2, id, "testAdd: id of third pipe added != 2");
	id = n.addFrom(0);
	assertEquals(3, id, "testAdd: id of fourth pipe added != 3");
	// can't add a fourth outgoing pipe from 0
	id = n.addFrom(0);
	assertEquals(-1, id, "testAdd: invalid addFrom != -1");
    }

    @Test
    public void testAddTo() {
	Q4Sources n = new Q4Sources();
	int id = n.add();
	assertEquals(0, id, "testAdd: id of first pipe added != 0");
	id = n.addTo(0);
	assertEquals(1, id, "testAdd: id of second pipe added != 1");
	id = n.addTo(0);
	assertEquals(2, id, "testAdd: id of third pipe added != 2");
	id = n.addTo(0);
	assertEquals(3, id, "testAdd: id of fourth pipe added != 3");
	// can't add a fourth incoming pipe to 0
	id = n.addTo(0);
	assertEquals(-1, id, "testAdd: invalid addTo != -1");
    }

    @Test
    public void testRemove() {
	Q4Sources n = new Q4Sources();
	int id = n.add();
	assertEquals(0, id, "testRemove: id of first pipe added != 0");
	id = n.addFrom(0);
	assertEquals(1, id, "testRemove: id of second pipe added != 1");
	id = n.addTo(0);
	assertEquals(2, id, "testRemove: id of third pipe added != 2");
	n.remove(0);
	id = n.addFrom(0);
	assertEquals(-1, id, "testRemove: addFrom with invalid arg != -1");
	id = n.addTo(0);
	assertEquals(-1, id, "testRemove: addTo with invalid arg != -1");
	id = n.addFrom(1);
	assertEquals(3, id, "testRemove: id of fourth pipe added != 3");
	id = n.addTo(2);
	assertEquals(4, id, "testRemove: id of fifth pipe added != 4");
    }

    static int intPow(int a, int b) {
	int r = 1;
	while (b > 0) {
	    r = r * a;
	    b -= 1;
	}
	return r;
    }

    static void testCounts1(int k) {
    	int n2 = intPow(2, k - 1);
    	Q4Sources n = new Q4Sources();
    	int id = n.add();
    	for (int i = 0; i < n2 - 1; i++) {
    	    n.addFrom(i);
    	    n.addFrom(i);
    	}
    	assertEquals(1, n.nSources(), "incorrect number of sources");
    	for (int i = 0; i < n2 - 1; i++) {
    	    n.remove(i);
    	    assertEquals(2 + i, n.nSources(), "incorrect number of sources");
    	}
    }

    static void testCounts2(int k) {
    	int n2 = intPow(2, k - 1);
    	Q4Sources n = new Q4Sources();
    	int id = n.add();
    	for (int i = 0; i < n2 - 1; i++) {
    	    n.addTo(i);
    	    n.addTo(i);
    	}
    	assertEquals(n2, n.nSources(), "incorrect number of sources");
    }

    @Test
    public void testSources() {
	testCounts1(3);
	testCounts2(3);
    }
    
};
