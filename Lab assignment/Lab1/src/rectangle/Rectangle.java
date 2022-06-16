/**
 * <h1>Rectangle</h1>
 * This program creates the rectangle object, determines if two rectangles overlap with each
 * other and calculate their intersection and union area.
 *
 * @author Siying Chen
 */

package rectangle;

public class Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Class constructor specifying its attributes.
     * Create a rectangle object with its lower_left corner(x, y), width and its height.
     * The width and height must be positive integers.
     *
     * @param x The x-coordinate of the lower_left point of the rectangle
     * @param y The y-coordinate of the lower_left point of the rectangle
     * @param w The rectangle's width
     * @param h The rectangle's height
     */
    public Rectangle(int x, int y, int w, int h) {

        if (w <= 0) {
            throw new IllegalArgumentException("Width of the rectangle must be positive integer!");
        }

        if (h <= 0) {
            throw new IllegalArgumentException("Height of the rectangle must be positive integer!");
        }
           this.x = x;
           this.y = y;
           this.width = w;
           this.height = h;

    }

    /**
     * Determine if two rectangles overlap with each other.
     * When they touch together, this does not count as overlapping.
     *
     * @param other the rectangle that needs to be determined whether it overlap this rectangle.
     * @return true if two rectangles overlap while false if they don't.
     */
    public boolean overlap(Rectangle other) {
        return !(this.x >= other.x + other.width) && !(this.x + this.width <= other.x)
                && !(this.y >= other.y + other.height) && !(this.y + this.height <= other.y);
    }

    /**
     * Return the intersection area that represents the overlap of the two rectangles.
     * If they don't overlap, the method would throw a NoSuchElementException with a helpful message.
     *
     * @param other the rectangle that may or may not intersect with this rectangle.
     * @return rectangle object that represents the overlap of the two rectangles if intersection exists.
     */
    public Rectangle intersect(Rectangle other) {
        if (!this.overlap(other)) {
            throw new java.util.NoSuchElementException("The two rectangles have no intersection!");
        }

        int intersectionX = Math.max(this.x, other.x);
        int intersectionY = Math.max(this.y, other.y);
        int intersectionWidth = Math.min(this.x + this.width, other.x + other.width) - intersectionX;
        int intersectionHeight = Math.min(this.y + this.height, other.y + other.height) - intersectionY;
        return new Rectangle(intersectionX, intersectionY, intersectionWidth, intersectionHeight);
    }

    /**
     * Return the union area that represents the union of the two rectangles.
     * The union is the smallest rectangle that contains both rectangles.
     * Note that unlike the intersection, the union always exists.
     *
     * @param other the rectangle object with which this rectangle unites.
     * @return rectangle object that represents the union of the two rectangles.
     */
    public Rectangle union(Rectangle other) {
        int unionX = Math.min(this.x, other.x);
        int unionY = Math.min(this.y, other.y);
        int unionWidth = Math.max(this.x + this.width, other.x + other.width) - unionX;
        int unionHeight = Math.max(this.y + this.height, other.y + other.height) - unionY;
        return new Rectangle(unionX, unionY, unionWidth, unionHeight);
    }

    /**
     * An override method of toString method.
     * @return the string formatted with the rectangle's left-corner coordinates, width and height.
     */
    @Override
    public String toString() {
        return String.format("x: %d, y: %d, w: %d, h: %d", this.x, this.y, this.width, this.height);
    }

    /**
     * An override method of equals method for testing.
     * Compare two rectangles' attributes and if they all match, return true.
     *
     * @param other the rectangle object that need to be compared with this object.
     * @return true if two objects' attributes match with each other and false if any of them do not match.
     */

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
