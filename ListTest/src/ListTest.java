import java.util.LinkedList;

public class ListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.addFirst(2);
        list.remove(1);
        list.add(5);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
