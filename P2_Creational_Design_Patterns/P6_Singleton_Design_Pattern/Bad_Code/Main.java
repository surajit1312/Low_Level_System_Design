package P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Bad_Code;

import P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Bad_Code.logger.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = new Logger("Logger 1");
        logger1.log("This is my first log message");

        Logger logger2 = new Logger("Logger 2");
        logger2.log("This is my second log message");

        System.out.println(logger1.hashCode());
        System.out.println(logger2.hashCode());
        System.out.println("Are instances same : " + (logger1 == logger2));
    }
}
