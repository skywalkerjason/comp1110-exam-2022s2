package comp1110.exam;


public class Q2ThreeOdd {

    /**
     * Input to the method is a string.
     *
     * Return the sum of the even-valued digits if the string represents
     * a ThreeOdd number
     *
     * Return the sum of the odd-valued digits if the string represents
     * a number that is not a ThreeOdd number.
     *
     * In any other case (for example, if the input string empty or does
     * not represent a number) return -1.
     *
     * A ThreeOdd number is defined by the following rules:
     * a) is a non-negative integer (may have one or more leading zeros,
     * e.g., 00303 is equivalent to 303);
     * b) is odd and divisible by three;
     * c) after removing the first and last digits, the remaining digits
     * are still a ThreeOdd number, or an empty string.
     *
     * Examples of ThreeOdd numbers: "3333", "96333", "39363", "6993", "3",
     * "69". As these are ThreeOdd numbers this method should return 0, 12,
     * 6, 18, 0, 0, respectively.
     *
     * Examples that are NOT ThreeOdd numbers: "2366", "4587", "1", "44",
     * "996", "0", As these aren't ThreeOdd numbers this method should
     * return 3, 12, 1, 0, 18, 0, respectively.
     *
     *
     * @param number A string.
     * @return The sum of the even-valued digits if the string is a ThreeOdd
     * number, the sum of the odd-valued digits if the string represents a
     * number that is not a ThreeOdd number, * -1 in any other case.
     */
    public static int threeOdd(String number) {
        //FIXME: implement this method
        return 0;
    }
}
