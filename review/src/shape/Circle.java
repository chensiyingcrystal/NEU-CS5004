package shape;

public class Circle extends Shape{
    int area;

    public Circle(int area) {
        this.area = area;

    }

    public Circle() {
        this(20);
    }

    public void println() {
        System.out.println("aaa");

    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other.getClass() != getClass()) return false;
        Circle other2 = (Circle)other;
        return other2.color == this.color;
    }


}
