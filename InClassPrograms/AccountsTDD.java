package InClassPrograms;
import java.util.ArrayList;

/**
 * AccountsTDD implements the AccountsTDD.
 *
 * @author acsiochi
 * @version 20160829
 */
public class AccountsTDD implements AccountsTDDADT {
    
    private ArrayList<String> names;
    
    public AccountsTDD() {
        names = new ArrayList<String>();
    }

    /* (non-Javadoc)
     * @see AccountsTDDADT#add(java.lang.String)
     */
    @Override
    public void add(String name) {
        // TODO Auto-generated method stub
        this.names.add(name);
    }

    /* (non-Javadoc)
     * @see AccountsTDDADT#find(java.lang.String)
     */
    @Override
    public boolean find(String name) {
        // TODO Auto-generated method stub
        return this.names.contains(name);
    }

    /* (non-Javadoc)
     * @see AccountsTDDADT#numOfName()
     */
    @Override
    public int numOfName() {
        // TODO Auto-generated method stub
        return this.names.size();
    }

    /* (non-Javadoc)
     * @see AccountsTDDADT#remove(java.lang.String)
     */
    @Override
    public void remove(String name) {
        // TODO Auto-generated method stub
        this.names.remove(name);
    }

    /* (non-Javadoc)
     * @see AccountsTDDADT#willFit(int)
     */
    @Override
    public boolean willFit(int size) {
        // TODO Auto-generated method stub
        int numChars = 0;
        for (String s: this.names) {
            numChars += s.length() + 1; // 1 char for delimiter
        }        
        return size >= numChars;
    }

}
