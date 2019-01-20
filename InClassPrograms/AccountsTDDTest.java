package InClassPrograms;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * AccountsTDDTest
 *
 * @author acsiochi
 * @version 20160829
 */
public class AccountsTDDTest {

    /**
     * Test method for {@link AccountsTDD#add(java.lang.String)}.
     */
    @Test
    public void doesFindReturnTrueForNameAddedToAccounts() {
        AccountsTDD a = new AccountsTDD();
        String name = "Joe";
        assertFalse(a.find(name)); // name shouldn't be in an empty accounts
        a.add(name);
        assertTrue(a.find(name));

    }

    /**
     * Test method for {@link AccountsTDD#find(java.lang.String)}.
     */
    @Test
    public void doesFindReturnTrueForNameInAccount() {
        AccountsTDD a = new AccountsTDD();
        String name = "Joe";
        assertFalse(a.find(name)); // name shouldn't be in an empty accounts
        a.add(name);
        assertTrue(a.find(name));
    }

    /**
     * Test method for {@link AccountsTDD#numOfName()}.
     */
    @Test
    public void doesNumOfNamesReturnNwhenNnamesWereAddedToEmptyAccounts() {
        AccountsTDD a = new AccountsTDD();
        assertEquals(0, a.numOfName());
        String[] names = { "Joe", "Jose", "John", "Juan", "Tiago" };
        for (String n : names) {
            a.add(n);
        }
        assertEquals(names.length, a.numOfName());
    }

    /**
     * Test method for {@link AccountsTDD#remove(java.lang.String)}.
     */
    @Test
    public void doesFindReturnFalseForDeletedName() {
        AccountsTDD a = new AccountsTDD();
        assertEquals(0, a.numOfName());
        String[] names = { "Joe", "Jose", "John", "Juan", "Tiago" };
        for (String n : names) {
            a.add(n);
        }
        // remove a name
        int gone = 2;
        a.remove(names[gone]);
        
        // check it's not there
        assertFalse(a.find(names[gone]));
        
        // confirm the rest are still there
        for (int i = 0; i < names.length; i++) {
            if (i != gone) {
                assertTrue(a.find(names[i]));
            }
        }
        
    }

    /**
     * Test method for {@link AccountsTDD#willFit(int)}.
     */
    @Test
    public void doesWillFitReturnTrueIfSizeAtLeastNumCharsAndFalseIfLess() {
        AccountsTDD a = new AccountsTDD();
        assertEquals(0, a.numOfName());
        String[] names = { "Joe", "Jose", "John", "Juan", "Tiago" };
        int numChars = 0;
        for (String n : names) {
            a.add(n);
            numChars += n.length() + 1; // for delimiter
        }
        assertFalse(a.willFit(numChars - 1)); // 1 less
        assertTrue(a.willFit(numChars)); // boundary value
        assertTrue(a.willFit(numChars + 1)); // 1 more
    }

}
