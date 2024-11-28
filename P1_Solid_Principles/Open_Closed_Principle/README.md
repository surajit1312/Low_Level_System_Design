# Open/Closed Principle (OCP)

The <b>Open/Closed Principle (OCP)</b> is the second principle in the SOLID design principles. It states:

    "Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification."

This means that the behavior of a module can be extended without modifying its source code.

## Why OCP Matters

- Avoid Code Breakage
    - By not modifying existing code, you reduce the chances of introducing bugs.

- Ease of Adding Features
    - The system is easier to extend with new features without altering stable code.

- Supports Polymorphism
    - OCP encourages the use of interfaces, abstract classes, and inheritance to make code more dynamic.

### Example of Violating OCP

    class AreaCalculator {
        public double calculateArea(Object shape) {
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                return Math.PI * circle.getRadius() * circle.getRadius();
            } else if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) shape;
                return rectangle.getLength() * rectangle.getWidth();
            }
            return 0;
        }
    }

    class Circle {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }
    }

    class Rectangle {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        public double getLength() {
            return length;
        }

        public double getWidth() {
            return width;
        }
    }

## Problems:

- Code Modification Required for New Shapes:
    - Adding a new shape (e.g., Triangle) would require modifying the AreaCalculator class.

- Violation of OCP:
    - The AreaCalculator class isn’t closed for modification.

## Applying OCP
    
We can refactor the code to make it adhere to OCP by using polymorphism.

### Refactored Code

    // Abstract shape
    interface Shape {
        double calculateArea();
    }

    // Circle
    class Circle implements Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    // Rectangle
    class Rectangle implements Shape {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.length = length;
            this.width = width;
        }

        @Override
        public double calculateArea() {
            return length * width;
        }
    }

    // Triangle (easily added without modifying existing code)
    class Triangle implements Shape {
        private double base;
        private double height;

        public Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        @Override
        public double calculateArea() {
            return 0.5 * base * height;
        }
    }

    // AreaCalculator
    class AreaCalculator {
        public double calculateArea(Shape shape) {
            return shape.calculateArea();
        }
    }

    // Main
    public class OCPExample {
        public static void main(String[] args) {
            Shape circle = new Circle(5);
            Shape rectangle = new Rectangle(4, 6);
            Shape triangle = new Triangle(3, 7);

            AreaCalculator calculator = new AreaCalculator();

            System.out.println("Circle Area: " + calculator.calculateArea(circle));
            System.out.println("Rectangle Area: " + calculator.calculateArea(rectangle));
            System.out.println("Triangle Area: " + calculator.calculateArea(triangle));
        }
    }

## Benefits of the Refactor:

- Extensibility:
    - Adding a new shape (e.g., Triangle) doesn’t require modifying the AreaCalculator or any existing class.

- Reusability:
    - Each shape implements its area calculation, promoting reusability.

- Adherence to OCP:
    - The system is open for extension (new shapes) but closed for modification (no need to modify existing code).


### Output of Refactored Code:

    Circle Area: 78.53981633974483
    Rectangle Area: 24.0
    Triangle Area: 10.5

## Best Practices for OCP

- Use Interfaces or Abstract Classes:
    - Create abstractions to encapsulate common behavior.

- Leverage Polymorphism:
    - Use inheritance to allow dynamic behavior while keeping base classes untouched.

- Avoid Hardcoded Logic:
    - Replace conditional statements (if, else if) with polymorphic calls.

## Resources for Further Reading

- SOLID Principles Overview

    https://en.wikipedia.org/wiki/SOLID

- Clean Code: A Handbook of Agile Software Craftsmanship by Robert C. Martin

## Conclusion

By adhering to the Open/Closed Principle, you ensure that your codebase remains flexible, maintainable, and less error-prone as it evolves.
