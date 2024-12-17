package P3_Behavioral_Design_Patterns.P1_Observer_Design_Pattern.Bad_Code.clients;

public class MobileApp {
    public void update(String stockName, double price) {
        System.out.println("MobileApp: " + stockName + " price updated to " + price);
    }
}
