package P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Thread_Safe_Singleton.logger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeSingletonLogger {
    private String name;
    private static ThreadSafeSingletonLogger instance;

    private static Lock mtxLock = new ReentrantLock();

    private ThreadSafeSingletonLogger(String name) {
        this.name = name;
    }

    public static ThreadSafeSingletonLogger getInstance() {
        if (instance == null) { // First check without locking
            mtxLock.lock(); // applying lock
            try {
                if (instance == null) { // Double-checked locking
                    Thread.sleep(50);
                    instance = new ThreadSafeSingletonLogger("Threadsafe Singleton Logger");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                mtxLock.unlock(); // Always release the lock
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Breakable Singleton Logger [" + name + "]: " + message);
    }
}
