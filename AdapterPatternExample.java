// Target
interface Railroad {
    void vehicleMoving();
}

// Adaptee (the class we want to adapt)
class Car {
    public void Drive() {// drive the car}
    }
}

// Adapter class implementing the Target interface
class Adapter implements Railroad {
    private Car car;

    public Adapter(Car car) {
        this.car = car;
    }

    @Override
    public void vehicleMoving() {
        car.Drive();
    }
}

// Client code
public class AdapterPatternExample {
    public static void main(String[] args) {
        Car car = new Car();
        Railroad railroad = new Adapter(car);
        railroad.vehicleMoving();
    }
}