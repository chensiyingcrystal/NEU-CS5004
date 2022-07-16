import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1); // 1
        list.addFirst(2); // 2->1
        list.remove(1); // 2
        list.add(5); // 2 -> 5

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


        System.out.println("================");
        Node<Integer> node1 = new Node<>(1, null);
        Node<Integer> node7 = new Node<>(7, node1);
        Node<Integer> node3 = new Node<>(3, node7);
        Node<Integer> node5 = new Node<>(5, new Node(4, node3));
        System.out.println(node3.next.next.val);
        System.out.println("================");

        MyListImpl<Integer> mylist = new MyListImpl<>(node5);
        System.out.println(mylist.size());
        System.out.println(mylist.size());

        mylist.add(10);
        System.out.println(mylist.size());

        System.out.println("~~~~~~~~~~~");
        MyListImpl<Integer> mylist2 = new MyListImpl<>();
        mylist2.add(5);
        mylist2.add(4);
        mylist2.add(7);
        mylist2.add(3);
        mylist2.add(1);
        mylist2.add(10);
        System.out.println(mylist2.size());

        System.out.println(mylist2.toString());

        System.out.println("+++++++++++++");
        try {
            System.out.println(mylist2.get(mylist2.size()));
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("@@@@@@@@@@@@@");
        mylist2.remove(mylist2.size()-1);
        System.out.println(mylist2.toString());

        System.out.println("!!!!!!!!!!!");
        System.out.println(mylist2.subList(new Integer(3)));

        MyList<Integer> myIntegerList = new MyListImpl<>();
        MyList<Person> myPersonList = new MyListImpl<>();
        //List<Integer> myBuiltinList = new ArrayList<>();
    }
}
