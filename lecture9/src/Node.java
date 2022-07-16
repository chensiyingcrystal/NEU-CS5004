public class Node<T> {
    protected T val;
    // pointer to the next node
    protected Node next;

    public Node(T val, Node next) {
        this.val = val;
        this.next = next;
    }

    // Create the last node
    public Node(T val) {
        this.val = val;
        this.next = null;
    }

    // create a dummy node with dummy value
    public Node() {
        this.next = null;
    }

    @Override
    public String toString() {
        return this.val.toString();
    }
}
