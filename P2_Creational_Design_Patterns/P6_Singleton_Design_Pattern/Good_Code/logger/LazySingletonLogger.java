package P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Good_Code.logger;

public class LazySingletonLogger {
    private String name;
    private static LazySingletonLogger logger;

    // restrict access to constructor outside so that no more objects can be created
    private LazySingletonLogger(String name) {
        this.name = name;
    }

    // only 1 new object can be created if this.logger is null
    public static LazySingletonLogger getInstance() {
        if (logger == null) {
            logger = new LazySingletonLogger("Lazy Global Logger");
        }
        return logger;
    }

    public void log(String message) {
        System.out.println("Logger [" + name + "]: " + message);
    }
}
