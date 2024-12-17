package P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Good_Code;

import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Good_Code.observers.IObserver;
import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Good_Code.observers.impl.MobileApp;
import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Good_Code.observers.impl.WebApp;
import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Good_Code.subject.impl.StockPrice;

public class Main {
    public static void main(String[] args) {
        // Subject call
        StockPrice stockPrice = new StockPrice("AAPL", 100.0);

        // observers
        IObserver mobileApp = new MobileApp();
        IObserver webApp = new WebApp();

        // attaching observers to subject
        stockPrice.attach(mobileApp);
        stockPrice.attach(webApp);

        // State Changes
        stockPrice.updatePrice(105.0);
        stockPrice.updatePrice(115.0);

        // detaching observer from subject
        stockPrice.detach(mobileApp);

        // State Changes
        stockPrice.updatePrice(120.0);
    }
}
