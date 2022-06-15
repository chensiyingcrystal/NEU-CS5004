/**
 * This program test the rectangle program with multiple test cases.
 *
 * @author Siying Chen
 */
package rectangle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RectangleTest {
    private Rectangle testRec;

    /**
     * set up the test rectangle with its attributes each time before a test is implemented.
     */
    @Before
    public void setup() {
        testRec = new Rectangle(0, 0, 6, 8);
    }

    /**
     * 1.1 Test constructor
     * Test expected exception thrown when creating an invalid rectangle with negative width.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testExpectedExceptionOfInvalidWidth() {
        Rectangle invalidRec1 = new Rectangle(0, -1, -5, 5);
    }

    /**
     * 1.2 Test constructor
     * Test expected exception thrown when creating an invalid rectangle with negative height.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testExpectedExceptionOfInvalidHeight() {
        Rectangle invalidRec2 = new Rectangle(0, -1, 8, -2);
    }

    /**
     * 2.1 Test overlap method when two rectangles do not overlap.
     * Case1: target rectangle is on the right side of the test rectangle.
     */
    @Test
    public void testNonOverlappingCase1() {
        assertEquals(false, testRec.overlap(new Rectangle(9, 6, 2, 4)));
    }

    /**
     * 2.2 Test overlap method when two rectangles do not overlap
     * Case2: target rectangle is on the left side of the test rectangle
     */
    @Test
    public void testNonOverlappingCase2() {
        assertEquals(false, testRec.overlap(new Rectangle(-8, 3, 1, 5)));
    }

    /**
     * 2.3 Test overlap method when two rectangles do not overlap.
     * Case3: target rectangle is on the top of the test rectangle
     */
    @Test
    public void testNonOverlappingCase3() {
        assertEquals(false, testRec.overlap(new Rectangle(5, 15, 6, 2)));
    }

    /**
     * 2.4 Test overlap method when two rectangles do not overlap.
     * Case4: target rectangle is at the bottom of the test rectangle.
     */
    @Test
    public void testNonOverlappingCase4() {
        assertEquals(false, testRec.overlap(new Rectangle(5, -8, 3, 4)));
    }

    /**
     * 2.5 Edge case: Test Overlap method when two rectangles touch each other.
     * Case1: two rectangles touches against the right side
     */
    @Test
    public void testTouchingAgainstRightSide() {
        assertEquals(false, testRec.overlap(new Rectangle(6, 4, 12, 14)));
    }

    /**
     * 2.6 Edge case: Test Overlap method when two rectangles touch each other.
     * Case2: two rectangles touches against the left side.
     */
    @Test
    public void testTouchingAgainstLeftSide() {
        assertEquals(false, testRec.overlap(new Rectangle(-6, -4, 6, 16)));
    }

    /**
     * 2.7 Edge case: Test Overlap method when two rectangles touch each other.
     * Case3: two rectangles touches against the top side.
     */
    @Test
    public void testTouchingAgainstTopSide() {
        assertEquals(false, testRec.overlap(new Rectangle(5, 8, 9, 3)));
    }

    /**
     * 2.8 Edge case: Test Overlap method when two rectangles touch each other.
     * Case4: two rectangles touches against the bottom side.
     */
    @Test
    public void testTouchingAgainstBottomSide() {
        assertEquals(false, testRec.overlap(new Rectangle(-5, -8, 19, 8)));
    }

    /**
     * 2.9 Test Overlap method in the case of overlapping.
     * Case1: test rectangle overlap a small corner of the target rectangle.
     */
    @Test
    public void testOverlapOfCorner() {
        assertEquals(true, testRec.overlap(new Rectangle(4, 3, 9, 11)));
    }

    /**
     * 2.10 Test Overlap method in the case of overlapping.
     * Case2: test rectangle overlap part of the target rectangle's width and cover all its height.
     */
    @Test
    public void testOverlapPartOfWidth() {
        assertEquals(true, testRec.overlap(new Rectangle(5, 2, 9, 4)));
    }

    /**
     * 2.11 Test Overlap method in the case of overlapping.
     * Case3: test rectangle overlap part of the target rectangle's height and cover all its width.
     */
    @Test
    public void testOverlapPartOfHeight() {
        assertEquals(true, testRec.overlap(new Rectangle(2, 6, 2, 14)));
    }

    /**
     * 2.12 Test Overlap method in the case of inclusion.
     * Case1: test rectangle fully cover target rectangle's area.
     */
    @Test
    public void testOverlapInclusion1() {
        assertEquals(true, testRec.overlap(new Rectangle(2, 2, 3, 4)));
    }

    /**
     * 2.13 Test Overlap method in the case of inclusion.
     * Case2: target rectangle fully cover test rectangle's area
     */
    @Test
    public void testOverlapInclusion2() {
        assertEquals(true, testRec.overlap(new Rectangle(-6, -12, 18, 50)));
    }

    /**
     * 3.1 Test intersect method when two rectangles do not overlap.
     */
    @Test(expected = java.util.NoSuchElementException.class)
    public void testExpectedExceptionOfNonOverlappingCase() {
        testRec.intersect(new Rectangle(9, 15, 2, 4));
    }

    /**
     * 3.2 Test Intersect method in the case of overlapping
     * Case1: the test rectangle overlap a small corner of the target rectangle
     */
    @Test
    public void testIntersectUnderCornerOverlap() {
        Rectangle expectedRec = new Rectangle(4, 3, 2, 5);
        assertEquals(expectedRec, testRec.intersect(new Rectangle(4, 3, 9, 11)));
    }

    /**
     * 3.3 Test Intersect method in the case of overlapping.
     * Case2: test rectangle overlap part of the target rectangle's width and cover all its height
     */
    @Test
    public void testIntersectUnderOverlappingPartOfWidth() {
        Rectangle expectedRec = new Rectangle(5, 2, 1, 4);
        assertEquals(expectedRec, testRec.intersect(new Rectangle(5, 2, 9, 4)));
    }

    /**
     * 3.4 Test Intersect method in the case of overlapping.
     * Case3: test rectangle overlap part of the target rectangle's height and cover all its width.
     */
    @Test
    public void testIntersectUnderOverlappingPartOfHeight() {
        Rectangle expectedRec = new Rectangle(2, 6, 2, 2);
        assertEquals(expectedRec, testRec.intersect(new Rectangle(2, 6, 2, 14)));
    }

    /**
     * 3.5 Test Intersect method in the case of inclusion.
     * Case1: test rectangle fully cover the target rectangle's area.
     */
    @Test
    public void testIntersectUnderInclusion1() {
        Rectangle expectedRec = new Rectangle(2, 2, 3, 4);
        assertEquals(expectedRec, testRec.intersect(new Rectangle(2, 2, 3, 4)));
    }

    /**
     * 3.6 Test Intersect method in the case of inclusion.
     * Case2: target rectangle fully cover test rectangle's area.
     */
    @Test
    public void testIntersectUnderInclusion2() {
        Rectangle expectedRec = new Rectangle(0, 0, 6, 8);
        assertEquals(expectedRec, testRec.intersect(new Rectangle(-6, -12, 18, 50)));
    }

    /**
     * 4.1 Test Union method in the case of non-overlapping.
     */
    @Test
    public void testUnionUnderNonOverlapping() {
        Rectangle expectedRec = new Rectangle(-8, -2, 14, 10);
        assertEquals(expectedRec, testRec.union(new Rectangle(-8, -2, 6, 9)));
    }

    /**
     * 4.2 Test Union method in the case of overlapping.
     */
    @Test
    public void testUnionUnderOverlapping() {
        Rectangle expectedRec = new Rectangle(0, -4, 14, 12);
        assertEquals(expectedRec, testRec.union(new Rectangle(2, -4, 12, 8)));
    }

    /**
     * 4.3 Test Union method in the case of inclusion.
     */
    @Test
    public void testUnionUnderInclusion() {
        Rectangle expectedRec = new Rectangle(-5, -13, 22, 30);
        assertEquals(expectedRec, testRec.union(new Rectangle(-5, -13, 22, 30)));
    }

    /**
     * 5.1 Test String method
     */
    @Test
    public void testString() {
        assertEquals("x: 0, y: 0, w: 6, h: 8", testRec.toString());
    }

}