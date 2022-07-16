import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Tom", 322));
        list.add(new Person("Jack", 320));
        list.add(new Person("Abby", 327));
        list.add(new Person("Susan", 323));
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new ComparePersonByName());
        System.out.println(list);

        List<Integer> intList = new ArrayList<>();
        intList.add(new Integer(2));
        intList.add(new Integer(7));
        intList.add(new Integer(1));
        intList.add(new Integer(3));
        Collections.sort(intList);
        System.out.println(intList);
    }
}
