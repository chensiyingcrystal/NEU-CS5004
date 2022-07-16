import java.util.Iterator;

public class MyString implements Iterable<Character> {
    private String internalString;

    public MyString(String s) {
        this.internalString = s;
    }

    @Override
    public Iterator<Character> iterator() {
        return new MyStringIterator(this);
    }

    String getInternalString() {
        return this.internalString;
    }

    public static void main(String[] args) {
        MyString ms = new MyString("hello");
        Iterator<Character> it = ms.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
