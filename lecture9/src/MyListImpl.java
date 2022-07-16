import java.util.Iterator;

public class MyListImpl<E extends Comparable<E>> implements MyList<E> {
    // Just need the first node because we can
    // find all the following node by following the
    // `next` pointers
    private Node<E> head;

    public MyListImpl(Node<E> head) {
        this.head = head;
    }

    // Overloading constructor for an empty linked list
    public MyListImpl() {
        this.head = null;
    }

    // Common mistake: define "Node[] allHeads" to store
    // all the nodes


    @Override
    public Iterator<E> iterator() {
        return new MyListIterator<E>(this);
    }

    @Override
    public String toString() {
        String res = "";
        if (head == null) return res;

        Node<E> traversePtr = head;
        while(traversePtr.next != null) {
            res += traversePtr.toString() + " -> ";
            // hop to the next node
            traversePtr = traversePtr.next;
        }

        // when reaching here, traversePtr is pointing to the last node
        res += traversePtr.toString();
        return res;
    }

    @Override
    public int size() {
        // 1. init `counter` to 0
        // 2. start with `head`, follow the `next` pointers until
        // we reach the end of the list (indicated by null pointer)
        // 3. everytime we hop to the next node, inc `counter` by 1
        int counter = 0;
        Node<E> traversePtr = head;
//        for ( ; head.next != null; head = head.next) {
//            counter = counter+1;
//        }
        while(traversePtr != null) {
            // inc the counter
            counter++;
            // hop to the next node
            traversePtr = traversePtr.next;
        }

        return counter;
    }

    @Override
    public void add(E val) {
        // corner case
        if (head == null) {
            // empty linked list, make `head` point to the new node
            head = new Node(val, null);
            return;
        }

        Node<E> traversePtr = head;

        while(traversePtr.next != null) {
            // hop to the next node
            traversePtr = traversePtr.next;
        }

        // when reaching here, `traversePtr` should
        // be pointing to the last node

        // Common mistake:
        // traversePtr = new Node(val, null);

        // make the `next` pointer of the last node (`traversePtr`)
        // point to the new node
        traversePtr.next = new Node<E>(val, null);
    }

    @Override
    public E get(int index) {
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }

        int counter = 0;
        Node<E> traversePtr = head;

        while(counter < index) {
            // inc the counter
            counter++;
            // hop to the next node
            traversePtr = traversePtr.next;
        }

        // when reaching here, traversePtr is pointing to
        // the node at `index`

        return traversePtr.val;
    }

    @Override
    public void remove(int index) {
        if (index >= this.size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            // we're removing the first node
            // just make head point to the 2nd node
            // and JVM will GC/deletes the original head (1st node)
            head = head.next;
            return;
        }

        int counter = 0;
        Node<E> traversePtr = head;
        Node<E> prevPtr = null;

        while(counter < index) {
            // inc the counter
            counter++;

            prevPtr = traversePtr;
            // hop to the next node
            traversePtr = traversePtr.next;
        }

        // See https://docs.google.com/drawings/d/1yuUD0RG7iLPrSB9RasqOyL2G0Q95rFOoBqjx5FBMvQg/edit?usp=sharing
        // for the illustration

        // when reaching here, traversePtr is pointing to
        // the node at `index`, prevPtr is pointing to the
        // node right before the one at `index`
        Node<E> newNextNode = traversePtr.next;
        prevPtr.next = newNextNode;

        // or one-liner:
        //prevPtr.next = traversePtr.next;
    }

//    @Override
//    public MyList subList() {
//        MyList subList = new MyListImpl();
//        int len = this.size();
//        for (int i = 0; i < len; i++) {
//            int val = this.get(i);
//            if (val <= 4) {
//                subList.add(val);
//            }
//        }
//        return subList;
//    }

    // An alternative impl of subList, which does not use
    // any existing List method. Instead it uses the dummy
    // head technique
    @Override
    public MyList subList(E threshold) {
        Node<E> dummy = new Node<E>();
        Node<E> dummyTraversePtr = dummy;
        Node<E> traversePtr = head;

        while(traversePtr != null) {
            if (traversePtr.val.compareTo(threshold) <= 0) {
                Node newNode = new Node(traversePtr.val);
                dummyTraversePtr.next = newNode;
                dummyTraversePtr = dummyTraversePtr.next;
            }
            // hop to the next node
            traversePtr = traversePtr.next;
        }

        return new MyListImpl(dummy.next);
    }
}
