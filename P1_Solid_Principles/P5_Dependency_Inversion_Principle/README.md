# Dependency Inversion Principle (DIP)

The **Dependency Inversion Principle (DIP)** is the fifth principle in the **SOLID** design principles. It states:  

> **"High-level modules should not depend on low-level modules. Both should depend on abstractions."**  
> **"Abstractions should not depend on details. Details should depend on abstractions."**

This means that the design should decouple high-level and low-level modules by introducing an abstraction layer.

---

## Why DIP Matters

1. **Improves Modularity:**  
   Promotes loose coupling between high-level and low-level modules.

2. **Enhances Testability:**  
   Abstractions allow you to easily replace implementations for testing.

3. **Facilitates Scalability:**  
   Adding new features or modules becomes easier without affecting existing code.

---

## Example of Violating DIP


    // Low-level Module
    class Keyboard {
        public String getInput() {
            return "Keyboard input";
        }
    }

    // High-level Module
    class Computer {
        private Keyboard keyboard;

        public Computer() {
            this.keyboard = new Keyboard(); // Direct dependency
        }

        public void start() {
            System.out.println("Computer started with: " + keyboard.getInput());
        }
    }

## Problem:

1. **Tight Coupling:**

   The Computer class directly depends on the Keyboard class, making it hard to replace the input device.

2. **Violation of DIP:**

   There is no abstraction layer between the high-level module (Computer) and the low-level module (Keyboard).

## Refactoring to Follow DIP

Introduce an abstraction (InputDevice) and let both high-level and low-level modules depend on it.

## Refactored Code

    // Abstraction
    interface InputDevice {
        String getInput();
    }

    // Low-level Module: Keyboard
    class Keyboard implements InputDevice {
        @Override
        public String getInput() {
            return "Keyboard input";
        }
    }

    // Low-level Module: Mouse
    class Mouse implements InputDevice {
        @Override
        public String getInput() {
            return "Mouse input";
        }
    }

    // High-level Module
    class Computer {
        private InputDevice inputDevice;

        public Computer(InputDevice inputDevice) {
            this.inputDevice = inputDevice; // Depends on abstraction
        }

        public void start() {
            System.out.println("Computer started with: " + inputDevice.getInput());
        }
    }

    // Main
    public class DIPExample {
        public static void main(String[] args) {
            InputDevice keyboard = new Keyboard();
            InputDevice mouse = new Mouse();

            Computer computerWithKeyboard = new Computer(keyboard);
            computerWithKeyboard.start();

            Computer computerWithMouse = new Computer(mouse);
            computerWithMouse.start();
        }
    }


## Benefits of the Refactor:
1. **Adherence to DIP:**

   The Computer class depends on the InputDevice abstraction, not on specific implementations like Keyboard or Mouse.

2. **Flexibility:**

   New input devices can be added (e.g., Touchpad) without modifying the Computer class.

3. **Improved Testability:**

   You can easily mock or replace InputDevice for unit testing.


## Output of Refactored Code:

    Computer started with: Keyboard input
    Computer started with: Mouse input


## Best Practices for DIP
1. **Use Interfaces or Abstract Classes:**
   
   Define abstractions for high-level modules to depend on.

2. **Apply Dependency Injection:**

   Pass dependencies via constructors, setters, or frameworks.

3. **Avoid Hardcoding Dependencies:**

   Use factories or service containers to manage dependencies.

---

## Resources for Further Reading

- [SOLID Principles Overview](https://en.wikipedia.org/wiki/SOLID)
- [Clean Code: A Handbook of Agile Software Craftsmanship](https://www.goodreads.com/book/show/3735293-clean-code) by Robert C. Martin

---

By adhering to the **Dependency Inversion Principle**, your code becomes more flexible, testable, and easier to maintain.
