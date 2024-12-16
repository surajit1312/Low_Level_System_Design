package P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Thread_Safe_Singleton;

import P2_Creational_Design_Patterns.P6_Singleton_Design_Pattern.Thread_Safe_Singleton.threads.SingletonThreadBreaker;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new SingletonThreadBreaker(), "Thread-" + i);
            thread.start();
        }
    }
}
