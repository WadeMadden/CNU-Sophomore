/**
 * This class is the midterm for CPSC270 Fall semester. The class contains
 * methods to test the student's knowledge of recursion and linked lists.
 * 
 * @author Wade Madden 00912891
 * @version 20161004
 * @param <E>
 */
public class ReckitRalf<E> {
    // A private class to represent a Node in the linked list
    private class Node<T> {
        public final T value;
        public Node<T> next;

        /**
         * Creates a new node
         * 
         * @param value1
         *            new node
         * @param next1
         *            value after the new node
         */
        public Node(T value1, Node<T> next1) {
            value = value1;
            next = next1;
        }

        /**
         * Overridden toString method returns the value
         * 
         * @return value in the node
         */
        @Override
        public String toString() {
            return "" + value;
        }
    }

    // The start of the linked list
    private Node<Object> head;
    // The end of the linked list
    private Node<Object> tail;
    // Number of elements in the list
    private int size;
    // sets the current position at the beginning of the list
    private Node<Object> current = head;

    /**
     * Constructor creates empty list
     */
    public ReckitRalf() {
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
        // base case: factorial of 0 equals 1
        if (n == 0) {
            return 1;
        }

        // checks if parameter given is less than 0
        else if (n < 0) {
            throw new IllegalArgumentException();
        }

        // recursive case: multiplies number times the factorial of the number
        // that is one less
        else {
            return (n * factorial(n - 1));
        }
    }

    /**
     * Recursively determines the sum of a number from 0 to that number
     * 
     * @param n
     *            the specified number to be summed
     * @return the summed number
     */
    public static int sum(Integer n) {
        if (n == 0) {
            return 0;
        }
        else {
            return (n + sum(n - 1));
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * 
     * @return value in the current position
     */
    public String getValue() {
        if (current == null) {
            return "null";
        }
        return current.toString();
    }

    /**
     * Inserts the specified element to the current position in the list
     * 
     * @param o
     *            adds object o to the list
     */
    public void insert(Object o) {
        Node<Object> n = new Node<Object>(o, head);
        // If this is the first element in the list
        if (head == null) {
            head = n;
            current = head;
            head.next = tail;
        }
        else {
            head = n;
            current = head;
            current.next = head.next;
        }

        // update size
        size++;
    }

    /**
     * Moves the current position in the list over one
     */
    public void next() {
        if (current == tail) {
            current = null;
        }
        else {
            current = current.next;
        }
    }

}
