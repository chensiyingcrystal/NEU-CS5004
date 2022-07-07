public class MyListImpl implements MyList{
    private Node head;

    public MyListImpl(Node head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int size() {
        int counter = 0;
        Node traverse = head;
        while (head != null) {
            counter++;
            traverse = traverse.next;
        }
        return 0;
    }

    @Override
    public void add(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }

        Node traverse = head;

        while (traverse.next != null) {
            traverse = traverse.next;
        }

        traverse.next = new Node(val);

    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public MyList subList() {
        return null;
    }
}
