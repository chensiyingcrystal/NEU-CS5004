

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * A JUnit test class for the Book class.
 */
public class BookTest {

    private Book headfirstJava;

    Person Crystal = new Person("Siying", "Chen", 1993);
    @Before
    public void setUp() {

        headfirstJava = new Book("headfirstJava", Crystal, (float) 66.68);
    }

    @Test
    public void testFirst() {
        assertEquals("headfirstJava", headfirstJava.getTitle());

    }

    @Test
    public void testSecond() {
        assertEquals((float)66.68, headfirstJava.getPrice());
    }

    @Test
    public void testThird() {
        assertEquals(Crystal, headfirstJava.getAuthor());

    }

}
