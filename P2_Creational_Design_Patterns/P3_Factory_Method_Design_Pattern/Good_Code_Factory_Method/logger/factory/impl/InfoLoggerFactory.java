package P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Factory_Method.logger.factory.impl;

import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Factory_Method.logger.ILogger;
import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Factory_Method.logger.factory.ILoggerFactory;
import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Factory_Method.logger.impl.InfoLogger;

public class InfoLoggerFactory implements ILoggerFactory {
    @Override
    public ILogger createLogger() {
        return new InfoLogger();
    }
}
