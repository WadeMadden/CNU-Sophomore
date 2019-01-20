/**
 * The Recursion class contains four methods which utilize recursion in their
 * implementations.
 * 
 * This class tests ones knowledge of recursion implementation.
 * 
 * @author Wade Madden - 00912891
 * @version 20160924
 */

public class Recursion {
    /**
     * This class does not allow for instantiation. If instantiation is
     * attempted, constructor will throw an UnsupportedOperationException.
     * 
     * @throws UnsupportedOperationException
     */
    public Recursion() {
        throw new UnsupportedOperationException();
    }

    /**
     * If the given String is a valid factor, method evaluates it and returns
     * the value. If not, throws an IllegalArgumentException.
     * 
     * @param s
     *            : the factor to be evaluated
     * @return the value of the give factor
     * @throws IllegalArgumentException
     */
    public static int factor(String s) {
        int num;

        // removes excess spaces in the String if any exist
        s = s.replace(" ", "");

        // String that holds the integers of the String
        String newS = "";

        // loop which makes sure that only single digits are used
        // also checks for unacceptable characters - not '+'
        // throws IllegalArgumentException if conditional is satisfied
        for (int i = 0; i < s.length(); i++) {
            if ((i % 2 != 0) && (s.charAt(i) != '+')) {
                throw new IllegalArgumentException();
            }
        }

        // passes all single digits into new String
        for (int i = 0; i < s.length(); i += 2) {
            newS += s.charAt(i);
        }

        // checks that string is not empty
        // throws IllegalArgumentExceptionOtherwise
        if (newS.length() == 0) {
            throw new IllegalArgumentException();
        }

        // base case tries to parse a single digit and returns integer
        // if successful. Otherwise throws IllegalArgumentException
        if (newS.length() == 1) {
            try {
                num = Integer.parseInt(newS);
            }
            catch (Exception e) {
                throw new IllegalArgumentException();
            }
            return num;
        }

        // recursive case. Used when length of string is greater than one. Tries
        // to parse the number at the end of the string. Returns this number
        // plus the rest of the string which is recursively passed back into the
        // method
        else {

            try {
                num = Integer.parseInt(
                        Character.toString(newS.charAt(newS.length() - 1)));
            }
            catch (Exception e) {
                throw new IllegalArgumentException();
            }
            return (num + factor(s.substring(0, s.length() - 2)));
        }
    }

    /**
     * Recursively determines the factorial of a given integer
     * 
     * @param n
     *            : factorial of this number is calculated
     * @return : the calculated factorial
     * @throws IllegalArgumentException
     */
    public static int factorial(Integer n) {
        // base case - factorial of 0 equals 1
        if (n == 0) {
            return 1;
        }

        // checks if parameter given is less than 0
        else if (n < 0) {
            throw new IllegalArgumentException();
        }

        // recursive case - multiplies number times the factorial of the number
        // that is one less
        else {
            return (n * factorial(n - 1));
        }
    }

    /**
     * Determines if the given string is an identifier. An identifier is a
     * sequence of digits and/or letters that starts with a letter.
     * 
     * @param s
     *            : determine if this string is an identifier
     * @return : true if it is an identifier; false otherwise
     */
    public static boolean isIdentifier(String s) {
        // returns false if the string contains no value
        if (s.length() == 0) {
            return false;
        }

        // assigns c the value at the end of the string
        char c = s.charAt(s.length() - 1);

        // base case - if string has length of one, returns true if char is a
        // letter. False otherwise
        if (s.length() == 1) {
            return Character.isLetter(c);
        }

        // checks if the char is a character is a letter or digit. If true
        // returns the string minus the character on the end. Otherwise returns
        // false
        else {
            if (Character.isDigit(c) || Character.isLetter(c)) {
                return isIdentifier(s.substring(0, s.length() - 1));
            }
        }
        return false;
    }

    /**
     * Recursively determine if the given string is a palindrome. A palindrome
     * is a string that reads the same forwards and backwards.
     * 
     * @param s
     *            : determine if this string is a palindrome
     * @return :true if palindrome, false if else
     */
    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        // base case - a string with length of one or zero is a palindrome
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        // makes string lower case in case up capitalized letters
        s = s.toLowerCase();

        // recursive case checks if characters at beginning and end of string
        // are equal. If true returns string minus beginning and end characters.
        // Else returns false
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
        return false;
    }
}
