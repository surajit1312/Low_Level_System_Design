
# Builder Design Pattern Example: Building a Desktop

This repository demonstrates the use of the **Builder Design Pattern** in Java by simulating the process of building `Desktop` objects with various configurations.

---

## **Scenario**

Desktops can have various configurations like:
- Processor
- RAM
- Storage
- GPU inclusion
- Peripheral inclusion

The `Builder Design Pattern` helps construct these objects step-by-step, providing flexibility and improved readability.

---

## **Without Builder Design Pattern**

In the traditional approach, a single constructor is used to create `Desktop` objects. This method becomes problematic as the number of optional parameters increases.

### Code Example

```java
// Desktop Class
class Desktop {
    private String processor;
    private int ram; // in GB
    private int storage; // in GB
    private boolean hasGPU;
    private boolean hasPeripherals;

    // Constructor
    public Desktop(String processor, int ram, int storage, boolean hasGPU, boolean hasPeripherals) {
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.hasGPU = hasGPU;
        this.hasPeripherals = hasPeripherals;
    }

    @Override
    public String toString() {
        return "Desktop [Processor=" + processor + ", RAM=" + ram + "GB, Storage=" + storage 
                + "GB, GPU=" + hasGPU + ", Peripherals=" + hasPeripherals + "]";
    }
}

// Client Code
public class WithoutBuilderPattern {
    public static void main(String[] args) {
        // Creating a gaming desktop
        Desktop gamingDesktop = new Desktop("Intel i9", 32, 2000, true, true);

        // Creating a basic desktop
        Desktop basicDesktop = new Desktop("Intel i5", 8, 500, false, false);

        System.out.println(gamingDesktop);
        System.out.println(basicDesktop);
    }
}
```

---

## **With Builder Design Pattern**

The Builder Design Pattern separates the object construction logic from its representation, providing a cleaner and more flexible design.

### Code Example

```java
// Desktop Class
class Desktop {
    private String processor;
    private int ram; // in GB
    private int storage; // in GB
    private boolean hasGPU;
    private boolean hasPeripherals;

    // Private Constructor
    private Desktop(DesktopBuilder builder) {
        this.processor = builder.processor;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.hasGPU = builder.hasGPU;
        this.hasPeripherals = builder.hasPeripherals;
    }

    @Override
    public String toString() {
        return "Desktop [Processor=" + processor + ", RAM=" + ram + "GB, Storage=" + storage 
                + "GB, GPU=" + hasGPU + ", Peripherals=" + hasPeripherals + "]";
    }

    // Static Builder Class
    public static class DesktopBuilder {
        private String processor;
        private int ram; // in GB
        private int storage; // in GB
        private boolean hasGPU;
        private boolean hasPeripherals;

        public DesktopBuilder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public DesktopBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public DesktopBuilder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public DesktopBuilder setHasGPU(boolean hasGPU) {
            this.hasGPU = hasGPU;
            return this;
        }

        public DesktopBuilder setHasPeripherals(boolean hasPeripherals) {
            this.hasPeripherals = hasPeripherals;
            return this;
        }

        public Desktop build() {
            return new Desktop(this);
        }
    }
}

// Client Code
public class WithBuilderPattern {
    public static void main(String[] args) {
        // Building a gaming desktop
        Desktop gamingDesktop = new Desktop.DesktopBuilder()
                .setProcessor("Intel i9")
                .setRam(32)
                .setStorage(2000)
                .setHasGPU(true)
                .setHasPeripherals(true)
                .build();

        // Building a basic desktop
        Desktop basicDesktop = new Desktop.DesktopBuilder()
                .setProcessor("Intel i5")
                .setRam(8)
                .setStorage(500)
                .setHasGPU(false)
                .setHasPeripherals(false)
                .build();

        System.out.println(gamingDesktop);
        System.out.println(basicDesktop);
    }
}
```

---

## **Advantages of Using Builder Pattern**

1. **Improved Readability**: Clear and readable object construction with a fluent interface.
2. **Flexible Object Creation**: Optional and required attributes are handled seamlessly.
3. **Immutable Objects**: Final objects are immutable since all properties are set during the build process.
4. **Open/Closed Principle**: Adding new features is simple and doesn't affect existing code.

---

## **Adding New Features**

To add a new feature, such as `waterCooling`:

1. Add a new field (`boolean hasWaterCooling`) in the `DesktopBuilder` class.
2. Add a method (`setHasWaterCooling(boolean hasWaterCooling)`) in `DesktopBuilder`.
3. Update the `build()` method to set the new property in the `Desktop` class.

```java
public DesktopBuilder setHasWaterCooling(boolean hasWaterCooling) {
    this.hasWaterCooling = hasWaterCooling;
    return this;
}
```

---

## **UML Diagram**

![UML_Diagram](https://github.com/user-attachments/assets/6482087f-afba-4064-a9ee-c077da5f1d61)

---

## **Conclusion**

The Builder Design Pattern provides a structured, flexible, and scalable way to construct objects, particularly when the objects are complex or have optional configurations.
