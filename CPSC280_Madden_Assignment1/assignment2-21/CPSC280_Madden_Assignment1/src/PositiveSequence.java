import java.util.NoSuchElementException;

/**
 * This program takes in a series of four numbers. One of these numbers is a
 * negative one. The program then uses pattern recognition to determine what the
 * value of the negative one should be according to the other three numbers.
 * 
 * @author Wade Madden
 *
 */
public class PositiveSequence {
    /**
     * Checks that all numbers except the negative one are positive
     * 
     * @param numarray
     *            An array made up of the numbers given
     * @return true if there are multiple non positive numbers. False otherwise
     */
    private static boolean allNumbersAreNotPositive(int[] numarray) {
        // loop that checks that all numbers except the -1 are positive
        for (int i = 0; i < 4; i++) {
            int num = numarray[i];
            if (num < -1 || num == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks to make sure there are not multiple negative ones.
     * 
     * @param foearray
     *            An array made up of the numbers passed
     * @return True if there are multiple negative ones. False otherwise.
     */
    private static boolean checkForMultipleNegOnes(int[] foearray) {
        // find the first -1 in the array and sets to 0
        for (int i = 0; i < 4; i++) {
            if (foearray[i] == -1) {
                foearray[i] = 0;
                break;
            }
        }
        // uses the previous array to check if there is another -1 in the array
        // if there exists multiple -1s throws exception
        for (int i = 0; i < 4; i++) {
            if (foearray[i] == -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks that there is at least one negative one.
     * 
     * @param a
     *            The first integer.
     * @param b
     *            The second integer.
     * @param c
     *            The third integer.
     * @param d
     *            The fourth integer.
     * @return True if none of the numbers are a negative one. False otherwise.
     */
    // Checks that there is at least 1 -1 value
    private static boolean checkIfThereIsMoreThanOneNegOne(int a, int b, int c,
            int d) {
        if (a != -1 && b != -1 && c != -1 && d != -1) {
            return true;
        }
        return false;
    }

    /**
     * Checks that the numbers are sorted in ascending order.
     * 
     * @param numarray
     *            An array of the numbers passed.
     * @return Returns true if the array is not sorted in ascending order. False
     *         otherwise.
     */
    private static boolean checkIfNumbersAreUnsorted(int[] numarray) {
        int[] sortingArray = new int[3];
        int j = 0;
        // Sets up array to check if sorted
        for (int i = 0; i < 4; i++) {
            if (numarray[i] != -1) {
                sortingArray[j] = numarray[i];
                j++;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                if (sortingArray[i] >= sortingArray[i + 1]) {
                    return true;
                }
            }
            else if (i != 0) {
                if (sortingArray[i] <= sortingArray[i - 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks the series of numbers and returns the correct value for the
     * series. Also checks for errors and throws exceptions if any are found.
     * 
     * @param a
     *            The first integer.
     * @param b
     *            The second integer.
     * @param c
     *            The third integer.
     * @param d
     *            The fourth integer.
     * @return The correct value for the series.
     */
    public static int process(int a, int b, int c, int d) {
        int[] numarray = { a, b, c, d };
        int[] foearray = { a, b, c, d };
        int[] analyzearray = { a, b, c, d };
        int[] multarray = { a, b, c, d };
        if (allNumbersAreNotPositive(numarray)) {
            throw new IllegalArgumentException();
        }
        if (checkForMultipleNegOnes(foearray)) {
            throw new IllegalArgumentException();
        }
        if (checkIfThereIsMoreThanOneNegOne(a, b, c, d)) {
            throw new NoSuchElementException();
        }
        if (checkIfNumbersAreUnsorted(numarray)) {
            throw new IllegalArgumentException();
        }
        // returns the value if the -1 is in the first position and the
        // remaining numbers increase by addition
        for (int i = 0; i < 4; i++) {
            int o = 0;
            if (analyzearray[i] == -1 && i == 0) {
                int diff = analyzearray[3] - analyzearray[2];
                analyzearray[i] = analyzearray[1] - diff;
                for (int j = 0; j < 3; j++) {
                    if (analyzearray[j + 1] - analyzearray[j] != diff) {
                        o = 1;
                        break;
                    }
                }
                if (o == 1) {
                    break;
                }
                if (analyzearray[0] <= 0) {
                    return -1;
                }
                return analyzearray[0];
            }
        }
        // returns the value if the -1 is in the second position and the
        // remaining numbers increase by addition
        for (int i = 0; i < 4; i++) {
            int o = 0;
            if (analyzearray[i] == -1 && i == 1) {
                int diff = analyzearray[3] - analyzearray[2];
                analyzearray[i] = analyzearray[2] - diff;
                for (int j = 0; j < 3; j++) {
                    if (analyzearray[j + 1] - analyzearray[j] != diff) {
                        o = 1;
                        break;
                    }
                }
                if (o == 1) {
                    break;
                }
                return analyzearray[1];
            }
        }
        // returns the value if the -1 is in the third position and the
        // remaining numbers increase by addition
        for (int i = 0; i < 4; i++) {
            int o = 0;
            if (analyzearray[i] == -1 && i == 2) {
                int diff = analyzearray[1] - analyzearray[0];
                analyzearray[i] = analyzearray[3] - diff;
                for (int j = 0; j < 3; j++) {
                    if (analyzearray[j + 1] - analyzearray[j] != diff) {
                        o = 1;
                        break;
                    }
                }
                if (o == 1) {
                    break;
                }
                return analyzearray[2];
            }
        }
        // returns the value if the -1 is in the fourth position and the
        // remaining numbers increase by addition
        for (int i = 0; i < 4; i++) {
            int o = 0;
            if (analyzearray[i] == -1 && i == 3) {
                int diff = analyzearray[1] - analyzearray[0];
                analyzearray[i] = analyzearray[2] + diff;
                for (int j = 0; j < 3; j++) {
                    if (analyzearray[j + 1] - analyzearray[j] != diff) {
                        o = 1;
                        break;
                    }
                }
                if (o == 1) {
                    break;
                }
                return analyzearray[3];
            }
        }
        // returns the value if the -1 is in the first position and the
        // remaining numbers increase by multiplication
        for (int i = 0; i < 4; i++) {
            int o = 0;
            if (multarray[i] == -1 && i == 0) {
                int div = multarray[3] / multarray[2];
                multarray[i] = multarray[1] / div;
                for (int j = 0; j < 3; j++) {
                    if (multarray[j] * div != multarray[j + 1]) {
                        o = 1;
                        break;
                    }
                }
                if (o == 1) {
                    break;
                }
                if (multarray[0] <= 0) {
                    return -1;
                }
                return multarray[0];
            }
        }
        // returns the value if the -1 is in the second position and the
        // remaining numbers increase by multiplication
        for (int i = 0; i < 4; i++) {
            int o = 0;
            if (multarray[i] == -1 && i == 1) {
                int div = multarray[3] / multarray[2];
                multarray[i] = multarray[2] / div;
                for (int j = 0; j < 3; j++) {
                    if (multarray[j] * div != multarray[j + 1]) {
                        o = 1;
                        break;
                    }
                }
                if (o == 1) {
                    break;
                }
                if (multarray[0] <= 0) {
                    return -1;
                }
                return multarray[1];
            }
        }
        // returns the value if the -1 is in the third position and the
        // remaining numbers increase by multiplication
        for (int i = 0; i < 4; i++) {
            int o = 0;
            if (multarray[i] == -1 && i == 2) {
                int div = multarray[1] / multarray[0];
                multarray[i] = multarray[3] / div;
                for (int j = 0; j < 3; j++) {
                    if (multarray[j] * div != multarray[j + 1]) {
                        o = 1;
                        break;
                    }
                }
                if (o == 1) {
                    break;
                }
                if (multarray[0] <= 0) {
                    return -1;
                }
                return multarray[2];
            }
        }
        // returns the value if the -1 is in the fourth position and the
        // remaining numbers increase by multiplication
        for (int i = 0; i < 4; i++) {
            int o = 0;
            if (multarray[i] == -1 && i == 3) {
                int div = multarray[1] / multarray[0];
                multarray[i] = multarray[2] * div;
                for (int j = 0; j < 3; j++) {
                    if (multarray[j] * div != multarray[j + 1]) {
                        o = 1;
                        break;
                    }
                }
                if (o == 1) {
                    break;
                }
                if (multarray[0] <= 0) {
                    return -1;
                }
                return multarray[3];
            }
        }
        return -1;
    }
}