package P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Simple_Factory.logger.impl;

import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Simple_Factory.logger.ILogger;

public class ErrorLogger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println("ERROR : " + message);
    }
}
