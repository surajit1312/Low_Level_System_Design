
# Singleton Design Pattern Example: Logger System

This repository demonstrates the **Singleton Design Pattern** in Java by simulating a Logger system. The Logger system ensures only one instance of the logger exists to provide consistent logging throughout the application.

---

## **Scenario**

In an application, logging is a common feature. Having multiple Logger instances can lead to inconsistencies and resource wastage. The **Singleton Pattern** ensures that only one instance of the Logger exists and is shared across the entire application.

---

## **Without Singleton Design Pattern**

Here, multiple instances of the Logger class can be created, leading to inconsistencies.

### Code Example

```java
// Logger Class
class Logger {
    private String name;

    public Logger(String name) {
        this.name = name;
    }

    public void log(String message) {
        System.out.println(name + " logs: " + message);
    }
}

// Client Code
public class WithoutSingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = new Logger("Logger1");
        logger1.log("This is the first log message.");

        Logger logger2 = new Logger("Logger2");
        logger2.log("This is the second log message.");

        // Multiple instances of Logger lead to inconsistent logging
        System.out.println(logger1 == logger2); // false
    }
}
```

---

## **With Singleton Design Pattern**

Using the Singleton Pattern ensures that only one instance of the Logger exists.

### Code Example

```java
// Logger Class
class Logger {
    private static Logger instance;
    private String name;

    // Private constructor to prevent instantiation
    private Logger(String name) {
        this.name = name;
    }

    // Public method to provide access to the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger("GlobalLogger");
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(name + " logs: " + message);
    }
}

// Client Code
public class WithSingletonPattern {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

        // Verifying that both logger1 and logger2 refer to the same instance
        System.out.println(logger1 == logger2); // true
    }
}
```

---

## **Advantages of Singleton Design Pattern**

1. **Single Instance**: Ensures only one instance exists.
2. **Global Access**: Provides a single point of access to the instance.
3. **Memory Efficiency**: Reduces memory usage by sharing the instance.

---

## **Real-Life Applications**

1. **Configuration Management**: Single source for application configuration settings.
2. **Connection Pooling**: Managing database connections efficiently.
3. **Logging**: Consistent logging across the application.

---

## **Conclusion**

The Singleton Design Pattern is a simple yet powerful tool to manage a single instance of a class across the application. It ensures consistency, saves resources, and simplifies access to the instance.
