import java.util.NoSuchElementException;

/**
 * 
 * This program finds missing value and returns the value in the squence that
 * should belong
 * 
 * @author Troy Potvin
 * @version 1.0
 *
 */
public class PositiveSequence {

    public static int process(int a, int b, int c, int d) throws IllegalArgumentException {

        int[] array = { a, b, c, d };
        int retNum = 0;
        
        checkzero(array);
        checksorted(array);
        checknegative(array);
        
        checkarguments(array);
        
        

        retNum = checkcheckarithmetic(array);
        if (retNum == -1) {
            System.out.println("didnt find ari");
            retNum = checkcheckgeometric(array);
        }
        
        return retNum;

    }

    private static void checknegative(int[] array)
            throws IllegalArgumentException {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 && array[i] != -1) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void checkarguments(int[] array)
            throws IllegalArgumentException, NoSuchElementException {
        int e = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                e++;
            }

        }

        if (e == 0) {
            throw new NoSuchElementException();
        }
        if (e > 1) {
            throw new IllegalArgumentException();
        }
    }

    private static void checksorted(int[] array)
            throws IllegalArgumentException {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i+1]==-1) {
                
            } else {
            
            if (array[i] < array[i + 1]) {
                
            }

            else {
                throw new IllegalArgumentException();
            }
            }
        }
    }

    private static int checkarithmetic(int[] array) {

        int a = 0;
        int b = 0;

        a = array[3] - array[2];
        if (array[3] - array[2] == a && array[2] - array[1] == a) {
            array[0] = array[1] - a;
            b = array[0];
            if (b == 0) {
                return -1;
            }
            else if (b < 0) {
                return -1;
            }
            return b;
        }
        else {
            return -1;
        }
    }

    private static int checkarithmetic1(int[] array) {
        int a = 0;
        int b = 0;
        a = array[3] - array[2];
        if (array[2] - (2 * a) == array[0]) {
            array[1] = array[2] - a;
            b = array[1];
            if (b == 0) {
                return -1;
            }
            else if (b < 0) {
                return -1;
            }
            return b;
        }
        else {
            return -1;
        }
    }

    private static int checkarithmetic2(int[] array) {
        int a = 0;
        int b = 0;
        a = array[1] - array[0];
        if (array[1] + (2 * a) == array[3]) {
            array[2] = a + array[1];
            b = array[2];
            if (b == 0) {
                return -1;
            }
            else if (b < 0) {
                return -1;
            }
            return b;
        }
        else {
            return -1;
        }
    }

    private static int checkarithmetic3(int[] array) {
        int a = 0;
        int b = 0;
        a = array[2] - array[1];
        if (array[1] - array[0] == a) {
            array[3] = array[2] + a;
            b = array[3];
            if (b == 0) {
                return -1;
            }
            else if (b < 0) {
                return -1;
            }
            return b;
        }
        else {
            return -1;

        }

    }

    private static int checkcheckarithmetic(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                index = i;
            }
        }

        if (index == 0) {
            return checkarithmetic(array);
        }
        if (index == 1) {
            return checkarithmetic1(array);
        }
        if (index == 2) {
            return checkarithmetic2(array);
        }
        else {
            return checkarithmetic3(array);
        }
    }

    private static int checkcheckgeometric(int[] array) {

        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                index = i;
            }
        }

        if (index == 0) {
            return checkgeometric(array);
        }
        if (index == 1) {
            return checkgeometric1(array);
        }
        if (index == 2) {
            return checkgeometric2(array);
        }
        else {
            return checkgeometric3(array);
        }
    }

    private static int checkgeometric(int[] array) {

        int a = 0;
        int b = 0;

        a = array[3] / array[2];
        if (array[3] % array[2] != 0) {
            return -1;
        }

        if (array[2] / array[1] == a) {
            array[0] = array[1] / a;
            if (array[1]%a!=0) {
                return -1;
            }
            b = array[0];
            System.out.println(b);
        }
        return b;
    }

    private static void checkzero (int[] array) throws IllegalArgumentException {
        for (int i : array) {
            if (i==0) {
                throw new IllegalArgumentException();
            }
        }
    }
    
    private static int checkgeometric1(int[] array) {

        int a = 0;
        int b = 0;

        a = array[3] / array[2];
        if (array[3] % array[2] != 0) {
            return -1;
        }
        if (array[2] / (2 * a) == array[0]) {
            array[1] = array[2] / a;
            System.out.println(b);
            b = array[1];
        } else {
            return -1;
        }
        if (b == 0) {
            return -1;
        }
        return b;
    }

    private static int checkgeometric2(int[] array) {

        int a = 0;
        int b = 0;

        a = array[1] / array[0];
        if (array[1] % array[0] != 0) {
            return -1;
        }

        if ((2 * a) * array[1] == array[3]) {
            array[2] = array[3] / a;
            b = array[2];
        }
if (b==0){
    return -1;
}
        return b;

    }

    private static int checkgeometric3(int[] array) {

        int a = 0;
        int b = 0;

        a = array[2] / array[1];
        if (array[2] % array[1] != 0) {
            return -1;

        }

        if (array[0] * a == array[1]) {
            array[3] = array[2] * a;
            b = array[3];
            System.out.println(b);
        }
        if (b==0){
            return -1;
        }
        return b;

    }

}
