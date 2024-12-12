package P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Bad_Code.logger;

public class Logger {
    private String name;

    public Logger(String name) {
        this.name = name;
    }

    public void log(String message) {
        System.out.println("Logger [" + name + "]: " + message);
    }
}
