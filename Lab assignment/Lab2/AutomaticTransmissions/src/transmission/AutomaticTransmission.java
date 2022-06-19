package transmission;

/**
 * A class that represents automatic transmission which automatically determines the current gear by the current speed of the car.
 */
public class AutomaticTransmission implements Transmission{
    private int currGear;
    private int currSpeed;
    private final int speedThreshold1;
    private final int speedThreshold2;
    private final int speedThreshold3;
    private final int speedThreshold4;
    private final int speedThreshold5;

    /**
     * Constructs an automatic transmission with speed thresholds for the 6 possible gears in order.
     *
     * @param speedThreshold1 for gear from 1 to 2 or back;
     * @param speedThreshold2 for gear from 2 to 3 or back;
     * @param speedThreshold3 for gear from 3 to 4 or back;
     * @param speedThreshold4 for gear from 4 to 5 or back;
     * @param speedThreshold5 for gear from 5 to 6 or back;
     * @throws IllegalArgumentException if any of speed thresholds is negative or their values are not ordered increasingly.
     */
    public AutomaticTransmission(int speedThreshold1, int speedThreshold2, int speedThreshold3,
                                 int speedThreshold4, int speedThreshold5) throws IllegalArgumentException {
        if (speedThreshold1 < 0 || speedThreshold2 < 0 || speedThreshold3 < 0 || speedThreshold4 < 0 || speedThreshold5 < 0) {
            throw new IllegalArgumentException("Speed cannot be negative number!");
        }

        if (speedThreshold1 >= speedThreshold2 || speedThreshold2 >= speedThreshold3 || speedThreshold3 >= speedThreshold4
            || speedThreshold4 >= speedThreshold5) {
            throw new IllegalArgumentException("speed thresholds must be passed in increasing order!");
        }

        this.currSpeed = 0;
        this.currGear = 0;
        this.speedThreshold1 = speedThreshold1;
        this.speedThreshold2 = speedThreshold2;
        this.speedThreshold3 = speedThreshold3;
        this.speedThreshold4 = speedThreshold4;
        this.speedThreshold5 = speedThreshold5;

    }

    /**
     * A method that recalculate current gear based on the current speed of the object.
     */
    private void reDefineCurrGear(){
        if (this.currSpeed == 0) {
            this.currGear = 0;
        }
        else if (this.currSpeed <= this.speedThreshold1) {
            this.currGear = 1;
        }
        else if (this.currSpeed <= this.speedThreshold2) {
            this.currGear = 2;
        }
        else if (this.currSpeed <= this.speedThreshold3) {
            this.currGear = 3;
        }
        else if (this.currSpeed <= this.speedThreshold4) {
            this.currGear = 4;
        }
        else if (this.currSpeed <= this.speedThreshold5) {
            this.currGear = 5;
        }
        else {
            this.currGear = 6;
        }
        return;
    }

    /**
     * A method that returns an auto transmission object after increasing speed.
     * @return an auto transmission object with increased speed and its corresponding gear.
     */
    @Override
    public Transmission increaseSpeed() {
        this.currSpeed += 2;
        reDefineCurrGear();
        return this;
    }

    /**
     * A method that returns an auto transmission object after decreasing speed.
     * The speed cannot be allowed to be negative number.
     *
     * @throws IllegalStateException if the speed is changed to be negative.
     * @return an auto transmission object with increased speed and its corresponding gear.
     */
    @Override
    public Transmission decreaseSpeed() throws IllegalStateException{
        this.currSpeed -= 2;
        if (this.currSpeed < 0) {
            throw new IllegalStateException("Speed cannot be reduced below 0!");
        }

        reDefineCurrGear();
        return this;
    }

    /**
     * get the current speed.
     * @return current speed
     */
    @Override
    public int getSpeed() {
        return this.currSpeed;
    }

    /**
     * get current gear
     * @return current gear
     */
    @Override
    public int getGear() {
        return this.currGear;
    }

    /**
     * get string representation of the object
     * @return a string that represents information of the object
     */
    @Override
    public String toString() {
        return String.format("Transmission (speed = %d, gear = %d)", this.currSpeed, this.currGear);
    }
}
