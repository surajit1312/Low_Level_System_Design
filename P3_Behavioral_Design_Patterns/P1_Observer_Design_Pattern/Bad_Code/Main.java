package P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Bad_Code;

import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Bad_Code.clients.MobileApp;
import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Bad_Code.clients.WebApp;
import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Bad_Code.exchange.StockExchange;
import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Bad_Code.stocks.StockPrice;

public class Main {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice("AAPL", 100.0);
        MobileApp mobileApp = new MobileApp();
        WebApp webApp = new WebApp();

        StockExchange stockExchange = new StockExchange(stockPrice, mobileApp, webApp);

        stockExchange.updatePrice(150.0);
        stockExchange.updatePrice(160.0);
    }
}
