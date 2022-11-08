package comp1110.exam;

// import JUnit
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class Q5IsIncreasingTest {

    @Test
    public void testString() {
        // FIXME: Write at most 5 JUnit tests for the isIncreasing method.
        // The specification of the method is found in IsIncreasing.java.
        // Your tests should cover edge cases.
        // A correct implementation should pass all your tests.
        // Note that to test the isIncreasing method, you must instantiate
        // the class IsIncreasing with a type of your choice; you can use
        // different types for different tests.
        IsIncreasing<String> test1 = new IsIncreasing<>();
        String[] testString1 = new String[0];
        String[] testString2 = new String[5];
        System.out.println(testString2[0]);
        assertTrue(test1.isIncreasing(null), "expect true but got false");
        assertTrue(test1.isIncreasing(testString1), "expect true but got false");
        assertTrue(test1.isIncreasing(testString2), "expect true but got false");
        testString2[0] = "1";
        testString2[1] = "3";
        testString2[2] = "6";
        testString2[3] = "7";
        testString2[4] = "9";
        assertTrue(test1.isIncreasing(testString2), "expect true but got false");
        testString2[0] = "5";
        testString2[1] = "3";
        testString2[2] = "6";
        testString2[3] = "7";
        testString2[4] = "9";
        assertFalse(test1.isIncreasing(testString2), "expect false but got true");

    }

    @Test
    public void testInteger() {
        // FIXME: Write at most 5 JUnit tests for the isIncreasing method.
        // The specification of the method is found in IsIncreasing.java.
        // Your tests should cover edge cases.
        // A correct implementation should pass all your tests.
        // Note that to test the isIncreasing method, you must instantiate
        // the class IsIncreasing with a type of your choice; you can use
        // different types for different tests.
        IsIncreasing<Integer> test1 = new IsIncreasing<>();
        Integer[] testInt1 = new Integer[0];
        Integer[] testInt2 = new Integer[5];

        assertTrue(test1.isIncreasing(null), "expect true but got false");
        assertTrue(test1.isIncreasing(testInt1), "expect true but got false");
        assertTrue(test1.isIncreasing(testInt2), "expect true but got false");

        testInt2[0] = 5;
        testInt2[1] = 1;
        testInt2[2] = 4;
        testInt2[3] = 2;
        testInt2[4] = 3;
        assertFalse(test1.isIncreasing(testInt2), "expect false but got true");

    }

    class Cat implements Comparable<Cat> {
        String name;
        int age;

        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cat cat = (Cat) o;
            return age == cat.age && name.equals(cat.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public int compareTo(Cat o) {
            if (o == null) {
                return 1;
            }
            return this.age - o.age;
        }
    }

    Cat c1 = new Cat("AA", 1);
    Cat c2 = new Cat("BB", 2);
    Cat c3 = new Cat("CC", 3);

    @Test
    public void testCat() {
        // FIXME: Write at most 5 JUnit tests for the isIncreasing method.
        // The specification of the method is found in IsIncreasing.java.
        // Your tests should cover edge cases.
        // A correct implementation should pass all your tests.
        // Note that to test the isIncreasing method, you must instantiate
        // the class IsIncreasing with a type of your choice; you can use
        // different types for different tests.
        IsIncreasing<Cat> test1 = new IsIncreasing<>();
        Cat[] testCat1 = new Cat[0];
        Cat[] testCat2 = new Cat[3];

        assertTrue(test1.isIncreasing(null), "expect true but got false");
        assertTrue(test1.isIncreasing(testCat1), "expect true but got false");
        assertTrue(test1.isIncreasing(testCat2), "expect true but got false");
        testCat2[0] = c1;
        testCat2[1] = c3;
        testCat2[2] = c2;
        assertFalse(test1.isIncreasing(testCat2), "expect false but got true");

    }
}
