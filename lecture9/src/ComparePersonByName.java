import java.util.Comparator;

public class ComparePersonByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();
        return name1.compareTo(name2);
    }
}
