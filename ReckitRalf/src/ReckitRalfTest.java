import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * This is the test class for the CPSC270 fall semester midterm.
 * 
 * @author Wade Madden - 00912891
 * @version 20161004
 *
 */
public class ReckitRalfTest {

    /**
     * Tests the constructor
     */
    @Test
    public void testReckitRalf() {
        ReckitRalf<Object> node = new ReckitRalf<Object>();
        assertEquals("null", node.getValue());
    }

    /**
     * Tests the factorial method. Tests for exceptions to be thrown as a result
     * of large values less than zero
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFactorialExceptionWithLargeNegativeNumber() {

        // generates random negative number
        int num = (int) ((Math.random() * Integer.MIN_VALUE) - 0);

        // IllegalArgumentException should be thrown

        ReckitRalf.factorial(num);
        fail("Expected Exception to be thrown");

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
            ReckitRalf.factorial(num1);
            fail("Expected Exception to be thrown");
        }
        catch (Exception actual) {
            assertEquals("Incorrect Exception", expected.toString(),
                    actual.toString());
        }

        int num2 = -25;

        // IllegalArgumentException should be thrown
        try {
            ReckitRalf.factorial(num2);
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
            int actual = ReckitRalf.factorial(num1);
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
            int actual = ReckitRalf.factorial(num2);
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
            int actual = ReckitRalf.factorial(num);
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
            int actual = ReckitRalf.factorial(num);
            assertEquals("Actual and Expected values do not match", expected,
                    actual);
        }
        catch (Exception e) {
            System.out.println("Exception should not be thrown.");
        }
    }

    /**
     * Tests the sum method
     */
    @Test
    public void testSumOfVariousIntegers() {
        int n1 = 5;
        int expected1 = 15;
        int ans1 = ReckitRalf.sum(n1);
        assertEquals("The answer should be 15", expected1, ans1);

        int n2 = 10;
        int expected2 = 55;
        int ans2 = ReckitRalf.sum(n2);
        assertEquals("The answer should be 55", expected2, ans2);

        int n3 = 12;
        int expected3 = 78;
        int ans3 = ReckitRalf.sum(n3);
        assertEquals("The answer should be 78", expected3, ans3);
    }

    /**
     * Tests the get value method
     */
    @Test
    public void testGetValue() {
        ReckitRalf<Object> n = new ReckitRalf<Object>();
        n.insert("ben");
        n.insert("tim");
        n.insert("bobby");
        // checks for value at beginning of list
        assertEquals("bobby", n.getValue());
        n.next();
        // checks for value at middle of list
        assertEquals("tim", n.getValue());
        n.next();
        // checks for value at end of list
        assertEquals("ben", n.getValue());

    }

    /**
     * Tests the insert method. Should add an object to the list
     */
    @Test
    public void testInsert() {
        ReckitRalf<Object> n = new ReckitRalf<Object>();
        String u = "hi";
        n.insert(u);
        assertEquals(u, n.getValue());
    }

    /**
     * Tests the next method
     */
    @Test
    public void testNext() {
        ReckitRalf<Object> n = new ReckitRalf<Object>();
        n.insert("tom");
        n.insert("kyle");
        n.next();
        assertEquals("tom", n.getValue());
        n.insert("francis");
        assertEquals("francis", n.getValue());
    }

}
