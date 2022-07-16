public class Area implements Comparable<Area>{
    private int val;

    public Area(int area) {
        this.val = area;
    }

    @Override
    public int compareTo(Area other) {
        if (other.getClass() != this.getClass()) {
            throw new IllegalArgumentException("Invalid object");
        }

        if (this.val > other.val) {
            return 1;
        }
        else if (this.val < other.val) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
