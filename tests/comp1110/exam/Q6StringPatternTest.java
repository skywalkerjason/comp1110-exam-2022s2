package comp1110.exam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Stack;
import java.util.HashSet;

public class Q6StringPatternTest {

    static final String[] cases = {
	"c",
	"at c |",
	"c at +",
	"c at c | +",
	"c at c + |",
	"c at c + +",
	"v o + i d + +",
	"v o + i d + |",
	"v o | i d | +",
	"v o + i + d +",
	"v o i d + + +",
	"v i + o d + +",
	"v i + o + d +",
	"v i o d + + +",
	"d o + v i + +",
	"i d + v o + |",
	"i d | o v | +",
	"s p + i n + +",
	"s p + i + n +",
	"s p i n + + +"
    };

    static String[] readable = new String[]{
    	"\"c\"",
    	"(\"at\" | \"c\")",
    	"(\"c\" + \"at\")",
    	"(\"c\" + (\"at\" | \"c\"))",
    	"(\"c\" | (\"at\" + \"c\"))",
    	"(\"c\" + (\"at\" + \"c\"))",
    	"((\"v\" + \"o\") + (\"i\" + \"d\"))",
    	"((\"v\" + \"o\") | (\"i\" + \"d\"))",
    	"((\"v\" | \"o\") + (\"i\" | \"d\"))",
    	"(((\"v\" + \"o\") + \"i\") + \"d\")",
    	"(\"v\" + (\"o\" + (\"i\" + \"d\")))",
    	"((\"v\" + \"i\") + (\"o\" + \"d\"))",
    	"(((\"v\" + \"i\") + \"o\") + \"d\")",
    	"(\"v\" + (\"i\" + (\"o\" + \"d\")))",
    	"((\"d\" + \"o\") + (\"v\" + \"i\"))",
    	"((\"i\" + \"d\") | (\"v\" + \"o\"))",
    	"((\"i\" | \"d\") + (\"o\" | \"v\"))",
    	"((\"s\" + \"p\") + (\"i\" + \"n\"))",
    	"(((\"s\" + \"p\") + \"i\") + \"n\")",
    	"(\"s\" + (\"p\" + (\"i\" + \"n\")))"
    };

    public static Q6StringPattern parse(String s) {
	String[] tokens = s.split(" ");
	Stack<Q6StringPattern> stack = new Stack<Q6StringPattern>();
	for (int i = 0; i < tokens.length; i++) {
	    if (tokens[i].equals("+")) {
		Q6StringPattern rhs = stack.pop();
		Q6StringPattern lhs = stack.pop();
		stack.push(new StringOperator(StringOperatorType.CONCATENATION, lhs, rhs));
	    }
	    else if (tokens[i].equals("|")) {
		Q6StringPattern rhs = stack.pop();
		Q6StringPattern lhs = stack.pop();
		stack.push(new StringOperator(StringOperatorType.CHOICE, lhs, rhs));
	    }
	    else {
		stack.push(new StringConstant(tokens[i]));
	    }
	}
	assert (stack.size() == 1);
	return stack.pop();
    }

    @Test
    void testEquals() {
	// two copies of each pattern should be equal
	for (int i = 0; i < cases.length; i++) {
	    Q6StringPattern p1 = parse(cases[i]);
	    Q6StringPattern p2 = parse(cases[i]);
	    assertTrue(p1.equals(p2), readable[i] + " equals " + readable[i]);
	    assertTrue(p2.equals(p1), readable[i] + " equals " + readable[i]);
	}
	// each pair of different patterns should be not equal
	for (int i = 0; i + 1 < cases.length; i++)
	    for (int j = i + 1; j < cases.length; j++) {
		Q6StringPattern p1 = parse(cases[i]);
		Q6StringPattern p2 = parse(cases[j]);
		assertFalse(p1.equals(p2), readable[i] + " equals " + readable[j]);
		assertFalse(p2.equals(p1), readable[j] + " equals " + readable[i]);
	    }
    }

    @Test
    void testHashEq() {
	// two copies of each pattern should hash to same value
	for (int i = 0; i < cases.length; i++) {
	    Q6StringPattern p1 = parse(cases[i]);
	    Q6StringPattern p2 = parse(cases[i]);
	    assertTrue(p2.hashCode() == p1.hashCode(), readable[i] + ".hashCode() == " + readable[i] + ".hashCode()");
	}
    }

    // dev: test quality of hash function by counting how many distinct
    // values: 2, 6, and 16.
    @Test
    void testHash2() {
	HashSet<Integer> values = new HashSet<Integer>();
	for (int i = 0; i < cases.length; i++) {
	    Q6StringPattern p = parse(cases[i]);
	    values.add(p.hashCode());
	}
	System.out.println(cases.length + " patterns hashed to " + values.size() + " distinct values");
	assertTrue(values.size() >= 2, Integer.toString(cases.length) + " patterns hashed to " + Integer.toString(values.size()) + " < 2 distinct values");
    }

    @Test
    void testHash6() {
	HashSet<Integer> values = new HashSet<Integer>();
	for (int i = 0; i < cases.length; i++) {
	    Q6StringPattern p = parse(cases[i]);
	    values.add(p.hashCode());
	}
	System.out.println(cases.length + " patterns hashed to " + values.size() + " distinct values");
	assertTrue(values.size() >= 6, Integer.toString(cases.length) + " patterns hashed to " + Integer.toString(values.size()) + " < 6 distinct values");
    }
    
    @Test
    void testHash16() {
	HashSet<Integer> values = new HashSet<Integer>();
	for (int i = 0; i < cases.length; i++) {
	    Q6StringPattern p = parse(cases[i]);
	    values.add(p.hashCode());
	}
	System.out.println(cases.length + " patterns hashed to " + values.size() + " distinct values");
	assertTrue(values.size() >= 16, Integer.toString(cases.length) + " patterns hashed to " + Integer.toString(values.size()) + " < 16 distinct values");
    }

}
