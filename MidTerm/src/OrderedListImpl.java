public class OrderedListImpl<E extends Comparable<E> > implements OrderedList<E>{
    private Node<E> head;

    public OrderedListImpl(Node<E> head) {
        this.head = head;
    }

    public OrderedListImpl() {
        this.head = null;
    }

    @Override
    public void add(E val) {
        if (head == null) {
            head = new Node<E>(val, null);
            return;
        }

        Node<E> dummy = new Node(val, head);
        Node<E> temp = head;
        Node<E> prev = dummy;

        while (temp != null && temp.val.compareTo(val) > 0) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = new Node(val, temp);
        head = dummy.next;

    }

    @Override
    public E get(int index) {
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException("Index out of boundary!");
        }

        int count = 0;
        Node<E> temp = head;

        while (count < index) {
            count++;
            temp = temp.next;
        }

        return temp.val;
    }

    @Override
    public int size() {
        int size = 0;
        Node<E> temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    @Override
    public String toString() {
        Node<E> temp = head;
        String s1 = "";

        while (temp != null) {
            s1 += temp.toString();
            s1 += temp.next == null? "" : " ";
            temp = temp.next;
        }
        return s1;
    }
}
