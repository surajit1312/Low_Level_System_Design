package P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Good_Code.logger;

public class EagerSingletonLogger {
    private String name;
    private static EagerSingletonLogger logger = new EagerSingletonLogger("Eager Global Logger");

    // restrict access to constructor outside so that no more objects can be created
    private EagerSingletonLogger(String name) {
        this.name = name;
    }

    // only 1 new object can be created if this.logger is null
    public static EagerSingletonLogger getInstance() {
        return logger;
    }

    public void log(String message) {
        System.out.println("Logger [" + name + "]: " + message);
    }
}
