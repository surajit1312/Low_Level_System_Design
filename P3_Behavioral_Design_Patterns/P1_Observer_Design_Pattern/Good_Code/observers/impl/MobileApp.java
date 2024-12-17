package P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Good_Code.observers.impl;

import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Good_Code.observers.IObserver;

public class MobileApp implements IObserver {
    @Override
    public void update(String stockName, double price) {
        System.out.println("MobileApp: " + stockName + " price updated to " + price);
    }
}
