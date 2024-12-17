package P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Bad_Code.stocks;

public class StockPrice {
    private String stockName;
    private double price;

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

    public void setPrice(double price) {
        this.price = price;
    }
}
