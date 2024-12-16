package P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Thread_Safe_Singleton.threads;

import P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Thread_Safe_Singleton.logger.ThreadSafeSingletonLogger;

public class SingletonThreadBreaker implements Runnable {

    @Override
    public void run() {
        ThreadSafeSingletonLogger logger = ThreadSafeSingletonLogger.getInstance();
        System.out.println(Thread.currentThread().getName() + " - Logger Instance: " + logger.hashCode());
    }

}
