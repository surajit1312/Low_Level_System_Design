# Factory Design Pattern

## Example: Cab Booking System

### Requirement:

- The system needs to book different types of cabs: Micro, Mini, and Luxury.
- The client should not directly instantiate cab classes but use a centralized factory.

### Without Factory Design Pattern

    // Cab Interface
    interface Cab {
        void book();
    }

    // Concrete Classes for different types of cabs
    class Micro implements Cab {
        @Override
        public void book() {
            System.out.println("Micro cab booked.");
        }
    }

    class Mini implements Cab {
        @Override
        public void book() {
            System.out.println("Mini cab booked.");
        }
    }

    class Luxury implements Cab {
        @Override
        public void book() {
            System.out.println("Luxury cab booked.");
        }
    }

    // Client Code
    public class CabBookingWithoutFactory {
        public static void main(String[] args) {
            // Client is responsible for instantiating the specific cab class
            Cab microCab = new Micro();
            Cab miniCab = new Mini();
            Cab luxuryCab = new Luxury();

            microCab.book();
            miniCab.book();
            luxuryCab.book();
        }
    }

### Problems Without Factory:

1. **The client must know the concrete classes (Micro, Mini, Luxury).**
2. **Adding a new cab type requires changes to all client code that uses cab classes.**
3. **Violates the Single Responsibility Principle since the client handles both cab creation and business logic.**


### With Factory Design Pattern

    // Cab Interface
    interface Cab {
        void book();
    }

    // Concrete Classes for different types of cabs
    class Micro implements Cab {
        @Override
        public void book() {
            System.out.println("Micro cab booked.");
        }
    }

    class Mini implements Cab {
        @Override
        public void book() {
            System.out.println("Mini cab booked.");
        }
    }

    class Luxury implements Cab {
        @Override
        public void book() {
            System.out.println("Luxury cab booked.");
        }
    }

    // CabFactory Class
    class CabFactory {
        // Factory Method to create cabs
        public Cab getCab(String cabType) {
            if (cabType == null) {
                return null;
            }
            switch (cabType.toLowerCase()) {
                case "micro":
                    return new Micro();
                case "mini":
                    return new Mini();
                case "luxury":
                    return new Luxury();
                default:
                    throw new IllegalArgumentException("Invalid cab type: " + cabType);
            }
        }
    }

    // Client Code
    public class CabBookingWithFactory {
        public static void main(String[] args) {
            CabFactory cabFactory = new CabFactory();

            // Client delegates cab creation to the factory
            Cab microCab = cabFactory.getCab("micro");
            Cab miniCab = cabFactory.getCab("mini");
            Cab luxuryCab = cabFactory.getCab("luxury");

            microCab.book();
            miniCab.book();
            luxuryCab.book();
        }
    }


### Advantages of Factory Design Pattern

1. **Centralized Object Creation:**
  
    The CabFactory handles cab creation. The client only requests to send cab type as a parameter.

2. **Extensibility:**

    Adding a new cab type (e.g., SUV) only requires changes in the factory without affecting client code.

3. **Decoupling:**

    The client is decoupled from the concrete cab classes, reducing dependency.


### Extending the Example

    Let’s add a new cab type (SUV):

    class SUV implements Cab {
        @Override
        public void book() {
            System.out.println("SUV cab booked.");
        }
    }

    // Update Factory
    class CabFactory {
        public Cab getCab(String cabType) {
            if (cabType == null) {
                return null;
            }
            switch (cabType.toLowerCase()) {
                case "micro":
                    return new Micro();
                case "mini":
                    return new Mini();
                case "luxury":
                    return new Luxury();
                case "suv":
                    return new SUV(); // New cab type
                default:
                    throw new IllegalArgumentException("Invalid cab type: " + cabType);
            }
        }
    }

**No changes are required in the client code, demonstrating the Open/Closed Principle.**


This example makes the system flexible and maintainable while showing the practical application of the **Factory Design Pattern** in a **Cab Booking System**.
