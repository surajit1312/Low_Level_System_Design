package P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Simple_Factory.factory;

import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Simple_Factory.logger.ILogger;
import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Simple_Factory.logger.impl.ErrorLogger;
import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Simple_Factory.logger.impl.InfoLogger;

public class LoggerFactory {
    public ILogger getLogger(String type) {
        switch (type) {
            case "INFO":
                return new InfoLogger();
            case "ERROR":
                return new ErrorLogger();
            default:
                throw new IllegalArgumentException("Invalid argument passed!");
        }
    }
}
