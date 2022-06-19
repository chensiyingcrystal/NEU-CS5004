package transmission;

/**
 * An interface that represents a single car transmission.
 */
public interface Transmission {
    /**
     * Gets a Transmission object with increased speed and appropriate gear.
     *
     * @return a Transmission object with updated speed and its corresponding gear
     */
    Transmission increaseSpeed();

    /**
     * Gets a Transmission object with decreased speed and appropriate gear.
     * Should throw an IllegalStateException if the speed becomes invalid(negative).
     *
     * @return a Transmission object with updated speed(non-negative) and its corresponding gear
     */
    Transmission decreaseSpeed();
    /**
     * get the current speed.
     * @return current speed
     */
    int getSpeed();
    /**
     * get the current gear.
     * @return current gear
     */
    int getGear();
}
