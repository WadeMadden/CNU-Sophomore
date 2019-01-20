import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Tester for the class Recursion. Tests all variants of input for the four
 * methods within the Recursive class
 * 
 * @author Wade Madden - 00912891
 * @version 20160924
 *
 */
public class RecursionTest {

    /**
     * Tests to make sure that the constructor returns an
     * UnsupportedOperationException.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void doesConstructorThrowUOException() {
        UnsupportedOperationException expected;
        expected = new UnsupportedOperationException();
        Recursion r = new Recursion();
        String actual = r.toString();
        assertEquals("Expected Exception to be thrown", expected, actual);
    }

    /**
     * Tests the factor method. Tests multiple variations for factors that
     * should return with a result equal to the expected result
     */
    @Test
    public void testTrueFactor() {
        // String with one factor
        String s1 = "1";
        int expected1 = 1;
        assertEquals("Should equal 1", expected1, Recursion.factor(s1));

        // String with multiple factors. Also checks to make sure spaces do not
        // effect outcome
        String s2 = "1 + 2 + 3 + 4 + 5";
        int expected2 = 15;
        assertEquals("Should equal 15", expected2, Recursion.factor(s2));

        // String with standard factors
        String s3 = "4+9+3";
        int expected3 = 16;
        assertEquals("Should equal 16", expected3, Recursion.factor(s3));
    }

    /**
     * Test the factor method. Tests for exceptions that should be thrown.
     */
    @Test
    public void testFalseFactorString() {
        // expected exception in all tests
        IllegalArgumentException expected = (new IllegalArgumentException());

        // tests for empty string. An empty string should result in a thrown
        // exception
        String s1 = "";
        try {
            Recursion.factor(s1);
            fail("Expected Exception to be thrown");
        }
        catch (Exception actual) {
            assertEquals("Incorrect Exception", expected.toString(),
                    actual.toString());
        }

        // tests for a string with non-digit values. Non-digit values should
        // result in a thrown exception
        String s2 = "a+s+d+f";
        try {
            Recursion.factor(s2);
            fail("Expected Exception to be thrown");
        }
        catch (Exception actual) {
            assertEquals("Incorrect Exception", expected.toString(),
                    actual.toString());
        }

        // tests for digits that are not single digits. Multi digit values
        // should result in a thrown exception
        String s3 = "1+12+123";
        try {
            Recursion.factor(s3);
            fail("Expected Exception to be thrown");
        }
        catch (Exception actual) {
            assertEquals("Incorrect Exception", expected.toString(),
                    actual.toString());
        }

        // tests for one multi-digit string. Any multi digits should result in a
        // thrown exception
        String s4 = "45";
        try {
            Recursion.factor(s4);
            fail("Expected Exception to be thrown");
        }
        catch (Exception actual) {
            assertEquals("Incorrect Exception", expected.toString(),
                    actual.toString());
        }

        // tests for operations other than the '+'. Any string with operations
        // other than '+' should result in a thrown exception
        String s5 = "6-2";
        try {
            Recursion.factor(s5);
            fail("Expected Exception to be thrown");
        }
        catch (Exception actual) {
            assertEquals("Incorrect Exception", expected.toString(),
                    actual.toString());
        }
    }

    /**
     * Tests the factorial method. Tests for exceptions to be thrown as a result
     * of large values less than zero
     */
    @Test
    public void testFactorialExceptionWithLargeNegativeNumber() {
        IllegalArgumentException expected = (new IllegalArgumentException());

        // generates random negative number
        int num = (int) ((Math.random() * Integer.MIN_VALUE) - 0);

        // IllegalArgumentException should be thrown
        try {
            Recursion.factorial(num);
            fail("Expected Exception to be thrown");
        }
        catch (Exception actual) {
            assertEquals("Incorrect Exception", expected.toString(),
                    actual.toString());
        }
    }

    /**
     * Tests the factorial method. Tests for exceptions to be thrown as a result
     * of smaller values less than zero
     */
    @Test
    public void testFactorialExceptionWithSmallNegativeNumber() {
        IllegalArgumentException expected = (new IllegalArgumentException());
        int num1 = -1;

        // IllegalArgumentException should be thrown
        try {
            Recursion.factorial(num1);
            fail("Expected Exception to be thrown");
        }
        catch (Exception actual) {
            assertEquals("Incorrect Exception", expected.toString(),
                    actual.toString());
        }

        int num2 = -25;

        // IllegalArgumentException should be thrown
        try {
            Recursion.factorial(num2);
            fail("Expected Exception to be thrown");
        }
        catch (Exception actual) {
            assertEquals("Incorrect Exception", expected.toString(),
                    actual.toString());
        }
    }

