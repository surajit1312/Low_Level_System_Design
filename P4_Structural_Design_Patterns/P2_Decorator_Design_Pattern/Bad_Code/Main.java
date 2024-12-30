package P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Bad_Code;

import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Bad_Code.pizza.Pizza;
import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Bad_Code.pizza.concrete.FarmhousePizzaWithCheeseAndOlives;
import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Bad_Code.pizza.concrete.MargheritaPizzaWithCheese;

public class Main {
    public static void main(String[] args) {
        // Margherita Pizza with Cheese
        Pizza pizza1 = new MargheritaPizzaWithCheese();
        System.out.println(pizza1.getDescription() + " - Cost: $" + pizza1.getCost());

        // Margherita Pizza with Cheese and Olives
        Pizza pizza2 = new FarmhousePizzaWithCheeseAndOlives();
        System.out.println(pizza2.getDescription() + " - Cost: $" + pizza2.getCost());
    }
}
