package P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Bad_Code.pizza.concrete;

import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Bad_Code.pizza.Pizza;

// Farmhouse Pizza with 'Cheese And Olives' toppings
public class FarmhousePizzaWithCheeseAndOlives extends Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza with Cheese And Olives";
    }

    @Override
    public double getCost() {
        return 350.00;
    }
}
