package P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Good_Code.subject.impl;

import java.util.ArrayList;
import java.util.List;

import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Good_Code.observers.IObserver;
import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Good_Code.subject.ISubject;

public class StockPrice implements ISubject {
    private String stockName;
    private double price;
    private List<IObserver> observers = new ArrayList<IObserver>();

    public StockPrice(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    public String getStockName() {
        return stockName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void attach(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(getStockName(), getPrice());
        }
    }

    public void updatePrice(double price) {
        this.price = price;
        notifyObservers();
    }
}
