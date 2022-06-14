package weather;
public class WeatherReading {
    private int temperature;
    private int dewPoint;
    private int windSpeed;
    private int totalRain;

    /**
     * Class constructor specifying its attributes.
     * Create a WeatherReading object with its temperature, dew point, wind speed and total rain.
     * The dew point cannot be higher than temperature, wind speed and total rain cannot be negative number.
     *
     * @param t the air temperature in Celsius
     * @param d dew point temperature in Celsius
     * @param v wind speed in miles per hour
     * @param rain total rain in millimeters
     */
    public WeatherReading(int t, int d, int v, int rain) {
        if (d > t) {
            throw new IllegalArgumentException("Dew point temperature cannot be greater than the air temperature t!");
        }

        if (v < 0) {
            throw new IllegalArgumentException("Wind speed cannot be negative!");
        }

        if (rain < 0) {
            throw new IllegalArgumentException("Total rain cannot be negative!");
        }

        this.temperature = t;
        this.dewPoint = d;
        this.windSpeed = v;
        this.totalRain = rain;
    }

    /**
     * Get the air temperature
     * @return the air temperature in Celsius
     */
    public int getTemperature() {
        return this.temperature;
    }

    /**
     * Get the dew Point
     * @return the dew Point in Celsius
     */
    public int getDewPoint() {
        return this.dewPoint;
    }

    /**
     * Get the wind speed
     * @return wind speed in miles per hour
     */
    public int getWindSpeed() {
        return this.windSpeed;
    }

    /**
     * Get the total rain
     * @return total rain in millimeters
     */
    public int getTotalRain() {
        return this.totalRain;
    }

    /**
     * Get relative humidity
     * @return relative humidity in percentage between 0 and 100(R)
     */
    public int getRelativeHumidity(){
        if (this.temperature - this.dewPoint > 20) {
            throw new RuntimeException("Relative humidity cannot be a negative value! Something went wrong with temperature or dewPoint!");
        }

        int relativeHumid = 100 - (this.temperature - this.dewPoint) * 5;
        return relativeHumid;
    }

    /**
     * Get heat index
     * @return heat index representing the feel when relative humidity is factored with the actual temperature.
     */
    public double getHeatIndex() {
        double c1 = -8.78469475556, c2 = 1.61139411, c3 = 2.33854883889, c4 = -0.14611605;
        double c5 = -0.012308094, c6 = -0.0164248277778, c7 = 0.002211732, c8 = 0.00072546, c9 = -0.000003582;
        int relativeHumid = this.getRelativeHumidity();

        double heatIndex = c1 + c2 * this.temperature + c3* relativeHumid + c4 * this.temperature * relativeHumid
                + c5 * Math.pow(this.temperature, 2) + c6 * Math.pow(relativeHumid, 2) + c7 * Math.pow(this.temperature, 2)
                * relativeHumid + c8 * this.temperature * Math.pow(relativeHumid, 2) + c9 * Math.pow(this.temperature, 2)
                * Math.pow(relativeHumid, 2);

        return heatIndex;
    }

    /**
     * Get wind chill
     * @return wind chill based on the air temperature(F) and wind speed(miles/hour).
     */
    public double getWindChill() {
        double tempFahrenheit = this.temperature * 1.8 + 32;
        double windChill = 35.74 + 0.6215 * tempFahrenheit - 35.75 * Math.pow(this.windSpeed, 0.16) + 0.4275 * tempFahrenheit * Math.pow(this.windSpeed, 0.16);
        return windChill;
    }

    /**
     * String representation
     * @return a formatted string output
     */
    @Override
    public String toString() {
        return String.format("Reading: T = %d, D = %d, v = %d, rain = %d", this.temperature, this.dewPoint, this.windSpeed, this.totalRain);
    }
}
