package P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.decorator.concrete;

import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.Pizza;
import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.decorator.ToppingsDecorator;

public class CheeseToppings extends ToppingsDecorator {

    public CheeseToppings(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 50.00;
    }

}
