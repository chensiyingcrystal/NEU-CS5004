import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RectangleTest {
    private Rectangle testRec;

    @Before
    public void setup() {
        testRec = new Rectangle(0, 0, 6, 8);
    }

    //Test expected exception thrown when creating an invalid rectangle with negative width
    @Test(expected = IllegalArgumentException.class)
    public void testExpectedExceptionOfInvalidWidth() {
        Rectangle invalidRec1 = new Rectangle(0, -1, -5, 5);
    }

    //Test expected exception thrown when creating an invalid rectangle with negative height
    @Test(expected = IllegalArgumentException.class)
    public void testExpectedExceptionOfInvalidHeight() {
        Rectangle invalidRec2 = new Rectangle(0, -1, 8, -2);
    }

    //Test overlap method when two rectangles do not overlap
    //Case1: target rectangle is on the right side of the test rectangle
    @Test
    public void testNonOverlappingCase1() {
        assertEquals(false, testRec.overlap(new Rectangle(9, 6, 2, 4)));
    }

    //Test overlap method when two rectangles do not overlap
    //Case2: target rectangle is on the left side of the test rectangle
    @Test
    public void testNonOverlappingCase2() {
        assertEquals(false, testRec.overlap(new Rectangle(-8, 3, 1, 5)));
    }

    //Test overlap method when two rectangles do not overlap
    //Case3: target rectangle is on the top of the test rectangle
    @Test
    public void testNonOverlappingCase3() {
        assertEquals(false, testRec.overlap(new Rectangle(5, 15, 6, 2)));
    }

    //Test overlap method when two rectangles do not overlap
    //Case4: target rectangle is at the bottom of the test rectangle
    @Test
    public void testNonOverlappingCase4() {
        assertEquals(false, testRec.overlap(new Rectangle(5, -8, 3, 4)));
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testExpectedExceptionOfNonOverlappingCase() {
        testRec.intersect(new Rectangle(9, 15, 2, 4));
    }


}