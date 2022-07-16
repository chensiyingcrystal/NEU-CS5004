
import java.util.*;

public class Rectangle extends Shape{
    private int length;
    private int width;

    public Rectangle(int l, int w) {
        this.length = l;
        this.width = w;

    }

    @Override
    public Area getArea() {
        int area = length * width;
        return new Area(area);
    }



    public static void main(String[] args) {
        Shape r1 = new Rectangle(2, 3);
        System.out.println(r1.getArea());
        Shape c1 = new Circle(2);
        System.out.println(c1.getArea());

        List<Shape> l1 = new ArrayList<Shape>(Arrays.asList(r1, c1));
        CompareShape cx = new CompareShape();
        Collections.sort(l1, cx);

        for (int i = 0; i < l1.size(); i++) {
            System.out.println(l1.get(i));
        }



    }
}
