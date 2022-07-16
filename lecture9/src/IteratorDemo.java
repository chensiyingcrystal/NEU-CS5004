import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        //List<Person> people = new ArrayList<>();
        // I decide to optimize my code by replacing linked list
        // with a tree
        //HashSet<Person> people = new HashSet<>();
        MyList<Person> people = new MyListImpl<>();
        people.add(new Person("Tom", 322));
        people.add(new Person("Jack", 320));
        people.add(new Person("Abby", 327));
        people.add(new Person("Susan", 323));
//        for (int i = 0; i < people.size(); i++) {
//            System.out.println(people.get(i));
//        }
        Iterator<Person> it = people.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
