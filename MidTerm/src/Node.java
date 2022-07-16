public class Node<E> {
    protected E val;
    protected Node next;

    public Node(E val, Node next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.val.toString();
    }

}
