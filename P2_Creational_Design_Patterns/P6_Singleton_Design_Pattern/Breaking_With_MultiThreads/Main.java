package P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Breaking_With_MultiThreads;

import P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Breaking_With_MultiThreads.threads.SingletonThreadBreaker;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SingletonThreadBreaker(), "Thread-" + i);
            thread.start();
        }
    }
}
