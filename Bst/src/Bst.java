
/**
 * This class is a binary search tree implementation. It includes various
 * methods to create binary search trees
 * 
 * @author Wade
 * @version 20161119
 *
 */
public class Bst implements BstADT {
    private Node root;
    private String numMoves = "";
    private String preorderSTR = "<";
    private Bst leftsub;
    private Bst rightsub;

    /**
     * Node class that assists with the implementation of the binary search
     * 
     * @author Wade
     *
     */
    private class Node {
        private Object value;
        private Node rkid;
        private Node lkid;

        /**
         * Creates a new node
         * 
         * @param value
         *            new node
         * @param lkid
         *            left kid of node
         * @param rkid
         *            right kid of node
         */

        private Node(Comparable<Object> value, Node lkid, Node rkid) {
            this.value = value;
            this.rkid = rkid;
            this.lkid = lkid;
        }

        /**
         * Basic constructor
         */
        private Node() {
            value = null;
            rkid = null;
            lkid = null;
        }

        /**
         * Returns the value of the root
         * 
         * @return The value of the root
         */
        private Object getValue() {
            return this.value;
        }

        /**
         * Sets the value of the root
         * 
         * @param v
         *            The specified value
         */
        private void setValue(Object v) {
            this.value = v;
        }

        /**
         * Returns the value of the left kid
         * 
         * @return the value in the left kid
         */
        private Node left() {
            return this.lkid;
        }

        /**
         * Sets the value of the left kid
         * 
         * @param lkid1
         *            The value to be set
         */
        private void setLeft(Node lkid1) {
            this.lkid = lkid1;
        }

        /**
         * Returns the value in the right kid
         * 
         * @return The value in the right kid
         */
        private Node right() {
            return this.rkid;
        }

        /**
         * Sets the value of the right kid
         * 
         * @param rkid1
         *            The value to be set
         */
        private void setRight(Node rkid1) {
            this.rkid = rkid1;
        }
    }

    public Bst() {

    }

    public Bst(Node n) {
        Node no = n;
    }

    /**
     * Checks a binary search tree for a specified value
     * 
     * @param val
     *            The value to be found
     * @return True if the value if found; false otherwise
     */
    public boolean contains(Comparable val) {
        boolean n = find(val, root);
        return n;
    }

    /**
     * Helper method for contains
     * 
     * @param val
     *            The value to be found
     * @param n
     *            The node to look through
     * @return True if the value is found; false otherwise
     */
    private boolean find(Comparable<Object> val, Node n) {
        if (n == null) {
            return false;
        }
        else {
            int comp = val.compareTo(n.getValue());
            if (comp == 0) {
                return true;
            }
            else if (comp < 0) {
                return (find(val, n.left()));
            }
            else {
                return (find(val, n.right()));
            }
        }
    }

    /**
     * Insert a value in the BST
     * 
     * @param value
     *            The value to be inserted
     */
    public void insert(Comparable value) {
        root = insert(value, root);
    }

    /**
     * Helper method for insert
     * 
     * @param val
     *            The value to be inserted
     * @param n
     *            The node to look at
     * @return The new root
     */
    private Node insert(Comparable<Object> val, Node n) {
        if (n == null) {
            return new Node(val, null, null);
        }

        int comp = val.compareTo(n.getValue());

        if (comp < 0) {
            n.setLeft(insert(val, n.left()));
        }
        else if (comp > 0) {
            n.setRight(insert(val, n.right()));
        }
        return n;
    }

    /**
     * Checks if the bst is balanced
     * 
     * @return True if balanced; false otherwise
     */
    public boolean isBalanced() {
        return (isBalanced(root) != -1);
    }

    /**
     * ] Helper method for isBalanced
     * 
     * @param n
     *            The node to look at
     * @return True if balanced; false if otherwise
     */
    // this goes through each node
    private int isBalanced(Node n) {
        if (n == null) {
            return 0;
        }

        // height of children
        int left = isBalanced(n.left());
        int right = isBalanced(n.right());

        // diff in heights
        int diff = left - right;

        // if they are unbalanced
        if ((left == -1) || (right == -1)) {
            return -1;
        }
        // if they are unbalanced
        if ((diff > 1) || (diff < -1)) {
            return -1;
        }
        // if balanced, return max + 1
        else if (left > right) {
            return (left + 1);
        }
        else {
            return (right + 1);
        }
    }

