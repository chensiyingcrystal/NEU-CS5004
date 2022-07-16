import java.util.Iterator;

public class MyStringIterator implements Iterator<Character> {
    private String s;
    private int index;

    public MyStringIterator(MyString ms) {
        this.s = ms.getInternalString();
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index != s.length();
    }

    @Override
    public Character next() {
        char c = s.charAt(index);
        index++;
        return c;
    }
}
