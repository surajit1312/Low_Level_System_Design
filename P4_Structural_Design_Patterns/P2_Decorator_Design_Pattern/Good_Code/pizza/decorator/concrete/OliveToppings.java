package P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.decorator.concrete;

import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.Pizza;
import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.decorator.ToppingsDecorator;

public class OliveToppings extends ToppingsDecorator {

    public OliveToppings(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with Olives";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 100.00;
    }

}
