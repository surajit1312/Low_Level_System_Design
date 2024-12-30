package P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.decorator;

import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.Pizza;

public abstract class ToppingsDecorator extends Pizza {
    protected Pizza pizza;

    public ToppingsDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public abstract String getDescription();
}
