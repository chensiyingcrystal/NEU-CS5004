package bignumber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BigNumberImplTest {
    BigNumberImpl n1;

    @Before
    public void setup() {
        n1 = new BigNumberImpl("68");
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
        Digit d1 = new Digit('0');
        BigNumberImpl actual = new BigNumberImpl(d1);
        assertEquals(expected, actual);
    }

    //test if head's value is 0 and shift is larger than 0(expected: 0)
    @Test
    public void testShiftLeft2() {
        BigNumberImpl n3 = new BigNumberImpl();
        BigNumberImpl expected = (BigNumberImpl) n3.shiftLeft(5);
        Digit d1 = new Digit('0');
        BigNumberImpl actual = new BigNumberImpl(d1);
        assertEquals(expected, actual);
    }

    //test if head's value is 0 and shift is less than 0(expected: 0)
    @Test
    public void testShiftLeft3() {
        BigNumberImpl n3 = new BigNumberImpl();
        BigNumberImpl expected = (BigNumberImpl) n3.shiftLeft(-5);
        Digit d1 = new Digit('0');
        BigNumberImpl actual = new BigNumberImpl(d1);
        assertEquals(expected, actual);
    }

    //test if head's value is not 0 and shift is 0(expected: this)
    @Test
    public void testShiftLeft4() {
        BigNumberImpl expected = (BigNumberImpl) n1.shiftLeft(0);
        BigNumberImpl actual = new BigNumberImpl("68");
        assertEquals(expected, actual);
    }

    //test if head's value is not 0 and shift larger than 0
    @Test
    public void testShiftLeft5() {
        BigNumberImpl expected = (BigNumberImpl) n1.shiftLeft(1);
        BigNumberImpl actual = new BigNumberImpl("680");
        assertEquals(expected, actual);
    }


    //test if head's value is not 0 and shift less than 0
    @Test
    public void testShiftLeft6() {
        BigNumberImpl n0 = new BigNumberImpl("30");
        BigNumberImpl expected = (BigNumberImpl) n0.shiftLeft(-2);
        BigNumberImpl actual = new BigNumberImpl("0");
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

    //test shift length exceeds limit while head is 0
    @Test
    public void testShiftRight0() {
        BigNumberImpl n4 = new BigNumberImpl("3");
        BigNumberImpl expected = (BigNumberImpl) n4.shiftRight(2);
        BigNumberImpl actual = new BigNumberImpl("0");
        assertEquals(expected, actual);
        System.out.println(expected.toString());
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
        BigNumberImpl actual = new BigNumberImpl("0");
        assertEquals(expected, actual);
    }

    //test shift large than 0 while head is not 0
    @Test
    public void testShiftRight6() {
        BigNumberImpl expected = (BigNumberImpl) n1.shiftRight(1);
        BigNumberImpl actual = new BigNumberImpl("6");
        assertEquals(expected, actual);
    }

    //test shift less than 0 while head is not 0
    @Test
    public void testShiftRight7() {
        BigNumberImpl expected = (BigNumberImpl) n1.shiftRight(-2);
        BigNumberImpl actual = new BigNumberImpl("6800");
        assertEquals(expected, actual);
    }

    //test
    @Test
    public void testAddDigit1() {
        BigNumberImpl expected = (BigNumberImpl) n1.addDigit(1);
        BigNumberImpl actual = new BigNumberImpl("69");
        assertEquals(expected, actual);
    }

    //test
    @Test
    public void testAddDigit2() {
        BigNumberImpl expected = (BigNumberImpl) n1.addDigit(7);
        BigNumberImpl actual = new BigNumberImpl("75");
        assertEquals(expected, actual);
    }

    //test
    @Test(expected = IllegalArgumentException.class)
    public void testAddDigit3() {
        BigNumberImpl expected = (BigNumberImpl) n1.addDigit('*');
    }

    //test
    @Test
    public void testAddDigit4() {
        BigNumberImpl n5 = new BigNumberImpl("1999");
        BigNumberImpl expected = (BigNumberImpl) n5.addDigit(1);
        BigNumberImpl n6 = new BigNumberImpl("2000");
        assertEquals(expected, n6);
    }

    //test
    @Test
    public void testAddDigit5() {
        BigNumberImpl n5 = new BigNumberImpl("999");
        BigNumberImpl expected = (BigNumberImpl) n5.addDigit(8);
        BigNumberImpl n6 = new BigNumberImpl("1007");
        assertEquals(expected, n6);
    }

    //test
    @Test
    public void testAdd1() {
        BigNumberImpl n6 = new BigNumberImpl("12");
        BigNumberImpl n8 = new BigNumberImpl("32");
        BigNumberImpl expected = (BigNumberImpl) n6.add(n8);

        BigNumberImpl n9 = new BigNumberImpl("44");
        assertEquals(expected, n9);
    }

    //test
    @Test
    public void testAdd2() {
        BigNumberImpl n6 = new BigNumberImpl("123");
        BigNumberImpl n8 = new BigNumberImpl("32");
        BigNumberImpl expected = (BigNumberImpl) n6.add(n8);
        BigNumberImpl n9 = new BigNumberImpl("155");
        assertEquals(expected, n9);
    }

    //test
    @Test
    public void testAdd3() {
        BigNumberImpl n6 = new BigNumberImpl("2");
        BigNumberImpl n8 = new BigNumberImpl("1599");
        BigNumberImpl expected = (BigNumberImpl) n6.add(n8);
        BigNumberImpl n9 = new BigNumberImpl("1601");
        assertEquals(expected, n9);
    }

    //test
    @Test
    public void testAdd4() {
        BigNumberImpl n6 = new BigNumberImpl("9999");
        BigNumberImpl n8 = new BigNumberImpl("8979");
        BigNumberImpl expected = (BigNumberImpl) n6.add(n8);
        BigNumberImpl n9 = new BigNumberImpl("18978");
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
        BigNumberImpl n6 = new BigNumberImpl("6291");
        assertEquals(n6.getDigitAt(1), '9');
    }

    //test
    @Test(expected = IllegalArgumentException.class)
    public void testgetDigitAt2() {
        BigNumberImpl n6 = new BigNumberImpl("6291");
        assertEquals(n6.getDigitAt(-5), '9');
    }

    //test
    @Test(expected = IllegalArgumentException.class)
    public void testgetDigitAt3() {
        BigNumberImpl n6 = new BigNumberImpl("6291");
        assertEquals(n6.getDigitAt(4), '4');
    }

    //test
    @Test
    public void testCopy() {
        BigNumberImpl n6 = new BigNumberImpl("6291");
        BigNumber expected = n6.copy();
        BigNumberImpl actual = new BigNumberImpl("6291");
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
        BigNumberImpl n6 = new BigNumberImpl("6291");
        BigNumberImpl n8 = new BigNumberImpl("3245");
        assertEquals(1, n6.compareTo(n8));
    }

    //test
    @Test
    public void testCompareTo3() {
        BigNumberImpl n6 = new BigNumberImpl("62");
        BigNumberImpl n8 = new BigNumberImpl("3245");
        assertEquals(-1, n6.compareTo(n8));
    }

    //test
    @Test
    public void testToString() {
        BigNumberImpl n8 = new BigNumberImpl("3245");
        assertEquals("3245", n8.toString());
    }
}