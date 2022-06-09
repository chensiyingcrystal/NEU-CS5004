import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {
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

    private Rectangle testRec;

    @Before
    public void setup() {
        testRec = new Rectangle(0, 0, 6, 8);
    }

    //Test overlap method when two rectangles do not overlap
    @Test
    public void testNotOverlappingCase(){
        asserEquals(false, testRec.overlap(new Rectangle(15, 9, 5, 2)));
    }


}