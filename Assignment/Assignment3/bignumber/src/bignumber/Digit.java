package bignumber;

public class Digit {
    protected int val;
    protected Digit next;

    public Digit(int val) {
        if (val < 0 || val > 9) {
            throw new IllegalArgumentException("value is invalid");
        }
        this.val = val;
        this.next = null;
    }

    public Digit(int val, Digit next) {
        this.val = val;
        this.next = next;
    }
}
