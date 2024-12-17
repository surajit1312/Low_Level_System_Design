package P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Bad_Code.exchange;

import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Bad_Code.clients.MobileApp;
import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Bad_Code.clients.WebApp;
import P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Bad_Code.stocks.StockPrice;

public class StockExchange {
    private StockPrice stockPrice;
    private MobileApp mobileApp;
    private WebApp webApp;

    public StockExchange (StockPrice stockPrice, MobileApp mobileApp, WebApp webApp) {
        this.stockPrice = stockPrice;
        this.mobileApp = mobileApp;
        this.webApp = webApp;
    }

    public void updatePrice(double price) {
        stockPrice.setPrice(price);
        notifyClients();
    }

    private void notifyClients() {
        mobileApp.update(stockPrice.getStockName(), stockPrice.getPrice());
        webApp.update(stockPrice.getStockName(), stockPrice.getPrice());
    }
}
