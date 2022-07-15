package shape;

public class Shape {
    public int color;

    public Shape() {


        this.color = 53;


    }

    public void print() {
        System.out.println("ddd");
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other.getClass() != getClass()) return false;
        Shape other2 = (Shape)other;
        return other2.color == this.color;
    }
}
