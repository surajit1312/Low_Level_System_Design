package P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Bad_Code;

import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Bad_Code.logger.ILogger;
import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Bad_Code.logger.impl.ErrorLogger;
import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Bad_Code.logger.impl.InfoLogger;

public class Main {
    public static void main(String[] args) {
        ILogger errLogger = new ErrorLogger();
        errLogger.log("This is an error message!");

        ILogger infoLogger = new InfoLogger();
        infoLogger.log("This is an info message!");
    }
}
