import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * The test class for the BstADT class
 * 
 * @author Wade
 * @version 20161119
 */
public class BstTest {
    /**
     * The test for the contains method
     */
    @Test
    public void testContains() {
        BstADT e = new Bst();
        Object o = 8;
        Comparable<Object> n = (Comparable<Object>) o;
        e.insert(n);
        Object z = 7;
        Comparable<Object> m = (Comparable<Object>) z;
        e.insert(m);
        assertEquals(true, e.contains(m));
    }

    /**
     * The test for the insert method
     */
    @Test
    public void testInsert() {
        BstADT e = new Bst();
        Object o = 8;
        Comparable<Object> n = (Comparable<Object>) o;
        e.insert(n);
        assertEquals(n, e.valOfRoot());
    }

    /**
     * The test for the isBalanced method
     */
    @Test
    public void testIsBalaced() {
        BstADT e = new Bst();
        Object o = 8;
        Comparable<Object> n = (Comparable<Object>) o;
        e.insert(n);
        Object z = 7;
        Comparable<Object> m = (Comparable<Object>) z;
        e.insert(m);
        Object y = 9;
        Comparable<Object> p = (Comparable<Object>) y;
        e.insert(p);
        assertEquals(true, e.isBalanced());

    }

    /**
     * The test for the isEmpty method
     */
    @Test
    public void testIsEmpty() {
        BstADT e = new Bst();
        assertEquals(true, e.isEmpty());
        Object o = 8;
        Comparable<Object> n = (Comparable<Object>) o;
        e.insert(n);
        assertEquals(false, e.isEmpty());
    }

    /**
     * The test for the leftSubtree method
     */
    @Test
    public void testLeftSubtree() {
        BstADT e = new Bst();
        Object o = 8;
        Comparable<Object> n = (Comparable<Object>) o;
        e.insert(n);
        Object z = 7;
        Comparable<Object> m = (Comparable<Object>) z;
        e.insert(m);
        e = e.leftSubtree();
        assertEquals(7, e.valOfRoot());
    }

    /**
     * The test for the moves method
     */
    @Test
    public void testMoves() {
        BstADT e = new Bst();
        Object o = 8;
        Comparable<Object> n = (Comparable<Object>) o;
        e.insert(n);
        Object z = 7;
        Comparable<Object> m = (Comparable<Object>) z;
        e.insert(m);
        assertEquals("L", e.moves(m));
    }

    /**
     * The test for the preorder method
     */
    @Test
    public void testPreorder() {
        BstADT e = new Bst();
        Object o = "a";
        Comparable<Object> n = (Comparable<Object>) o;
        e.insert(n);
        Object z = "b";
        Comparable<Object> m = (Comparable<Object>) z;
        e.insert(m);
        Object p = "c";
        Comparable<Object> l = (Comparable<Object>) p;
        e.insert(l);
        assertEquals("< a b c >", e.preorder());
    }

    /**
     * The test for the remove method
     */
    @Test
    public void testRemove() {
        BstADT a = new Bst();
        Object o = 8;
        Comparable<Object> n = (Comparable<Object>) o;
        a.insert(n);
        BstADT e = new Bst();
        e.insert(n);
        Object z = 7;
        Comparable<Object> m = (Comparable<Object>) z;
        e.insert(m);
        e.remove(m);
        assertEquals(a, e);
        e.remove(n);
        assertEquals(true, e.isEmpty());
    }

    /**
     * The test for the rightSubtree method
     */
    @Test
    public void testRightSubtree() {
        BstADT e = new Bst();
        Object o = 8;
        Comparable<Object> n = (Comparable<Object>) o;
        e.insert(n);
        Object z = 9;
        Comparable<Object> m = (Comparable<Object>) z;
        e.insert(m);
        e = e.rightSubtree();
        assertEquals(9, e.valOfRoot());
    }

    /**
     * The test for the valOfRoot method
     */
    @Test
    public void testValOfRoot() {
        BstADT e = new Bst();
        Object o = 8;
        Comparable<Object> n = (Comparable<Object>) o;
        e.insert(n);
        assertEquals(n, e.valOfRoot());
    }

}
