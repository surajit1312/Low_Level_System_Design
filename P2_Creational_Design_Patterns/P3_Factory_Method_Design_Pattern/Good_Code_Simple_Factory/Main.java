package P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Simple_Factory;

import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Simple_Factory.factory.LoggerFactory;
import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Simple_Factory.logger.ILogger;

public class Main {
    public static void main(String[] args) {
        LoggerFactory factory = new LoggerFactory();
        ILogger infoLogger = factory.getLogger("INFO");
        infoLogger.log("This is an error message!");

        ILogger errorLogger = factory.getLogger("ERROR");
        errorLogger.log("This is an info message!");
    }
}
