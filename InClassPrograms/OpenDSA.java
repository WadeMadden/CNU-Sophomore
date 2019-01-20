package InClassPrograms;

public class OpenDSA {
    private Node N;
    private Node head;
    private Node curr;

    public void clear() {
        head = null;
        head.next = null;
        curr = null;
    }

    public void next() {
        curr = curr.next;
    }

    public boolean insert(Object it) {
        N = new Node(it);
        N.next = curr.next;
        curr.next = N;
        curr = head;
        while (curr.next.value != null) {
            if (it.equals(getValue())) {
                return true;
            }
        }
        return false;
    }

    public Object getValue() {
        return curr.value;
    }
}
