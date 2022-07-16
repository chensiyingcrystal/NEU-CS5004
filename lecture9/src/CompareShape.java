import java.util.Comparator;

public class CompareShape implements Comparator<Shape> {

    @Override
    public int compare(Shape s1, Shape s2) {
        Area a1 = s1.getArea();
        Area a2 = s2.getArea();
        return a1.compareTo(a2);
    }
}
