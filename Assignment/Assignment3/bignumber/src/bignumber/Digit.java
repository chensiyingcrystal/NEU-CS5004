package bignumber;

public class Digit {
    protected char val;
    protected Digit next;

    public Digit(char val) {
        if (!Character.isDigit(val) || val < '0' || val > '9') {
            throw new IllegalArgumentException("value is invalid");
        }
        this.val = val;
        this.next = null;
    }

    public Digit(char val, Digit next) {
        this.val = val;
        this.next = next;
    }
}
