package bignumber;

public interface BigNumber {
    public int length();
    public BigNumber shiftLeft(int shifts);
    public BigNumber shiftRight(int shifts);
    public BigNumber addDigit(int digit);
    public int getDigitAt(int position);
    public BigNumber copy();
    public BigNumber add(BigNumber other);
    public int compareTo(BigNumber other);
}
