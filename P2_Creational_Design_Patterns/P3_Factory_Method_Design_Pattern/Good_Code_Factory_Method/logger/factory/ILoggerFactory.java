package P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Factory_Method.logger.factory;

import P2_Creational_Design_Patterns.P3_Factory_Method_Design_Pattern.Good_Code_Factory_Method.logger.ILogger;

public interface ILoggerFactory {
    public ILogger createLogger();
}
