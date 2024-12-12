package P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Good_Code;

import P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Good_Code.logger.EagerSingletonLogger;
import P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Good_Code.logger.LazySingletonLogger;

public class Main {
    public static void main(String[] args) {
        /**
         * Eager Singleton Usage
         */
        EagerSingletonLogger logger1 = EagerSingletonLogger.getInstance();
        logger1.log("This is my first log message");

        EagerSingletonLogger logger2 = EagerSingletonLogger.getInstance();
        logger2.log("This is my second log message");

        System.out.println(logger1.hashCode());
        System.out.println(logger2.hashCode());
        System.out.println("Are instances same : " + (logger1 == logger2));

        /**
         * Lazy Singleton Usage
         */
        LazySingletonLogger logger3 = LazySingletonLogger.getInstance();
        logger3.log("This is my first log message");

        LazySingletonLogger logger4 = LazySingletonLogger.getInstance();
        logger4.log("This is my second log message");

        System.out.println(logger3.hashCode());
        System.out.println(logger4.hashCode());
        System.out.println("Are instances same : " + (logger3 == logger4));
    }
}
