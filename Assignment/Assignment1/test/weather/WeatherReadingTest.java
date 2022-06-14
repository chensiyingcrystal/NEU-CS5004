/**
 * This program test the WeatherReading program with multiple test cases.
 *
 * @author Siying Chen
 */
package weather;

import org.junit.Test;

import static org.junit.Assert.*;

public class WeatherReadingTest {
    private WeatherReading weatherTest;

    /**
     * Test the constructor in the case of greater value of dew Point than the temperature
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException1() {
        weatherTest = new WeatherReading(25, 39, 8, 20);
    }

    /**
     * Test the constructor in the case of negative wind speed
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException2() {
        weatherTest = new WeatherReading(15, 9, -3, 10);
    }

    /**
     * Test the constructor in the case of negative total rain
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorException3() {
        weatherTest = new WeatherReading(30, 24, 5, -17);
    }

    /**
     * Test getTemperature method
     */
    @Test
    public void testGetTemperature() {
        weatherTest = new WeatherReading(25, 16, 8, 18);
        assertEquals(25, weatherTest.getTemperature());
    }

    /**
     * Test getDewPoint method
     */
    @Test
    public void testGetDewPoint() {
        weatherTest = new WeatherReading(25, 16, 8, 18);
        assertEquals(16, weatherTest.getDewPoint());
    }

    /**
     * Test getWindSpeed method
     */
    @Test
    public void testGetWindSpeed() {
        weatherTest = new WeatherReading(25, 16, 8, 18);
        assertEquals(8, weatherTest.getWindSpeed());
    }

    /**
     * Test getTotalRain method
     */
    @Test
    public void testGetTotalRain() {
        weatherTest = new WeatherReading(25, 16, 8, 18);
        assertEquals(18, weatherTest.getTotalRain());
    }

    /**
     * Test getRelativeHumidity method
     */
    @Test
    public void testGetRelativeHumidity() {
        weatherTest = new WeatherReading(25, 16, 8, 18);
        assertEquals(55, weatherTest.getRelativeHumidity());
    }

    /**
     * Test getRelativeHumidity in the case of the difference between t and d is greater than 20
     */
    @Test(expected = RuntimeException.class)
    public void testGetRelativeHumidityRuntimeException() {
        weatherTest = new WeatherReading(35, 10, 7, 12);
        int reHumid = weatherTest.getRelativeHumidity();
    }

    /**
     * Test getHeatIndex method
     */
    @Test
    public void testGetHeatIndex() {
        weatherTest = new WeatherReading(25, 16, 8, 18);
        assertEquals(25.95209385554503, weatherTest.getHeatIndex(), 1e-9);
    }

    /**
     * Test getWindChill method
     */
    @Test
    public void testGetWindChill() {
        weatherTest = new WeatherReading(25, 16, 8, 18);
        assertEquals(79.64488856506249, weatherTest.getWindChill(), 1e-9);
    }

    /**
     * Test getToString method
     */
    @Test
    public void testToString() {
        weatherTest = new WeatherReading(25, 16, 8, 18);
        assertEquals("Reading: T = 25, D = 16, v = 8, rain = 18", weatherTest.toString());
    }
}