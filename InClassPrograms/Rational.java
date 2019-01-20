package InClassPrograms;

/**
 * Rational represents a rational number. Rational numbers have a numerator and
 * a denominator that can't be zero. This class supports testing for equality
 * and for multiplying.
 * 
 * This is a simple class whose purpose is to illustrate how to write JUnit
 * tests.
 *
 * @author acsiochi
 * @version 20160921
 */
public class Rational {

    private int numerator;
    private int denominator;

    /**
     * Instantiate a Rational using the given parameters. Passing in zero for
     * the denominator parameter will cause an IllegalArgumentException.
     * 
     * @param n
     *            the desired numerator
     * @param d
     *            the desired denominator
     */
    public Rational(int n, int d) {
        this.numerator = n;
        this.denominator = d;
    }

    /**
     * Set the denominator of this Rational to the given value. Zero is not a
     * valid value to use for the parameter.
     * 
     * @param d
     *            set denominator to this
     * @throws IllegalArgumentException
     */
    public void setDenominator(int d) throws IllegalArgumentException {
        if (d == 0) {
            throw new IllegalArgumentException("denominator can't be 0");
        }
        this.denominator = d;
    }

    /**
     * Determine the numerator.
     * 
     * @return the numerator of this Rational
     */
    public int numerator() {
        return this.numerator;
    }

    /**
     * Determine the denominator.
     * 
     * @return the denominator of this Rational
     */
    public int denominator() {
        return this.denominator;
    }

    /**
     * Determine if the given Rational number is equal to this one. Rational
     * numbers are equal if their numerators are equal and their denominators
     * are equals. No attempt is made to reduce the Rationals.
     * 
     * @param o
     *            the Rational number to check for equality
     * @return true if the parameter is equal to this Rational number
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rational)) {
            return false;
        }
        Rational r = (Rational) o;
        return r.numerator == this.numerator
                && r.denominator == this.denominator;
    }

    /**
     * Determine the product of this Rational number with the given Rational.
     * 
     * @param r
     *            the given Rational number
     * @return the product
     */
    public Rational multiplyBy(Rational r) {
        int nProduct = this.numerator * r.denominator; // intentional error
        int dProduct = this.denominator * r.denominator;
        return new Rational(nProduct, dProduct);
    }

}
