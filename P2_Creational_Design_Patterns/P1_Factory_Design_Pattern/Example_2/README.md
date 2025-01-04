# Factory Design Pattern

The **Factory Design Pattern** is a creational design pattern that provides an interface for creating objects without specifying their exact classes. This promotes loose coupling and enhances code flexibility.

Example Scenario: **Vehicle Creation**

Consider a scenario where we need to create different types of vehicles, such as cars and trucks.

---

## Without Using the Factory Design Pattern

In this approach, the client code is responsible for instantiating the specific vehicle classes directly.

### Code

```java
// Vehicle interface
interface Vehicle {
    void drive();
}

// Car class
class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving a car.");
    }
}

// Truck class
class Truck implements Vehicle {
    public void drive() {
        System.out.println("Driving a truck.");
    }
}

// Client code
public class VehicleClient {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Car();
        vehicle1.drive();

        Vehicle vehicle2 = new Truck();
        vehicle2.drive();
    }
}
```

### Issues with the Above Approach:

- **Tight Coupling**: The client code is tightly coupled to the concrete classes (Car and Truck), making it difficult to introduce new vehicle types without modifying the client code.

- **Reduced Flexibility**: Adding new vehicle types requires changes in the client code, violating the Open/Closed Principle.

---

## Using the Factory Design Pattern

By introducing a factory, we can delegate the instantiation logic to a separate class, promoting loose coupling and adherence to the Open/Closed Principle.

### Code

```java
// Vehicle interface
interface Vehicle {
    void drive();
}

// Car class
class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving a car.");
    }
}

// Truck class
class Truck implements Vehicle {
    public void drive() {
        System.out.println("Driving a truck.");
    }
}

// VehicleFactory class
class VehicleFactory {
    // Factory method to create vehicles
    public static Vehicle createVehicle(String type) {
        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "truck":
                return new Truck();
            default:
                throw new IllegalArgumentException("Unknown vehicle type.");
        }
    }
}

// Client code
public class VehicleClient {
    public static void main(String[] args) {
        Vehicle vehicle1 = VehicleFactory.createVehicle("car");
        vehicle1.drive();

        Vehicle vehicle2 = VehicleFactory.createVehicle("truck");
        vehicle2.drive();
    }
}
```

### Benefits of Using the Factory Design Pattern:

- **Loose Coupling**: The client code depends on the Vehicle interface and the VehicleFactory, not on the concrete implementations, enhancing flexibility.

- **Open/Closed Principle**: New vehicle types can be added with minimal changes to the factory method, without altering the client code.

- **Centralized Object Creation**: The instantiation logic is centralized in the factory, making it easier to manage and modify.

By applying the Factory Design Pattern, we achieve a more modular and maintainable codebase, where the creation of objects is managed centrally, and the client code remains agnostic of the specific classes being instantiated.

