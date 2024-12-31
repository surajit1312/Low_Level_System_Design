# Composite Design Pattern Example in Java

The **Composite Design Pattern** is a structural pattern used to treat individual objects and compositions of objects uniformly. It is particularly useful for representing part-whole hierarchies, such as file systems, GUI components, or organizational structures.

In this example, we will use a **File System** as an analogy to understand the Composite Design Pattern.

---

## Problem Statement
We need to represent a file system where both files and folders can be treated uniformly. A folder can contain files and other folders, creating a tree-like structure. Without the Composite Pattern, handling such a hierarchy would require type-checking and a lot of repetitive code.

---

## Without Applying the Composite Design Pattern

Without the Composite Pattern, you would need to implement separate logic for handling individual files and folders. This approach is inflexible and requires manual type-checking.

### **Code**

#### File Class
```java
class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void showFile() {
        System.out.println("File: " + name);
    }
}
```

#### Folder Class
```java
import java.util.ArrayList;
import java.util.List;

class Folder {
    private String name;
    private List<File> files;

    public Folder(String name) {
        this.name = name;
        this.files = new ArrayList<>();
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void showFiles() {
        System.out.println("Folder: " + name);
        for (File file : files) {
            file.showFile();
        }
    }
}
```

#### Client Code
```java
public class FileSystemWithoutComposite {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        Folder folder = new Folder("MyFolder");
        folder.addFile(file1);
        folder.addFile(file2);

        folder.showFiles();
    }
}
```

---

### **Issues**
1. **No Uniformity:** Cannot treat files and folders uniformly.
2. **Inflexibility:** Adding subfolders requires changing the folder implementation.
3. **Repetitive Code:** Logic for handling files and folders must be duplicated.

---

## With Applying the Composite Design Pattern
The Composite Pattern allows us to treat both files and folders uniformly by defining a common interface.

### **Code**

#### Component Interface
```java
interface FileSystemComponent {
    void show();
}
```

#### Leaf Class: File
```java
class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void show() {
        System.out.println("File: " + name);
    }
}
```

#### Composite Class: Folder
```java
import java.util.ArrayList;
import java.util.List;

class Folder implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components;

    public Folder(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    @Override
    public void show() {
        System.out.println("Folder: " + name);
        for (FileSystemComponent component : components) {
            component.show();
        }
    }
}
```

#### Client Code
```java
public class FileSystemWithComposite {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("file1.txt");
        FileSystemComponent file2 = new File("file2.txt");
        FileSystemComponent file3 = new File("file3.txt");

        Folder folder1 = new Folder("Folder1");
        folder1.addComponent(file1);
        folder1.addComponent(file2);

        Folder folder2 = new Folder("Folder2");
        folder2.addComponent(file3);
        folder2.addComponent(folder1);

        folder2.show();
    }
}
```

---

### **Output**

#### Without Applying the Composite Pattern
```
Folder: MyFolder
File: file1.txt
File: file2.txt
```

#### With Applying the Composite Pattern
```
Folder: Folder2
File: file3.txt
Folder: Folder1
File: file1.txt
File: file2.txt
```

---

## **Benefits of the Composite Design Pattern**
1. **Uniformity:** Treat individual objects and compositions uniformly.
2. **Extensibility:** Easily add new types of components (e.g., symbolic links).
3. **Clean Code:** Reduces duplication and simplifies the client code.
4. **Tree Structure:** Naturally represents hierarchical relationships.

---

## **How to Run**
1. Copy the code into your Java IDE.
2. Run `FileSystemWithoutComposite` to see the issues without the Composite Pattern.
3. Run `FileSystemWithComposite` to observe the benefits of the Composite Pattern.
