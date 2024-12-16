package P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Breaking_With_MultiThreads.threads;

import P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Breaking_With_MultiThreads.logger.BreakableSingletonLogger;

public class SingletonThreadBreaker implements Runnable {
    @Override
    public void run() {
        BreakableSingletonLogger logger = BreakableSingletonLogger.getInstance();
        System.out.println(Thread.currentThread().getName() + " - Logger Instance: " + logger.hashCode());
    }
}
