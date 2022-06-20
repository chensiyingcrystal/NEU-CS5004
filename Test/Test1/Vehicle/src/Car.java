public class Car extends Vehicle {
    int wheel;

    public Car(int wheel) {
        super(200);
        this.wheel = wheel;
    }

    void display() {
        System.out.println(this.maxSpeed);
    }
}
