
# Proxy Design Pattern - Example

This is an example of the **Proxy Design Pattern** in Java. The Proxy Design Pattern provides a surrogate or placeholder for another object to control access to it. In this example, we demonstrate lazy loading of images using the proxy pattern.

## Components

1. **Image Interface**: This is the common interface for both the real image and proxy classes.
2. **RealImage Class**: This is the concrete implementation of the Image interface. It represents the actual image, with an overhead of loading it from disk.
3. **ImageProxy Class**: This proxy class controls access to the `RealImage`. It delays loading the image until the `display()` method is called.

## Without Proxy Pattern (Before)

In the first scenario, we directly create and use `RealImage` objects without a proxy. This approach can be inefficient as all images are loaded immediately upon object creation.

### Code without Proxy:

```java
// Step 1: Image Interface
public interface Image {
    void display();
}

// Step 2: RealImage Class (Concrete Implementation)
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Step 3: Main Class to Test
public class Main {
    public static void main(String[] args) {
        Image image1 = new RealImage("image1.jpg");
        Image image2 = new RealImage("image2.jpg");

        // Directly calling display method
        image1.display();
        image2.display();
    }
}
```

#### Output:

```
Loading image: image1.jpg
Displaying image: image1.jpg
Loading image: image2.jpg
Displaying image: image2.jpg
```

## With Proxy Pattern (After)

In this approach, we introduce the `ImageProxy` class to control the loading of images. The images are only loaded when needed, providing better performance and reducing memory usage.

### Code with Proxy:

```java
// Step 1: Image Interface
public interface Image {
    void display();
}

// Step 2: RealImage Class (Concrete Implementation)
public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Step 3: Proxy Class
public class ImageProxy implements Image {
    private RealImage realImage;
    private String filename;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);  // Only load the image when it's needed
        }
        realImage.display();
    }
}

// Step 4: Main Class to Test
public class Main {
    public static void main(String[] args) {
        Image image1 = new ImageProxy("image1.jpg");
        Image image2 = new ImageProxy("image2.jpg");

        // Display images, loading happens only when needed
        image1.display();
        image2.display();
    }
}
```

#### Output:

```
Loading image: image1.jpg
Displaying image: image1.jpg
Loading image: image2.jpg
Displaying image: image2.jpg
```

## Benefits of Proxy Pattern

- **Lazy Initialization**: The real object is created only when it's actually needed.
- **Access Control**: You can add extra control over how the object is accessed or modified (e.g., logging, security).
- **Remote Proxy**: If the object is in a different system, the proxy handles communication.

## Conclusion

The Proxy Design Pattern helps in cases where you need to add extra functionality, such as lazy loading or access control, without modifying the real object. The example here demonstrates how a proxy can be used to load images only when needed, improving memory usage and performance.
