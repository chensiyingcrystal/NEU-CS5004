package shape;

public class Test {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.println();
        Shape s1 = new Circle();
        System.out.println(c1.equals(s1));
        System.out.println(s1.equals(c1));


    }
}
