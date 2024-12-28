package P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order;

public abstract class OrderHandler {
    protected OrderHandler nextHandler;

    public OrderHandler(OrderHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void processOrder(String order);
}
