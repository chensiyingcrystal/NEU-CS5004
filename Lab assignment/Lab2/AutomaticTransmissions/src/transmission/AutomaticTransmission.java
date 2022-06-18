package transmission;

public class AutomaticTransmission implements Transmission{
    int currGear;
    int currSpeed;

    public AutomaticTransmission(int speed1, int speed2, int speed3, int speed4, int speed5) {
        if (speed1 < 0 || speed1 < 0 || speed1 < 0 || speed1 < 0 || speed1 < 0) {
            throw new IllegalArgumentException("Speed cannot be negative number!");
        }

    }

    public Transmission increaseSpeed() {
        

    }

    public Transmission decreaseSpeed() {

    }
}
