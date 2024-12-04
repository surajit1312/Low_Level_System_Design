# Abstract Factory Design Pattern

The **Abstract Factory Design Pattern** is ideal for scenarios where you want to create families of related or dependent objects without specifying their concrete classes. A classic example is creating UI elements (like buttons and text fields) for different operating systems (Windows and Mac).

## Without Abstract Factory Design Pattern

The client directly interacts with the concrete implementations for each operating system, leading to tightly coupled code.


### Code Example:

    // Abstract Product Interfaces
    interface Button {
        void render();
    }

    interface TextField {
        void render();
    }

    // Concrete Products for Windows
    class WindowsButton implements Button {
        @Override
        public void render() {
            System.out.println("Rendering Windows Button");
        }
    }

    class WindowsTextField implements TextField {
        @Override
        public void render() {
            System.out.println("Rendering Windows TextField");
        }
    }

    // Concrete Products for Mac
    class MacButton implements Button {
        @Override
        public void render() {
            System.out.println("Rendering Mac Button");
        }
    }

    class MacTextField implements TextField {
        @Override
        public void render() {
            System.out.println("Rendering Mac TextField");
        }
    }

    // Abstract Factory Interface
    interface UIFactory {
        Button createButton();
        TextField createTextField();
    }

    // Concrete Factory for Windows
    class WindowsFactory implements UIFactory {
        @Override
        public Button createButton() {
            return new WindowsButton();
        }

        @Override
        public TextField createTextField() {
            return new WindowsTextField();
        }
    }

    // Concrete Factory for Mac
    class MacFactory implements UIFactory {
        @Override
        public Button createButton() {
            return new MacButton();
        }

        @Override
        public TextField createTextField() {
            return new MacTextField();
        }
    }

    // Client Code
    public class MainWithAbstractFactory {
        public static void main(String[] args) {
            // Create a factory for Windows
            UIFactory windowsFactory = new WindowsFactory();
            Button windowsButton = windowsFactory.createButton();
            TextField windowsTextField = windowsFactory.createTextField();
            windowsButton.render();
            windowsTextField.render();

            // Create a factory for Mac
            UIFactory macFactory = new MacFactory();
            Button macButton = macFactory.createButton();
            TextField macTextField = macFactory.createTextField();
            macButton.render();
            macTextField.render();
        }
    }

## Problems Without Abstract Factory:

- The client is tightly coupled to the concrete classes (WindowsButton, MacButton).

- Adding a new OS family (e.g., Linux) or UI component requires significant changes in client code.

- Violates the **Open/Closed Principle (OCP)**.

- Violates the **Dependency Inversion Principle (DIP)**.

    - The high-level module (the client code) directly depends on the low-level modules (WindowsButton, MacButton, WindowsTextField, MacTextField).

    - There is no abstraction managing the relationship between the high-level module and the concrete implementations.

    - Adding a new platform (e.g., Linux) or changing the implementation requires modifying the high-level module, which breaks DIP.


## With Abstract Factory Design Pattern

The client interacts only with the abstract factories and products, ensuring loose coupling and better scalability.

### Code Example:

    // Abstract Product Interfaces
    interface Button {
        void render();
    }

    interface TextField {
        void render();
    }

    // Concrete Products for Windows
    class WindowsButton implements Button {
        @Override
        public void render() {
            System.out.println("Rendering Windows Button");
        }
    }

    class WindowsTextField implements TextField {
        @Override
        public void render() {
            System.out.println("Rendering Windows TextField");
        }
    }

    // Concrete Products for Mac
    class MacButton implements Button {
        @Override
        public void render() {
            System.out.println("Rendering Mac Button");
        }
    }

    class MacTextField implements TextField {
        @Override
        public void render() {
            System.out.println("Rendering Mac TextField");
        }
    }

    // Abstract Factory Interface
    interface UIFactory {
        Button createButton();
        TextField createTextField();
    }

    // Concrete Factory for Windows
    class WindowsFactory implements UIFactory {
        @Override
        public Button createButton() {
            return new WindowsButton();
        }

        @Override
        public TextField createTextField() {
            return new WindowsTextField();
        }
    }

    // Concrete Factory for Mac
    class MacFactory implements UIFactory {
        @Override
        public Button createButton() {
            return new MacButton();
        }

        @Override
        public TextField createTextField() {
            return new MacTextField();
        }
    }

    // Client Code
    public class MainWithAbstractFactory {
        public static void main(String[] args) {
            // Create a factory for Windows
            UIFactory windowsFactory = new WindowsFactory();
            Button windowsButton = windowsFactory.createButton();
            TextField windowsTextField = windowsFactory.createTextField();
            windowsButton.render();
            windowsTextField.render();

            // Create a factory for Mac
            UIFactory macFactory = new MacFactory();
            Button macButton = macFactory.createButton();
            TextField macTextField = macFactory.createTextField();
            macButton.render();
            macTextField.render();
        }
    }


## Advantages of Abstract Factory Design Pattern

- **Encapsulation:**

  The factory encapsulates the logic for creating related objects.

- **Scalability:**

  Adding a new OS family (e.g., Linux) requires creating a new factory and corresponding product classes without modifying client code.

- **Decoupling:**
  
  The client interacts with interfaces and abstract factories, not concrete implementations.

### Adherence to SOLID Principles:

- **Open/Closed Principle (OCP):**
  
  New families or components can be added without changing existing code.

- **Single Responsibility Principle (SRP):**
  
  Factories manage object creation, while the client focuses on using them.

- **Dependency Inversion Principle (DIP)**.
  
  The high-level module (the client code) now does not directly depend on the low-level modules (WindowsButton, MacButton, WindowsTextField, MacTextField) and there is an abstraction layer UIFactory to decouple High-level modules from low-level modules.

