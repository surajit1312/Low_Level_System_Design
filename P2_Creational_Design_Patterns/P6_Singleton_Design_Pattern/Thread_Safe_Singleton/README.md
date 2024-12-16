# Making Singleton Design Pattern Thread-safe

You can make the Singleton class thread-safe by using a **ReentrantLock** from the **java.util.concurrent.locks** package. This lock provides finer-grained control over synchronization compared to synchronized.

Using ReentrantLock, we can ensure only one thread creates the Singleton instance, even when multiple threads try to access it concurrently.

## **Thread-Safe Singleton Using ReentrantLock**

### Code Example

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Singleton Class with ReentrantLock
class Logger {
    private static Logger instance;
    private static final Lock lock = new ReentrantLock(); // ReentrantLock for thread safety
    private String name;

    // Private constructor
    private Logger(String name) {
        this.name = name;
    }

    // Thread-safe getInstance method
    public static Logger getInstance() {
        if (instance == null) {
            lock.lock(); // Acquire the lock
            try {
                if (instance == null) { // Double-checking for lazy initialization
                    instance = new Logger("GlobalLogger");
                }
            } finally {
                lock.unlock(); // Release the lock
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(name + " logs: " + message);
    }
}

// Thread Task to Access Singleton
class SingletonTask implements Runnable {
    @Override
    public void run() {
        Logger logger = Logger.getInstance();
        System.out.println(Thread.currentThread().getName() + " - Logger Instance: " + logger);
    }
}

// Client Code
public class ThreadSafeSingletonWithLock {
    public static void main(String[] args) {
        // Starting multiple threads to test Singleton with ReentrantLock
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SingletonTask(), "Thread-" + i);
            thread.start();
        }
    }
}

```

## **Key Points:**

1 **ReentrantLock:**

A lock is used to ensure that only one thread enters the critical section (instance creation).
lock.lock() acquires the lock, and lock.unlock() releases it.

2. **Double-Check Locking:**

Before acquiring the lock, we check if (instance == null) to avoid unnecessary locking.
Inside the critical section, we perform a second check to ensure no other thread has already created the instance.

3. **try-finally Block:**

Ensures that the lock is always released, even if an exception occurs.

## Output Example:

```

Thread-0 - Logger Instance: Logger@6bc7c054
Thread-2 - Logger Instance: Logger@6bc7c054
Thread-1 - Logger Instance: Logger@6bc7c054
Thread-3 - Logger Instance: Logger@6bc7c054
Thread-4 - Logger Instance: Logger@6bc7c054

```

## Why Use ReentrantLock Over synchronized?

1. **Fairness:** ReentrantLock allows fairness policies, meaning the longest-waiting thread can acquire the lock first.
2. **Interruptibility:** Threads waiting on a ReentrantLock can be interrupted, unlike the synchronized keyword.
3. **Explicit Locking:** Provides more granular control compared to the implicit synchronized.
