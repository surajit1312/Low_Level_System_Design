package P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Bad_Code.pizza.concrete;

import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Bad_Code.pizza.Pizza;

// Margherita Pizza with 'Cheese' toppings
public class MargheritaPizzaWithCheese extends Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza with Cheeze";
    }

    @Override
    public double getCost() {
        return 250.00;
    }
}
