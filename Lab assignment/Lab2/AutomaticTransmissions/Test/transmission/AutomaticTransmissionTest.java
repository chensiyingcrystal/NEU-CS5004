package transmission;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the automatic transmission class
 */
public class AutomaticTransmissionTest {
    private Transmission tt1;

    /**
     * instantiate an automatic transmission object each time before tests
     */
    @Before
    public void setup() {
        tt1 = new AutomaticTransmission(10, 20, 30, 40, 50);
    }

    /**
     * Test constructor with valid input
     */
    @Test
    public void testIfValidSpeedThresholds() {
        tt1 = new AutomaticTransmission(15, 25, 35, 45, 55);
    }

    /**
     * Test constructor with negative value of speed
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIfInValidSpeedThresholds() {
        tt1 = new AutomaticTransmission(-5, 20, 40, 60, 80);
    }

    /**
     * Test constructor with wrong order of arguments
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIfInvalidSpeedOrder() {
        tt1 = new AutomaticTransmission(10, 20, 15, 40, 60);
    }

    /**
     * Test increaseSpeed method
     */
    @Test
    public void testIncreaseSpeed() {
        for (int i = 0; i < 10; i++) {
            tt1.increaseSpeed();
        }
        assertEquals(tt1.getSpeed(), 20);
        assertEquals(tt1.getGear(), 2);
    }

    /**
     * Test decreaseSpeed method with invalid speed
     */
    @Test(expected = IllegalStateException.class)
    public void testDecreaseSpeed() {
        tt1.decreaseSpeed();
    }

    /**
     * Test decreaseSpeed method
     */
    @Test
    public void testDecreaseSpeed2() {
        for (int i = 0; i < 10; i++) {
            tt1.increaseSpeed();
        }
        assertEquals(tt1.getSpeed(), 20);
        for (int i = 0; i < 5; i++) {
            tt1.decreaseSpeed();
        }
        assertEquals(tt1.getSpeed(), 10);
        assertEquals(tt1.getGear(), 1);
    }

    @Test
    public void testToString() {
        assertEquals("Transmission (speed = 0, gear = 0)", tt1.toString());
    }


}