package P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Bad_Code.clients;

public class WebApp {
    public void update(String stockName, double price) {
        System.out.println("WebApp: " + stockName + " price updated to " + price);
    }
}
