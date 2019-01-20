package InClassPrograms;

public interface List {
	/**
	 * Make a list of random items.
	 * @param item to be added to list.
	 * @author Wade
	 */
	public static void add(String item){};
	
	/**
	 * Finds a specific item
	 * @param name of item to be found
	 * @return String of the name of the item
	 */
	public static void find(String name){};
	/**
	 * Removes specific item from list
	 * @param name of item to be removed
	 */
	public static void remove(String name){};
}
