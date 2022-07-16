public class Circle extends Shape{
    private int radius;
    private final double PI = 3.14;

    public Circle(int r) {
        this.radius = r;
    }




    @Override
    public Area getArea() {
        return new Area((int)PI * radius * radius);
    }

}
