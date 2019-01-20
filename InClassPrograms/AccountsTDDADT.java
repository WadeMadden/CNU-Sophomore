package InClassPrograms;
/**
 * AccountsTDDADT is used to demonstrate the TDD process.
 *
 * @author acsiochi
 * @version 20160829
 */
public interface AccountsTDDADT {
    
    /**
     * Add the given name to the accounts.
     * 
     * @param name to be added.
     */
    public void add(String name);
    
    /**
     * Determine whether the given name is in the accounts or not.
     * 
     * @param name to search for
     * @return true if name is in the accounts, false else
     */
    public boolean find(String name);
    
    /**
     * Determine the number of names in the accounts.
     * 
     * @return number of names
     */
    public int numOfName();
    
    /**
     * Remove the given name from the accounts.
     * 
     * @param name to be removed
     */
    public void remove(String name);
    
    /**
     * Determine if all the names in the accounts will fit in a file of
     * the given size.
     * 
     * @param size of file
     * @return true if names will fit, false else
     */
    public boolean willFit(int size);

}