    /**
     * Checks if bst is empty
     * 
     * @return True if empty; false otherwise
     */
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Retrieves the left subtree
     * 
     * @return The left subtree
     */
    public BstADT leftSubtree() {
        Node newRoot = root;
        return leftSubtree(newRoot.left());
    }

    /**
     * Helper method for leftSubtree
     * 
     * @param n
     *            The left node of the root
     * @return The left subtree
     */
    private Bst leftSubtree(Node n) {
        if (n != null) {
            leftsub.insert((Comparable) n.getValue());
            preorder(n.left());
            preorder(n.right());
        }
        return leftsub;
    }

    /**
     * Determines the moves that must be made to reach a specified value
     * 
     * @param val
     *            The value to be found
     * @return A string of directions
     */
    public String moves(Comparable val) {
        String n = move(val, root);
        return n;
    }

    /**
     * A helper method for moves
     * 
     * @param val
     *            The value to be found
     * @param n
     *            the node to look at
     * @return A string of directions
     */
    private String move(Comparable<Object> val, Node n) {
        if (n == null) {
            return "null";
        }
        else {
            int comp = val.compareTo(n.getValue());
            if (comp == 0) {
                return numMoves;
            }
            else if (comp < 0) {
                numMoves = numMoves + "L";
                return (move(val, n.left()));
            }
            else {
                numMoves = numMoves + "R";
                return (move(val, n.right()));
            }
        }
    }

    /**
     * Returns a string of all the values in the bst preordered
     * 
     * @return A string of all the values
     */
    public String preorder() {
        return preorder(root);
    }

    /**
     * A helper method for preorder
     * 
     * @param n
     *            The node to look at
     * @return A string of all the value
     */
    private String preorder(Node n) {
        if (n != null) {
            preorderSTR = preorderSTR + " " + n.getValue();
            preorder(n.left());
            preorder(n.right());
        }
        return preorderSTR + " >";
    }

    /**
     * Removes a specified value
     * 
     * @param val
     *            the value to be removed
     */
    public void remove(Comparable val) {
        root = delete(root, val);
    }

    /**
     * A helper method for the remove method
     * 
     * @param p
     *            The node to look at
     * @param toDelete
     *            The value to be removed
     * @return the new bst
     */
    private Node delete(Node p, Comparable<Object> toDelete) {
        int comp = toDelete.compareTo(p.value);
        if (comp < 0) {
            p.lkid = delete(p.left(), toDelete);
        }
        else if (comp > 0) {
            p.rkid = delete(p.right(), toDelete);
        }
        else {
            if (p.left() == null) {
                return p.right();
            }
            else if (p.right() == null) {
                return p.left();
            }
            else {
                // get data from the rightmost node in the left subtree
                p.value = retrieveData(p.left());
                // delete the rightmost node in the left subtree
                // p.lkid = delete(p.left(), p.value) ;
            }
        }
        return p;
    }

    /**
     * A helper method for the delete method
     * 
     * @param p
     *            The node to look at
     * @return The data in the right kid
     */
    private Object retrieveData(Node p) {
        while (p.rkid != null) {
            p = p.rkid;
        }
        return p.value;
    }

    /**
     * Returns the right subtree
     * 
     * @return The right subtree
     */
    public BstADT rightSubtree() {
        Node newRoot = root;
        return rightSubtree(root);
    }

    /**
     * A helper method for the rightSubtree method
     * 
     * @param n
     *            The node to look at
     * @return The right subtree
     */
    private Bst rightSubtree(Node n) {
        Bst r = new Bst(root.right());
        return r;
    }

    /**
     * Returns the value of the root
     * 
     * @return The value of the root
     */
    public Comparable valOfRoot() throws IllegalStateException {
        Comparable<Object> e = (Comparable) root.getValue();
        if (e == null) {
            throw new IllegalStateException();
        }
        return e;
    }
}
