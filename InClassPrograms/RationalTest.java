package InClassPrograms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * RationalTest demonstrates how to write JUnit tests.
 * 
 * <pre>
 * Syntax:
 * -Your JUnit class must have the word "test" in the name, preferably at the
 *  end. See the name of this class for an example.
 * -Type the Test annotation (@Test) immediately before your test method header.
 * -Your test method must be public void without any parameters.
 * </pre>
 * 
 * <pre>
 * Writing a Test Method that does not expect an exception to be thrown:
 * 
 * Overview: JUnit tests must have the following basic parts:
 * a. set up the preconditions
 * b. invoke the method under test
 * c. verify the postconditions are true
 * 
 * Details:
 * a. Set up the problem instance (pre and post conditions):
 *  1. Create a problem instance:
 *   1. preconditions: define a variable for each of your test inputs
 *   2. postconditions: define a variable for each of your expected outputs
 * 
 * b. Invoke the method under test
 *  1. If you are testing an instance method, you must instantiate it first.
 *     If you are testing a static method, just call it.
 *  2. Call the method being tested using the test inputs, and collect the test
 *     outputs.
 * 
 * c. verify the postconditions are true
 *  1. use an assert statement to check the postcondition
 * </pre>
 * 
 * <pre>
 * Writing a Test Method that EXPECTS an exception to be thrown:
 * 
 * Overview: JUnit tests must have the following basic parts:
 * a. set up dummy object
 * b. set up the precondition
 * c. invoke the method under test
 * d. verify the postcondition is true
 * 
 * Details:
 * a. Set up the dummy object. This is to be able to write an assert that passes
 *  1. define a reference variable and instantiate an object
 *  2. assertNotNull(theReferenceVariable);
 *  
 * b. Set up the problem instance (pre and post conditions):
 *  1. Create a problem instance:
 *   1. preconditions: define a variable for each of your test inputs. Choose
 *      a value that will cause the exception to be thrown
 *   2. postcondition: @Test (expected = ExceptionName.class)
 * 
 * c. Invoke the method under test
 *  1. If you are testing an instance method, you must instantiate it first.
 *     If you are testing a static method, just call it.
 *  2. Call the method being tested. Pass it the test inputs.
 * 
 * d. verify the postcondition is true
 *  1. this is done automatically for you by JUnit, when you type the 
 *     test annotation, Test (expected = ExceptionName.class)
 * </pre>
 * 
 * <h2>Test Design</h2>
 * <p>
 * This section discusses best practices for test design.
 * </p>
 * <h3>Test Method Cohesion</h3>
 * <p>
 * A test method is just like any method, it must be cohesive. In the case of a
 * test, this means a test method must test a single case, not multiple cases.
 * Below are examples of a cohesive method and a poorly cohesive method.
 * 
 * <pre>
 * // a cohesive test
 * &#64;Test
 * public void doesEqualsReturnTrueIfTwoRationalsAreEqual() {
 *     Rational r1 = new Rational(1, 2);
 *     Rational r2 = new Rational(1, 2);
 *     assertTrue(r1.equals(r2));
 * }
 * 
 * // a poorly cohesive test
 * &#64;Test(expected = IllegalArgumentException.class)
 * public void doesEqualsCheckIfEqualsAreEqualAndNonEqualsAreNot() {
 *     Rational r1 = new Rational(1, 2);
 *     Rational r2 = new Rational(1, 2);
 *     Rational r3 = new Rational(1, 23);
 *     assertTrue(r1.equals(r2));
 *     assertFalse(r1.equals(r3));
 *     Rational r4 = new Rational(1, 0);
 * }
 * </pre>
 * </p>
 * <h3>Why is this the best practice?</h3>
 * <p>
 * The assert methods will do nothing if the condition passes, but will throw an
 * exception if it fails. For example, in the poor method above, if the first
 * assert fails, it will throw and the rest of the method will not be executed.
 * This means the rest of the asserts will not run. You will then have to fix
 * the problem, run the test again before the second assert is run. If that
 * fails, it throws, and the rest of the method is not executed, and so on.
 * </p>
 * <p>
 * If however, you separate the asserts, then even if an assert fails, the
 * others will be run because they are in separate test methods. You only need
 * to run JUnit once in order to determine the results of each of the asserts.
 * </p>
 * <p>
 * This does not mean only one assert per test method. Sometimes a test case has
 * multiple things that must be true. For example, equality requires that
 * a.equals(b) and b.equals(a) are both true. In this situation you would have
 * two asserts in the equals method.
 * </p>
 * <h3>Naming Test Methods</h3>
 * <p>
 * A test method name should specify exactly what is being tested. This means
 * writing it as a question that states the inputs and the expected results.
 * Here are some poor test names: "test1," "doesEqualsWork," "isEqualsTrue."
 * Here is a good test name: "doesEqualsReturnTrueIfBothRationalsAreEqual."
 * </p>
 * 
 * @author acsiochi
 * @version 20160921
 */
public class RationalTest {

    /**
     * does the constructor set the numerator and denominator. This test uses
     * the constructor, numerator() and denominator() methods.
     */
    @Test
    public void doesConstructorSetTheNumeratorAndDenominator() {
        // preconditions:
        int inputN = 1;
        int inputD = 2;

        // postconditions
        int expectedN = inputN;
        int expectedD = inputD;

        // instantiate the object whose method you want to test.
        // call the method being tested. in this case, its the constructor
        Rational r = new Rational(expectedN, expectedD);

        // verify the postconditions are true
        assertEquals("numerator was not set correctly", expectedN,
                r.numerator());
        assertEquals("denominator was not set correctly", expectedD,
                r.denominator());
    }

    /**
     * does denominator get the value set by setDenominator. This method uses
     * the constructor, setDenominator() and denominator() instance methods.
     */
    @Test
    public void doesDenominatorGetTheValueSetBySetDenominator() {
        // precondition
        int inputD = 2;

        // postcondition
        int expectedD = inputD;

        // instantiate the object whose instance method you want to test
        Rational r = new Rational(0, 1);

        // call the method
        r.setDenominator(expectedD);

        // verify the postcondition
        assertEquals("denominator was not set correctly", expectedD,
                r.denominator());
    }

    /**
     * does instantiating a Rational with a 0 denominator throw an
     * IllegalArgumentException.
     */
    // verify the postcondition is true
    @Test(expected = IllegalArgumentException.class)
    public void doesInstantiatingARationalWithZeroDenParameterThrowIAE() {
        // dummy instantiation
        Integer n = new Integer(1);
        assertNotNull(n);

        // preconditions:
        int inputN = 1;
        int inputD = 0;

        // postconditions
        // an IllegalArgumentException

        // instantiate the object whose method you want to test.
        // call the method being tested. in this case, its the constructor
        new Rational(inputN, inputD);

        // NO statements after the statement expected to throw the exception
    }

    /**
     * does calling setDenominator with 0 throw an exception
     */
    // verify the postcondition is true
    @Test(expected = IllegalArgumentException.class)
    public void doesSetDenominatorWithZeroParameterThrowIAE() {
        // dummy instantiation
        Integer n = new Integer(1);
        assertNotNull(n);

        // preconditions:
        int inputD = 0;

        // postconditions
        // an IllegalArgumentException

        // instantiate the object whose method you want to test, being careful
        // not to cause it to throw exceptions
        Rational r = new Rational(1, 2);

        // call the method being tested, using the input that should cause the
        // exception to be thrown
        r.setDenominator(inputD);

        // put NO statements after the statement expected to throw the exception
    }

}
