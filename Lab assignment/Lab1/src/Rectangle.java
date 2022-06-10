public class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    Rectangle() {

    }

    Rectangle(int x, int y, int w, int h) {
        if (w <= 0 || h <= 0) {
            throw new IllegalArgumentException("width or height of the rectangle must be positive integer!");
        }

        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }

    public boolean overlap(Rectangle other) {
        return !(this.x >= other.x + other.width) && !(this.x + this.width <= other.x)
                && !(this.y >= other.y + other.height) && !(this.y + this.height <= other.y);
    }

    public Rectangle intersect(Rectangle other) {
        if (!this.overlap(other)) {
            throw new java.util.NoSuchElementException("The two rectangles have no intersection!");
        }

        Rectangle intersection = new Rectangle();
        intersection.x = Math.max(this.x, other.x);
        intersection.y = Math.max(this.y, other.y);
        intersection.width = Math.min(this.x + this.width, other.x + other.width) - intersection.x;
        intersection.height = Math.min(this.y + this.height, other.y + other.height) - intersection.y;
        return intersection;
    }

    public Rectangle union(Rectangle other) {
        Rectangle union = new Rectangle();
        union.x = Math.min(this.x, other.x);
        union.y = Math.min(this.y, other.y);
        union.width = Math.max(this.x + this.width, other.x + other.width) - union.x;
        union.height = Math.max(this.y + this.height, other.y + other.height) - union.y;
        return union;

    }

    @Override
    public String toString() {
        return String.format("x: %d, y: %d, w: %d, h: %d", this.x, this.y, this.width, this.height);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (other.getClass() != Rectangle.class) return false;

        Rectangle otherRec = (Rectangle) other;
        return (this.x == otherRec.x) && (this.y == otherRec.y)
                && (this.width == otherRec.width) && (this.height == otherRec.height);
    }
}
