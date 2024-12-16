package P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Breaking_With_MultiThreads.logger;

public class BreakableSingletonLogger {
    private String name;
    private static BreakableSingletonLogger instance;

    private BreakableSingletonLogger(String name) {
        this.name = name;
    }

    public static BreakableSingletonLogger getInstance() {
        if (instance == null) {
            // Simulating delay to allow multiple threads to enter this block
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new BreakableSingletonLogger("Breakable Singleton Logger");
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Breakable Singleton Logger [" + name + "]: " + message);
    }
}
