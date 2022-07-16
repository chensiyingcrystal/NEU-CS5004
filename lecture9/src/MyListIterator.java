import java.util.Iterator;

public class MyListIterator<T extends Comparable<T>>
        implements Iterator<T> {
    private MyListImpl<T> list;
    private int index;

    public MyListIterator(MyListImpl<T> list) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index != list.size();
    }

    @Override
    public T next() {
        T elm = list.get(index);
        index++;
        return elm;
    }
}
