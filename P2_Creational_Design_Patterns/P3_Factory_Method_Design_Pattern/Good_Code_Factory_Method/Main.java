package P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Factory_Method;

import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Factory_Method.logger.ILogger;
import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Factory_Method.logger.factory.ILoggerFactory;
import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Factory_Method.logger.factory.impl.ErrorLoggerFactory;
import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Factory_Method.logger.factory.impl.InfoLoggerFactory;

public class Main {
    public static void main(String[] args) {
        ILoggerFactory infoLoggerFactory = new InfoLoggerFactory();
        ILogger infoLogger = infoLoggerFactory.createLogger();
        infoLogger.log("This is an info message!");

        ILoggerFactory errorLoggerFactory = new ErrorLoggerFactory();
        ILogger errorLogger = errorLoggerFactory.createLogger();
        errorLogger.log("This is an error message!");
    }
}
