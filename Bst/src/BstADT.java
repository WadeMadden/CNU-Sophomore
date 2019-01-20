
/**
 * BstADT interface file for student use.
 * 
 * @author acsiochi
 * @version 20161107
 */
@SuppressWarnings("rawtypes")
public interface BstADT {
    /**
     * Checks a binary search tree for a specified value
     * 
     * @param val
     *            The value to be found
     * @return True if the value if found; false otherwise
     */
    public boolean contains(Comparable val);

    /**
     * Insert a value in the BST
     * 
     * @param value
     *            The value to be inserted
     */
    public void insert(Comparable value);

    /**
     * Returns a string of all the values in the bst preordered
     * 
     * @return A string of all the values
     */
    public String preorder();

    /**
     * Checks if the bst is balanced
     * 
     * @return True if balanced; false otherwise
     */
    public boolean isBalanced();

    /**
     * Determines the moves that must be made to reach a specified value
     * 
     * @param val
     *            The value to be found
     * @return A string of directions
     */
    public String moves(Comparable val);

    /**
     * Removes a specified value
     * 
     * @param val
     *            the value to be removed
     */

    public void remove(Comparable val);

    /**
     * Retrieves the left subtree
     * 
     * @return The left subtree
     */
    public BstADT leftSubtree();

    /**
     * Returns the right subtree
     * 
     * @return The right subtree
     */

    public BstADT rightSubtree();

    /**
     * Returns the value of the root
     * 
     * @return The value of the root
     */
    public Comparable valOfRoot() throws IllegalStateException;

    /**
     * Checks if bst is empty
     * 
     * @return True if empty; false otherwise
     */
    public boolean isEmpty();
}