    /**
     * Tests the factorial method. Tests for the larger correct factorial of
     * numbers.
     */
    @Test
    public void testFactorialWithBiggerPositiveNumber() {
        // test factorial of 10
        int num1 = 10;
        int expected1 = 3628800;
        try {
            int actual = Recursion.factorial(num1);
            assertEquals("Actual and Expected values do not match", expected1,
                    actual);
        }
        catch (Exception e) {
            System.out.println("Exception should not be thrown.");
        }

        // test factorial of 12
        int num2 = 12;
        long expected2 = 479001600;
        try {
            int actual = Recursion.factorial(num2);
            assertEquals("Actual and Expected values do not match", expected2,
                    actual);
        }
        catch (Exception e) {
            System.out.println("Exception should not be thrown.");
        }
    }

    /**
     * Tests the factorial method. Tests for the smaller correct factorial of a
     * number.
     */
    @Test
    public void testFactorialWithPositiveNumber() {
        int num = 5;
        int expected = 120;
        try {
            int actual = Recursion.factorial(num);
            assertEquals("Actual and Expected values do not match", expected,
                    actual);
        }
        catch (Exception e) {
            System.out.println("Exception should not be thrown.");
        }
    }

    /**
     * Tests the factorial method. Tests for the base case of the recursive
     * method when the input is zero. The factorial of zero is one.
     */
    @Test
    public void testFactorialWithZero() {
        int num = 0;
        int expected = 1;
        try {
            int actual = Recursion.factorial(num);
            assertEquals("Actual and Expected values do not match", expected,
                    actual);
        }
        catch (Exception e) {
            System.out.println("Exception should not be thrown.");
        }
    }

    /**
     * Test for the isPalindrome method. Test for input that should result true.
     */
    @Test
    public void testActualPalindromes() {
        // Tests for capital letters. These should not change whether a word is
        // or is not a palindrome. Racecar is a palindrome as if racecar. Upper
        // or lower case should not change anything.
        String input1 = "Racecar";
        assertTrue("Should return true. Racecar is a Palindrome",
                Recursion.isPalindrome(input1));

        // Test for standard palindrome.
        String input2 = "abccba";
        assertTrue("Should return true. abccba is a Palindrome",
                Recursion.isPalindrome(input2));

        // Test for empty string. This is still considered a palindrome.
        String input3 = "";
        assertTrue("Should return true. An empty string is a Palindrome",
                Recursion.isPalindrome(input3));

        // Test for string of length 1. This is still a palindrome.
        String input4 = "D";
        assertTrue(
                "Should return true. A string with a "
                        + "length of one is a Palindrome",
                Recursion.isPalindrome(input4));
    }

    /**
     * Test for the isPalindrome method. Test for input that should result
     * false.
     */
    @Test
    public void testPalindromesForFalse() {
        // Test for obvious non-palindrome.
        String input1 = "Stalwart";
        assertFalse("Stalwart is not a palindrome.",
                Recursion.isPalindrome(input1));

        // Test for string with outer values the same but inner are not.
        String input2 = "abcdba";
        assertFalse("abcdba is not a palindrome.",
                Recursion.isPalindrome(input2));

        // Test for short non palindrome
        String input3 = "ad";
        assertFalse("ad is not a palindrome.", Recursion.isPalindrome(input3));

        // Test for null string
        String input4 = null;
        assertFalse("a null string is not a palindrome.",
                Recursion.isPalindrome(input4));
    }

    /**
     * Test for isIdentifier. Test for input that should return true.
     */
    @Test
    public void testValidIdentifiers() {
        // test for string beginning with a letter and multiple letters and
        // digits within.
        String input1 = "a1d34";
        assertTrue("ald34 is a valid Indentifier",
                Recursion.isIdentifier(input1));

        // test for capital at beginning
        String input2 = "Benny2";
        assertTrue("Benny2 is a valid Indentifier",
                Recursion.isIdentifier(input2));

        // test for single letter
        String input3 = "S";
        assertTrue("S is a valid Indentifier", Recursion.isIdentifier(input3));
    }

    /**
     * Test for isIdentifier. Test for input that should return false.
     */
    @Test
    public void testInvalidIdentifiers() {
        // test for single digit. An identifier must begin with a letter
        String input1 = "1";
        assertFalse("1 is not a valid Indentifier",
                Recursion.isIdentifier(input1));

        // test for empty string. An empty string is not an identifier
        String input2 = "";
        assertFalse("An empty string is not a valid Indentifier",
                Recursion.isIdentifier(input2));

        // test for string with multiple variables that are not acceptable.
        String input3 = "%$d0!";
        assertFalse("You can not have symbols in an identifier",
                Recursion.isIdentifier(input3));

    }

}
