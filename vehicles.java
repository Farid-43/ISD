// Vehicle Interface
interface Vehicle {
    void printInfo();
}

// Concrete Vehicle Classes
class Car implements Vehicle {
    private String model, make;
    private int year, capacity;

    public Car(String model, String make, int year, int capacity) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.capacity = capacity;
    }

    @Override
    public void printInfo() {
        System.out.println("Car -> Model: " + model + ", Make: " + make +
                ", Year: " + year + ", Capacity: " + capacity + " seats");
    }
}

class Truck implements Vehicle {
    private String model, make;
    private int year, capacity;

    public Truck(String model, String make, int year, int capacity) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.capacity = capacity;
    }

    @Override
    public void printInfo() {
        System.out.println("Truck -> Model: " + model + ", Make: " + make +
                ", Year: " + year + ", Capacity: " + capacity + " tons");
    }
}

class Motorcycle implements Vehicle {
    private String model, make;
    private int year, capacity;

    public Motorcycle(String model, String make, int year, int capacity) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.capacity = capacity;
    }

    @Override
    public void printInfo() {
        System.out.println("Motorcycle -> Model: " + model + ", Make: " + make +
                ", Year: " + year + ", Capacity: " + capacity + " persons");
    }
}

// Factory Pattern
class VehicleFactory {
    public static Vehicle createVehicle(String type, String model, String make, int year, int capacity) {
        switch (type.toUpperCase()) {
            case "CAR":
                return new Car(model, make, year, capacity);
            case "TRUCK":
                return new Truck(model, make, year, capacity);
            case "MOTORCYCLE":
                return new Motorcycle(model, make, year, capacity);
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}

// Singleton Vehicle Management System
class VehicleManagementSystem {
    private static VehicleManagementSystem instance;

    private VehicleManagementSystem() {
    }

    public static VehicleManagementSystem getInstance() {
        if (instance == null) {
            instance = new VehicleManagementSystem();
        }
        return instance;
    }

    public Vehicle addVehicle(String type, String model, String make, int year, int capacity) {
        return VehicleFactory.createVehicle(type, model, make, year, capacity);
    }
}

// Main (Testing)
public class vehicles {
    public static void main(String[] args) {
        // Singleton check
        VehicleManagementSystem vms1 = VehicleManagementSystem.getInstance();
        VehicleManagementSystem vms2 = VehicleManagementSystem.getInstance();
        System.out.println("Same instance? " + (vms1 == vms2)); // true

        // Create vehicles
        Vehicle car = vms1.addVehicle("CAR", "Civic", "Honda", 2022, 5);
        Vehicle truck = vms1.addVehicle("TRUCK", "F-150", "Ford", 2021, 10);
        Vehicle bike = vms1.addVehicle("MOTORCYCLE", "R15", "Yamaha", 2020, 2);

        // Print info
        car.printInfo();
        truck.printInfo();
        bike.printInfo();

        // Test exception
        try {
            Vehicle unknown = vms1.addVehicle("BUS", "Volvo", "Volvo", 2023, 50);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
