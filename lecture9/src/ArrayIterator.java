import java.util.Iterator;

public class ArrayIterator implements Iterator<Integer> {
    private int[] a;
    private int index;

    public ArrayIterator(int[] a) {
        this.a = a;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index != a.length;
    }

    @Override
    public Integer next() {
        int res = a[index];
        index++;
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,6,8,1};
        // Building an iterator on the array `a`.
        Iterator<Integer> it = new ArrayIterator(a);
        // Using the iterator `it` to iterate over the array
        // `a`.
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
