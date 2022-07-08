package bignumber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BigNumberImplTest {
    BigNumberImpl n1;

    @Before
    public void setup() {
        Digit head = new Digit(6);
        head.next = new Digit(8);
        n1 = new BigNumberImpl(head);
    }

    @Test
    public void testLength() {
        assertEquals(2, n1.length());
    }


    @Test
    public void testLength2() {
        BigNumberImpl n2 = new BigNumberImpl();
        assertEquals(1, n2.length());
    }

    //test if head's value is 0 and shift is 0(expected: 0)
    @Test
    public void testShiftLeft1() {
        BigNumberImpl n3 = new BigNumberImpl();
        BigNumberImpl expected = (BigNumberImpl) n3.shiftLeft(0);
        Digit d1 = new Digit(0);
        BigNumberImpl actual = new BigNumberImpl(d1);
        assertEquals(expected, actual);
    }

    //test if head's value is 0 and shift is larger than 0(expected: 0)
    @Test
    public void testShiftLeft2() {
        BigNumberImpl n3 = new BigNumberImpl();
        BigNumberImpl expected = (BigNumberImpl) n3.shiftLeft(5);
        Digit d1 = new Digit(0);
        BigNumberImpl actual = new BigNumberImpl(d1);
        assertEquals(expected, actual);
    }

    //test if head's value is 0 and shift is less than 0(expected: 0)
    @Test
    public void testShiftLeft3() {
        BigNumberImpl n3 = new BigNumberImpl();
        BigNumberImpl expected = (BigNumberImpl) n3.shiftLeft(-5);
        Digit d1 = new Digit(0);
        BigNumberImpl actual = new BigNumberImpl(d1);
        assertEquals(expected, actual);
    }

    //test if head's value is not 0 and shift is 0(expected: this)
    @Test
    public void testShiftLeft4() {
        BigNumberImpl expected = (BigNumberImpl) n1.shiftLeft(0);
        Digit d1 = new Digit(6);
        d1.next = new Digit(8);
        BigNumberImpl actual = new BigNumberImpl(d1);
        assertEquals(expected, actual);
    }

    //test if head's value is not 0 and shift larger than 0
    @Test
    public void testShiftLeft5() {
        BigNumberImpl expected = (BigNumberImpl) n1.shiftLeft(1);
        Digit d1 = new Digit(6);
        d1.next = new Digit(8);
        d1.next.next = new Digit(0);
        BigNumberImpl actual = new BigNumberImpl(d1);
        assertEquals(expected, actual);
    }

    //test if head's value is not 0 and shift less than 0
    @Test
    public void testShiftLeft6() {
        BigNumberImpl expected = (BigNumberImpl) n1.shiftLeft(-1);
        Digit d1 = new Digit(6);
        BigNumberImpl actual = new BigNumberImpl(d1);
        assertEquals(expected, actual);
    }

    //test shift is 0
    @Test(expected = IllegalArgumentException.class)
    public void testShiftRight1() {
        BigNumberImpl expected = (BigNumberImpl) n1.shiftRight(0);
    }

    //test shift length exceeds limit while head is not 0
    @Test(expected = IllegalArgumentException.class)
    public void testShiftRight2() {
        BigNumberImpl expected = (BigNumberImpl) n1.shiftRight(6);
    }

    //test shift length exceeds limit while head is 0
    @Test
    public void testShiftRight3() {
        BigNumberImpl n4 = new BigNumberImpl();
        BigNumberImpl expected = (BigNumberImpl) n4.shiftRight(6);
        BigNumberImpl actual = new BigNumberImpl();
        assertEquals(expected, actual);
    }

    //test shift less than 0 while head is 0
    @Test
    public void testShiftRight4() {
        BigNumberImpl n4 = new BigNumberImpl();
        BigNumberImpl expected = (BigNumberImpl) n4.shiftRight(-6);
        BigNumberImpl actual = new BigNumberImpl();
        assertEquals(expected, actual);
    }

    //test shift equals to number's length while head is not 0
    @Test
    public void testShiftRight5() {
        BigNumberImpl expected = (BigNumberImpl) n1.shiftRight(2);
        BigNumberImpl actual = new BigNumberImpl();
        assertEquals(expected, actual);
    }

    //test shift large than 0 while head is not 0
    @Test
    public void testShiftRight6() {
        BigNumberImpl expected = (BigNumberImpl) n1.shiftRight(1);
        Digit d1 = new Digit(6);
        BigNumberImpl actual = new BigNumberImpl(d1);
        assertEquals(expected, actual);
    }

    //test shift less than 0 while head is not 0
    @Test
    public void testShiftRight7() {
        BigNumberImpl expected = (BigNumberImpl) n1.shiftRight(-2);
        Digit d1 = new Digit(6);
        d1.next = new Digit(8);
        d1.next.next = new Digit(0);
        d1.next.next.next = new Digit(0);
        BigNumberImpl actual = new BigNumberImpl(d1);
        assertEquals(expected, actual);
    }

    //test
    @Test
    public void testAddDigit1() {
        BigNumberImpl expected = (BigNumberImpl) n1.addDigit(1);
        Digit d1 = new Digit(6);
        d1.next = new Digit(9);
        BigNumberImpl actual = new BigNumberImpl(d1);
        assertEquals(expected, actual);
    }

    //test
    @Test
    public void testAddDigit2() {
        BigNumberImpl expected = (BigNumberImpl) n1.addDigit(7);
        Digit d1 = new Digit(7);
        d1.next = new Digit(5);
        BigNumberImpl actual = new BigNumberImpl(d1);
        assertEquals(expected, actual);
    }

    //test
    @Test(expected = IllegalArgumentException.class)
    public void testAddDigit3() {
        BigNumberImpl expected = (BigNumberImpl) n1.addDigit(100);
    }

    //test
    @Test
    public void testAddDigit4() {
        Digit d1 = new Digit(1);
        d1.next = new Digit(9);
        d1.next.next = new Digit(9);
        d1.next.next.next = new Digit(9);
        BigNumberImpl n5 = new BigNumberImpl(d1);
        BigNumberImpl expected = (BigNumberImpl) n5.addDigit(1);
        Digit d2 = new Digit(2);
        d2.next = new Digit(0);
        d2.next.next = new Digit(0);
        d2.next.next.next = new Digit(0);
        BigNumberImpl n6 = new BigNumberImpl(d2);
        assertEquals(expected, n6);
    }

    //test
    @Test
    public void testAddDigit5() {
        Digit d1 = new Digit(9);
        d1.next = new Digit(9);
        d1.next.next = new Digit(9);
        BigNumberImpl n5 = new BigNumberImpl(d1);
        BigNumberImpl expected = (BigNumberImpl) n5.addDigit(8);
        Digit d2 = new Digit(1);
        d2.next = new Digit(0);
        d2.next.next = new Digit(0);
        d2.next.next.next = new Digit(7);
        BigNumberImpl n6 = new BigNumberImpl(d2);
        assertEquals(expected, n6);
    }

    //test
    @Test
    public void testAdd1() {
        Digit d1 = new Digit(1);
        d1.next = new Digit(2);
        BigNumberImpl n6 = new BigNumberImpl(d1);

        Digit d2 = new Digit(3);
        d2.next = new Digit(2);
        BigNumberImpl n8 = new BigNumberImpl(d2);
        BigNumberImpl expected = (BigNumberImpl) n6.add(n8);

        Digit d3 = new Digit(4);
        d3.next = new Digit(4);
        BigNumberImpl n9 = new BigNumberImpl(d3);
        assertEquals(expected, n9);
    }

    //test
    @Test
    public void testAdd2() {
        Digit d1 = new Digit(1);
        d1.next = new Digit(2);
        d1.next.next = new Digit(3);
        BigNumberImpl n6 = new BigNumberImpl(d1);

        Digit d2 = new Digit(3);
        d2.next = new Digit(2);
        BigNumberImpl n8 = new BigNumberImpl(d2);
        BigNumberImpl expected = (BigNumberImpl) n6.add(n8);

        Digit d3 = new Digit(1);
        d3.next = new Digit(5);
        d3.next.next = new Digit(5);
        BigNumberImpl n9 = new BigNumberImpl(d3);
        assertEquals(expected, n9);
    }

    //test
    @Test
    public void testAdd3() {
        Digit d1 = new Digit(2);
        BigNumberImpl n6 = new BigNumberImpl(d1);

        Digit d2 = new Digit(1);
        d2.next = new Digit(5);
        d2.next.next = new Digit(9);
        d2.next.next.next = new Digit(9);
        BigNumberImpl n8 = new BigNumberImpl(d2);
        BigNumberImpl expected = (BigNumberImpl) n6.add(n8);

        Digit d3 = new Digit(1);
        d3.next = new Digit(6);
        d3.next.next = new Digit(0);
        d3.next.next.next = new Digit(1);
        BigNumberImpl n9 = new BigNumberImpl(d3);
        assertEquals(expected, n9);
    }

    //test
    @Test
    public void testAdd4() {
        Digit d1 = new Digit(9);
        d1.next = new Digit(9);
        d1.next.next = new Digit(9);
        d1.next.next.next = new Digit(9);
        BigNumberImpl n6 = new BigNumberImpl(d1);

        Digit d2 = new Digit(8);
        d2.next = new Digit(9);
        d2.next.next = new Digit(7);
        d2.next.next.next = new Digit(9);
        BigNumberImpl n8 = new BigNumberImpl(d2);
        BigNumberImpl expected = (BigNumberImpl) n6.add(n8);

        Digit d3 = new Digit(1);
        d3.next = new Digit(8);
        d3.next.next = new Digit(9);
        d3.next.next.next = new Digit(7);
        d3.next.next.next.next = new Digit(8);
        BigNumberImpl n9 = new BigNumberImpl(d3);
        assertEquals(expected, n9);
    }

    //test
    @Test
    public void testAdd5() {
        BigNumberImpl n6 = new BigNumberImpl();
        BigNumberImpl n8 = new BigNumberImpl();
        BigNumberImpl expected = (BigNumberImpl) n6.add(n8);
        assertEquals(expected, new BigNumberImpl());
    }

    //test
    @Test
    public void testgetDigitAt1() {
        Digit d1 = new Digit(6);
        d1.next = new Digit(2);
        d1.next.next = new Digit(9);
        d1.next.next.next = new Digit(1);
        BigNumberImpl n6 = new BigNumberImpl(d1);

        assertEquals(n6.getDigitAt(1), 9);
    }

    //test
    @Test(expected = IllegalArgumentException.class)
    public void testgetDigitAt2() {
        Digit d1 = new Digit(6);
        d1.next = new Digit(2);
        d1.next.next = new Digit(9);
        d1.next.next.next = new Digit(1);
        BigNumberImpl n6 = new BigNumberImpl(d1);

        assertEquals(n6.getDigitAt(-5), 9);
    }

    //test
    @Test(expected = IllegalArgumentException.class)
    public void testgetDigitAt3() {
        Digit d1 = new Digit(6);
        d1.next = new Digit(2);
        d1.next.next = new Digit(9);
        d1.next.next.next = new Digit(1);
        BigNumberImpl n6 = new BigNumberImpl(d1);

        assertEquals(n6.getDigitAt(4), 4);
    }

    //test
    @Test
    public void testCopy() {
        Digit d1 = new Digit(6);
        d1.next = new Digit(2);
        d1.next.next = new Digit(9);
        d1.next.next.next = new Digit(1);
        BigNumberImpl n6 = new BigNumberImpl(d1);
        BigNumber expected = n6.copy();

        Digit d2 = new Digit(6);
        d2.next = new Digit(2);
        d2.next.next = new Digit(9);
        d2.next.next.next = new Digit(1);
        BigNumberImpl actual = new BigNumberImpl(d1);

        assertEquals(expected, actual);
    }

    //test
    @Test(expected = IllegalStateException.class)
    public void testCompareTo() {
        BigNumberImpl n6 = null;
        n1.compareTo(n6);
    }

    //test
    @Test
    public void testCompareTo2() {
        Digit d1 = new Digit(6);
        d1.next = new Digit(2);
        d1.next.next = new Digit(9);
        d1.next.next.next = new Digit(1);
        BigNumberImpl n6 = new BigNumberImpl(d1);

        Digit d2 = new Digit(3);
        d2.next = new Digit(2);
        d2.next.next = new Digit(4);
        d2.next.next.next = new Digit(5);
        BigNumberImpl n8 = new BigNumberImpl(d2);

        assertEquals(1, n6.compareTo(n8));
    }

    //test
    @Test
    public void testCompareTo3() {
        Digit d1 = new Digit(6);
        d1.next = new Digit(2);
        BigNumberImpl n6 = new BigNumberImpl(d1);

        Digit d2 = new Digit(3);
        d2.next = new Digit(2);
        d2.next.next = new Digit(4);
        d2.next.next.next = new Digit(5);
        BigNumberImpl n8 = new BigNumberImpl(d2);

        assertEquals(-1, n6.compareTo(n8));
    }

    //test
    @Test
    public void testToString() {
        Digit d2 = new Digit(3);
        d2.next = new Digit(2);
        d2.next.next = new Digit(4);
        d2.next.next.next = new Digit(5);
        BigNumberImpl n8 = new BigNumberImpl(d2);

        assertEquals("3245", n8.toString());
    }
}