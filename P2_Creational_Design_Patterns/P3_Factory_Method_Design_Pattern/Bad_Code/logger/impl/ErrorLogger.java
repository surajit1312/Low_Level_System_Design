package P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Bad_Code.logger.impl;

import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Bad_Code.logger.ILogger;

public class ErrorLogger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println("ERROR : " + message);
    }
}
